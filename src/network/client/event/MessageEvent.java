package network.client.event;

import java.util.EventObject;

public class MessageEvent extends EventObject
{
	String message;

	public MessageEvent(Object source, String message)
	{
		super(source);
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
}
