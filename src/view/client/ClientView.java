package view.client;

import javax.swing.JFrame;

import network.client.Client;

import controller.ClientController;

public class ClientView extends JFrame
{
	private ClientController controller;
	private ClientConnexionPanel connexionPanel;
	private ClientMessagePanel messagePanel;
	
	public ClientView(ClientController controller)
	{
		this.controller = controller;
		
		connexionPanel = new ClientConnexionPanel();
		messagePanel = new ClientMessagePanel();
		setContentPane(messagePanel);
		
		setTitle("Client Application");
		setSize(400, 330);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		//String message = 
		//controller.getModel().getClient().send(message);
	}
}