package server.chat;

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
		server = new Server();
	}
}
