package controller;

import model.AbstractModel;
import model.ClientModel;
import view.client.ClientConnexionPanel;
import view.client.ClientMessagePanel;
import view.client.ClientView;


public class ClientController extends AbstractController
{
	private ClientView view;
	
	public ClientController(AbstractModel model)
	{
		super(model);
		view = new ClientView(this);
	}
	
	@Override
	public ClientModel getModel()
	{
		return (ClientModel) super.getModel();
	}
}
