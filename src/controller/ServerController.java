package controller;

import java.io.IOException;

import model.ClientModel;
import model.ServerModel;
import network.server.Server;
import network.server.event.ChangeEvent;
import network.server.event.ServerListener;
import view.server.ServerView;

/**
 * ServerChat gère la logique métier du chat côté serveur
 * @author DM
 */
public class ServerController
{
	private ServerModel model;
	private ServerView view;
	
	/**
	 * Construit le chat du serveur
	 * @param model 
	 */
	public ServerController(ServerModel model)
	{
		this.model = model;
		view = new ServerView(this);
		
		model.getServer().addServerListener(view);
		model.getServer().start();
	}
	
	public ServerModel getModel()
	{
		return model;
	}
}
