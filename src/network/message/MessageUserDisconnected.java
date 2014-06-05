package network.message;

import user.User;

public class MessageUserDisconnected extends AbstractMessageUser
{
	private static final long serialVersionUID = 1L;

	public MessageUserDisconnected(User user)
	{
		super(user);
	}
}
