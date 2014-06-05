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
		
		getModel().getClient().addClientListener(view);
		getModel().getClient().addClientListener(view.getConnexionPanel());
		getModel().getClient().addClientListener(view.getMessagePanel());
	}
	
	@Override
	public ClientModel getModel()
	{
		return (ClientModel) super.getModel();
	}
}
