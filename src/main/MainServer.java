package main;

import model.ServerModel;
import controller.ServerController;
import view.server.ServerView;

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
		ServerModel model = new ServerModel();
		ServerController controller = new ServerController(model);
	}
}
