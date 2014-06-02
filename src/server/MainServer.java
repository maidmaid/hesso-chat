package server;

import server.controller.ServerController;
import server.view.ServerFrame;

/**
 * MainServer exécute le serveur de chat
 * @author DM
 */
public class MainServer
{
	/**
	 * Exécute le serveur de caht
	 * @param args
	 */
	public static void main(String[] args)
	{
		new ServerController();
	}
}
