package server.controller;

import java.io.IOException;

import server.network.Server;
import server.network.event.ChangeEvent;
import server.network.event.ServerListener;
import server.view.ServerFrame;

/**
 * ServerChat gère la logique métier du chat côté serveur
 * @author DM
 */
public class ServerController
{
	private Server server;
	private ServerFrame app;
	
	/**
	 * Construit le chat du serveur
	 */
	public ServerController()
	{
		server = new Server();
		app = new ServerFrame();
		
		server.addServerListener(app);
		server.start();
	}
}
