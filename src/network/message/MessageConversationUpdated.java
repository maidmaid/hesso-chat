package network.message;

import java.util.ArrayList;

import user.User;

public class MessageConversationUpdated extends MessageConversation
{
	private static final long serialVersionUID = 1L;

	
	private String message;
	
	public MessageConversationUpdated(ArrayList<User> users, User author, String message)
	{
		super(users, author);
		this.message = message;
	}	
	
	
	public String getMessage()
	{
		return message;
	}
}