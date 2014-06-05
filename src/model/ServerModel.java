package model;

import user.User;
import user.UserManager;
import network.client.Client;
import network.client.event.MessageEvent;
import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.decoder.MessageDecoder;
import network.message.event.MessageListener;
import network.server.Server;
import network.server.event.ChangeEvent;
import network.server.event.ClientEvent;
import network.server.event.ServerListener;

public class ServerModel extends AbstractModel
{
	private Server server;
	private UserManager users;
	private MessageDecoder decoder;
	private int id;
	
	public ServerModel()
	{
		id = 0;
		users = new UserManager();
		
		decoder = new MessageDecoder();
		decoder.addMessageListener(new MessageModelListener());
		
		server = new Server();
		server.addServerListener(new ServerModelListener());
	}
	
	public Server getServer()
	{
		return server;
	}
	
	public MessageDecoder getMessageDecoder()
	{
		return decoder;
	}
	
	private int generateId()
	{
		return id++;
	}
	
	private class ServerModelListener implements ServerListener
	{
		@Override
		public void stateChanged(ChangeEvent e)
		{
			
		}

		@Override
		public void clientConnected(ClientEvent e)
		{
			Client client = e.getClient();
			client.addClientListener(new ClientInServerListener());
					
			// Assignes an unique ID to client connected
			int id = generateId();
			MessageIdAssigned messageIdAssigned = new MessageIdAssigned(id);
			client.send(messageIdAssigned.serialize());
			
			// Send to client connected the list of other client
			for (User user : users)
			{
				MessageUserChanged messageUserChanged = new MessageUserChanged(user);
				client.send(messageUserChanged.serialize());
			}
		}
		
		private class ClientInServerListener implements network.client.event.ClientListener
		{
			public void messageReceived(MessageEvent e)
			{
				decoder.decode(e.getMessage());
			}

			public void connexionEstablished()
			{
				// Not used
			}
		}
	}
	
	private class MessageModelListener implements MessageListener
	{
		@Override
		public void idAssigned(MessageIdAssigned message)
		{
			// Not used
		}

		@Override
		public void userChanged(MessageUserChanged message)
		{
			users.updateUser(message.getUser());
		}
	}
}
