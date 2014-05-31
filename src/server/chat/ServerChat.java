package server.chat;

import java.io.IOException;

import server.network.Server;
import server.network.event.ChangeEvent;
import server.network.event.ChangeListener;

/**
 * ServerChat gère la logique métier du chat côté serveur
 * @author DM
 */
public class ServerChat
{
	private Server server;
	
	/**
	 * Construit le chat du serveur
	 */
	public ServerChat()
	{
		server = new Server();
	}
	
	public Server getServer()
	{
		return server;
	}
}
