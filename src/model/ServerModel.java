package model;

import network.server.Server;

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
}
