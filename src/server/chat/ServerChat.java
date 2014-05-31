package server.chat;

import java.io.IOException;

import server.network.Server;

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
		try
		{
			server = new Server();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
