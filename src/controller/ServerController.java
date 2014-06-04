package controller;

import model.AbstractModel;
import model.ServerModel;
import view.server.ServerView;

/**
 * ServerChat gère la logique métier du chat côté serveur
 * @author DM
 */
public class ServerController extends AbstractController
{
	private ServerView view;
	
	public ServerController(AbstractModel model)
	{
		super(model);
		
		view = new ServerView(this);
		getModel().getServer().addServerListener(view);
		getModel().getServer().start();
	}
	
	public ServerModel getModel()
	{
		return (ServerModel) super.getModel();
	}
}
