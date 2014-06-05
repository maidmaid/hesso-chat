package network.message;

import user.User;

public class MessageUserChanged extends MessageAbstract
{
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public MessageUserChanged(User user)
	{
		super();
		this.user = user;
	}
	
	public User getUser()
	{
		return user;
	}
}
