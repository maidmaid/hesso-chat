package model;

import message.MessageIdAssigned;
import network.server.Server;
import network.server.event.ChangeEvent;
import network.server.event.ClientEvent;
import network.server.event.ServerListener;

public class ServerModel extends AbstractModel
{
	private Server server;
	private int id;
	
	public ServerModel()
	{
		id = 0;
		server = new Server();
		server.addServerListener(new ServerModelListener());
	}
	
	public Server getServer()
	{
		return server;
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
			id++;
			MessageIdAssigned message = new MessageIdAssigned(id);
			e.getClient().send(message.serialize());
			System.out.println(id);
		}
	}
}
