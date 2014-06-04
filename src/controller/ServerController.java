package controller;

import java.io.IOException;

import network.server.Server;
import network.server.event.ChangeEvent;
import network.server.event.ServerListener;

import view.server.ServerFrame;

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
