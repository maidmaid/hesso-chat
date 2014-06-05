package network.client.event;

import java.util.EventObject;

public class DisconnectionEvent extends EventObject
{
	private String message;
	
	public DisconnectionEvent(Object source, String message)
	{
		super(source);
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
}
