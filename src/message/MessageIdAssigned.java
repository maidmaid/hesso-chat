package message;

public class MessageIdAssigned extends MessageAbstract
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	public MessageIdAssigned(int id)
	{
		super();
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
}
