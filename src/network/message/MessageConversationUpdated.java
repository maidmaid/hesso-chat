package network.message;

import java.util.ArrayList;

import user.User;

public class MessageConversationUpdated extends MessageConversation
{
	private static final long serialVersionUID = 1L;

	private User author;
	private String message;
	
	public MessageConversationUpdated(ArrayList<User> users, User author, String message)
	{
		super(users);
		this.author = author;
		this.message = message;
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