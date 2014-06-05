package user;

import java.util.ArrayList;

public class UserManager extends ArrayList<User>
{
	private User me;
	
	public UserManager()
	{
		me = new User();
	}
	
	public User getMe()
	{
		return me;
	}
}
