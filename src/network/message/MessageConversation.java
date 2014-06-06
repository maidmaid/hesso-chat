package network.message;

import java.util.ArrayList;

import user.User;

public class MessageConversation extends AbstractMessage
{
	private static final long serialVersionUID = 1L;

	private ArrayList<User> users;
	private User author;
	
	public MessageConversation(ArrayList<User> users, User author)
	{
		super();
		this.users = users;
		this.author = author;
	}
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
	public User getAuthor()
	{
		return author;
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
