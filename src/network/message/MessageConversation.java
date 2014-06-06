package network.message;

import java.util.ArrayList;

import user.User;

public class MessageConversation extends AbstractMessage
{
	private static final long serialVersionUID = 1L;

	private ArrayList<User> users;
	
	public MessageConversation(ArrayList<User> users)
	{
		super();
		this.users = users;
	}
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
	
	public User getOtherThanId(int id)
	{
		for (User user : users)
		{
			if(user.getId() != id)
			{
				return user;
			}
		}
		
		return null;
	}
}
