package model;

import network.server.Server;

public class ServerModel
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
