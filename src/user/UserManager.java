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
	
	public User getUser(int id)
	{
		for (User user : this)
		{
			if(user.getId() == id)
			{
				return user;
			}
		}
		
		return null;
	}
	
	public void updateUser(User user)
	{
		User u = getUser(user.getId());
		
		if(u == null)
		{
			add(u);
		}
		else
		{
			u.setUsername(user.getUsername());
		}
	}
}
