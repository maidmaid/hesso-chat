package network.message;

import java.util.ArrayList;

import user.User;

public class MessageConversationOpened extends AbstractMessage
{
	private static final long serialVersionUID = 1L;

	private ArrayList<User> users;
	
	public MessageConversationOpened(ArrayList<User> users)
	{
		super();
		this.users = users;
	}
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
}
