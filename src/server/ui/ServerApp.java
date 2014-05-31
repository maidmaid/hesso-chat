package server.ui;

import javax.swing.JFrame;

import server.chat.ServerChat;

/**
 * ServerApp est l'application chat côté serveur
 * @author DM
 */
public class ServerApp extends JFrame
{
	private ServerChat chat;
	
	/**
	 * Construit l'application chat côté serveur
	 */
	public ServerApp()
	{
		// Paramètre la JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 600);
		setVisible(true);
		setTitle("Serveur de chat");
		
		chat = new ServerChat();
	}
}
