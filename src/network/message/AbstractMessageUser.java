package network.message;

import user.User;

public abstract class AbstractMessageUser extends AbstractMessage
{
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public AbstractMessageUser(User user)
	{
		super();
		this.user = user;
	}
	
	public User getUser()
	{
		return user;
	}
}
