package network.message;

import user.User;

public class MessageUserChanged extends AbstractMessageUser
{
	private static final long serialVersionUID = 1L;

	public MessageUserChanged(User user)
	{
		super(user);
	}
}
