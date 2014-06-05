package user;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import network.client.Client;

public class UserManager extends ArrayList<User>
{
	private User me;
	private HashMap<User, Client> mapClient;
	
	public UserManager()
	{
		me = new User();
		mapClient = new HashMap<User, Client>();
	}
	
	public User getMe()
	{
		return me;
	}
	
	public User getById(int id)
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
	
	public void link(User user, Client client)
	{
		mapClient.put(user, client);
	}
	
	public void unlink(User user)
	{
		mapClient.remove(user);
	}
	
	public User get(Client client)
	{
		for (Object o : mapClient.keySet())
		{
			if(mapClient.get(o) == client)
			{
				return (User) o;
			}
		}
		
		return null;
	}
	
	public User remove(User user)
	{
		User u = getById(user.getId());
		remove((Object) u);
		return u;
	}
	
	public void updateUser(User user)
	{
		User u = getById(user.getId());
		
		if(u == null)
		{
			add(user);
		}
		else
		{
			u.setUsername(user.getUsername());
		}
	}
}
