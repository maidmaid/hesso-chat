package model;

import message.MessageIdAssigned;
import message.MessageNewUser;
import message.decoder.MessageDecoder;
import message.event.MessageListener;
import network.client.Client;
import network.client.event.ClientListener;
import network.client.event.MessageEvent;

public class ClientModel extends AbstractModel
{
	private Client client;
	private MessageDecoder decoder;
	
	public ClientModel() 
	{
		// Client
		client = new Client();
		client.addClientListener(new ClientModelListener());
		
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
	}
	
	private class ClientMessageListener implements MessageListener
	{
		@Override
		public void newUserReceived(MessageNewUser message)
		{
			
		}

		@Override
		public void idAssigned(MessageIdAssigned message)
		{
			System.out.println("id attribué " + message.getId());
		}
	}
}
