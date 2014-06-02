package client.ui;

import javax.swing.JFrame;

import client.chat.ClientChat;
import client.network.Client;

public class ClientApp  extends JFrame
{
	private ClientChat chat;	
	private ClientConnexion clientConnexion;
	private ClientMessage clientMessage;

	public ClientApp()
	{
		clientConnexion = new ClientConnexion();
		clientMessage = new ClientMessage();
		chat = new ClientChat();
		
		this.setTitle("Client Application");
		this.setSize(400, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//this.setContentPane(clientConnexion);
		this.setContentPane(clientMessage);
		this.setVisible(true);
	}
}