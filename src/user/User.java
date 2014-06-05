package user;

import java.io.Serializable;

public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	
	public User()
	{
		setId(-1);
		setUsername("Kok");
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getUsername()
	{
		return username;
	}
}
