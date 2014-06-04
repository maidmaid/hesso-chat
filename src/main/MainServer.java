package main;

import controller.ServerController;
import view.server.ServerFrame;

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
