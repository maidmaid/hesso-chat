package controller;

import model.ClientModel;
import view.client.ClientConnexionPanel;
import view.client.ClientMessagePanel;
import view.client.ClientView;


public class ClientController
{
	private ClientModel model;
	private ClientView view;
	
	public ClientController(ClientModel model)
	{
		this.model = model;
		view = new ClientView(this);
	}
	
	public ClientModel getModel()
	{
		return model;
	}
}
