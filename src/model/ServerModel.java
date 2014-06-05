package model;

import network.server.Server;
import network.server.event.ChangeEvent;
import network.server.event.ClientEvent;
import network.server.event.ServerListener;

public class ServerModel extends AbstractModel
{
	private Server server;
	
	public ServerModel()
	{
		server = new Server();
	}
	
	public Server getServer()
	{
		return server;
	}
	
	private class ServerModelAction implements ServerListener
	{
		@Override
		public void stateChanged(ChangeEvent e)
		{
			
		}

		@Override
		public void clientConnected(ClientEvent e)
		{
			e.getClient().send("coucou");
		}
	}
}
