package model;

import user.User;
import user.UserManager;
import network.client.Client;
import network.client.event.DisconnectionEvent;
import network.client.event.MessageEvent;
import network.message.MessageConversationOpened;
import network.message.MessageConversationUpdated;
import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.MessageUserDisconnected;
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
			// TODO ?
		}

		@Override
		public void clientConnected(ClientEvent e)
		{
			Client client = e.getClient();
			client.addClientListener(new ClientInServerListener());
					
			// Generates an unique ID for client
			int id = generateId();
			
			// Assignes an unique ID to client connected
			User user = new User();
			user.setId(id);
			users.add(user);
			users.link(user, client);
			
			// Send le unique ID to the client
			MessageIdAssigned messageIdAssigned = new MessageIdAssigned(id);
			client.send(messageIdAssigned.serialize());
			
			// Send to client connected the list of other client
			for (User u : users)
			{
				MessageUserChanged messageUserChanged = new MessageUserChanged(u);
				client.send(messageUserChanged.serialize());
			}
		}
		
		private class ClientInServerListener implements network.client.event.ClientListener
		{
			public void messageReceived(MessageEvent e)
			{
				server.broadcast(e.getMessage());
				decoder.decode(e.getMessage());
			}

			public void connexionEstablished()
			{
				// Not used
			}

			@Override
			public void disconnectionOccured(DisconnectionEvent e)
			{
				Client client = (Client) e.getSource();
				User user = users.get(client);
				
				MessageUserDisconnected message = new MessageUserDisconnected(user);
				decoder.fireUserDisconnected(message);
				server.multicast(message.serialize(), client);	
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

		@Override
		public void userDisconnected(MessageUserDisconnected message)
		{
			User user = message.getUser();
			users.unlink(user);
			users.remove(user);
		}

		@Override
		public void conversationOpened(MessageConversationOpened message)
		{
			// TODO Send archives conversation	
		}

		@Override
		public void conversationUpdated(MessageConversationUpdated message)
		{
			// TODO Auto-generated method stub
		}
	}
}
