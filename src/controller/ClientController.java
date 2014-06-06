package controller;

import java.util.ArrayList;

import network.message.MessageConversationOpened;
import network.message.MessageConversationUpdated;
import model.AbstractModel;
import model.ClientModel;
import user.User;
import user.UserManager;
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
		getModel().getClient().addClientListener(view.getUsersPanel());
		
		// Views are listeners of MessageDecoder
		getModel().getMessageDecoder().addMessageListener(view);
		getModel().getMessageDecoder().addMessageListener(view.getConnexionPanel());
		getModel().getMessageDecoder().addMessageListener(view.getMessagePanel());
		getModel().getMessageDecoder().addMessageListener(view.getUsersPanel());
	}
	
	@Override
	public ClientModel getModel()
	{
		return (ClientModel) super.getModel();
	}
	
	/**
	 * Open a conversation
	 * @param id ID of User
	 */
	public void conversationOpened(int id)
	{
		UserManager manager = getModel().getUserManager();
		User me = manager.getMe();
		User user = manager.getById(id);
		
		ArrayList<User> users = new ArrayList<User>();
		users.add(me);
		users.add(user);
		
		MessageConversationOpened message = new MessageConversationOpened(users);
		getModel().getClient().send(message.serialize());
	}
	
	/**
	 * Send a message in the conversation
	 * @param id ID of user
	 * @param message message
	 */
	public void conversationUpdated(int id, String message)
	{
		UserManager manager = getModel().getUserManager();
		User author = manager.getMe();
		User user = manager.getById(id);
		
		ArrayList<User> users = new ArrayList<User>();
		users.add(author);
		users.add(user);
		
		MessageConversationUpdated m = new MessageConversationUpdated(users, author, message);
		getModel().getClient().send(m.serialize());
	}
}
