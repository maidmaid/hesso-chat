package message;

public class MessageNewUser extends MessageAbstract
{
	private static final long serialVersionUID = 1L;
	
	private String username;
	
	public MessageNewUser(String username)
	{
		super();
		this.username = username;
	}
	
	public String getUsername()
	{
		return username;
	}
}
