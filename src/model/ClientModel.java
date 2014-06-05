package model;

import user.User;
import user.UserManager;
import network.client.Client;
import network.client.event.ClientListener;
import network.client.event.DisconnectionEvent;
import network.client.event.MessageEvent;
import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.MessageUserDisconnected;
import network.message.decoder.MessageDecoder;
import network.message.event.MessageListener;

public class ClientModel extends AbstractModel
{
	private Client client;
	private UserManager users;
	private MessageDecoder decoder;
	
	public ClientModel() 
	{
		// Client
		client = new Client();
		client.addClientListener(new ClientModelListener());
		
		// User
		users = new UserManager();
		
		// Decoder
		decoder = new MessageDecoder();
		decoder.addMessageListener(new ClientMessageListener());
	}
	
	public Client getClient()
	{
		return client;
	}
	
	public MessageDecoder getMessageDecoder()
	{
		return decoder;
	}
	
	private class ClientModelListener implements ClientListener
	{
		@Override
		public void messageReceived(MessageEvent e)
		{
			decoder.decode(e.getMessage());
		}

		@Override
		public void connexionEstablished()
		{
			// Not used
		}

		@Override
		public void disconnectionOccured(DisconnectionEvent e)
		{
			// TODO Auto-generated method stub	
		}
	}
		
	private class ClientMessageListener implements MessageListener
	{
		@Override
		public void idAssigned(MessageIdAssigned message)
		{
			User me = users.getMe();
			me.setId(message.getId());
			
			MessageUserChanged messageUserChanged = new MessageUserChanged(me);
			client.send(messageUserChanged.serialize());
		}

		@Override
		public void userChanged(MessageUserChanged message)
		{
			users.updateUser(message.getUser());
		}

		@Override
		public void userDisconnected(MessageUserDisconnected message)
		{
			// TODO Auto-generated method stub	
		}
	}
}
