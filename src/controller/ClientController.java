package controller;

import model.AbstractModel;
import model.ClientModel;
import view.client.ClientView;

public class ClientController extends AbstractController
{
	private ClientView view;
	
	public ClientController(AbstractModel model)
	{
		super(model);
		view = new ClientView(this);
		
		// Views are listeners of Client
		getModel().getClient().addClientListener(view);
		getModel().getClient().addClientListener(view.getConnexionPanel());
		getModel().getClient().addClientListener(view.getMessagePanel());
		
		// Views are listeners of MessageDecoder
		getModel().getMessageDecoder().addMessageListener(view);
		getModel().getMessageDecoder().addMessageListener(view.getConnexionPanel());
		getModel().getMessageDecoder().addMessageListener(view.getMessagePanel());
	}
	
	@Override
	public ClientModel getModel()
	{
		return (ClientModel) super.getModel();
	}
}
