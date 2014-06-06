package network.message;

import java.util.ArrayList;

import user.User;

public class MessageConversationOpened extends MessageConversation
{
	private static final long serialVersionUID = 1L;
	
	public MessageConversationOpened(ArrayList<User> users, User author)
	{
		super(users, author);
	}
}
