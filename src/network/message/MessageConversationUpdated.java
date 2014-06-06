package network.message;

import java.util.ArrayList;

import user.User;

public class MessageConversationUpdated extends AbstractMessage
{
	private static final long serialVersionUID = 1L;

	private ArrayList<User> users;
	private User author;
	private String message;
	
	public MessageConversationUpdated(ArrayList<User> users, User author, String message)
	{
		super();
		this.users = users;
		this.author = author;
		this.message = message;
	}
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
	
	public User getAuthor()
	{
		return author;
	}
	
	public String getMessage()
	{
		return message;
	}
}
