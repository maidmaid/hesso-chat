package network.server.event;

import java.util.EventObject;

/**
 * Event which indicates that an client connected occured.
 * @author DM
 */
public class ClientEvent extends EventObject
{
	/**
	 * Constructs an ClientEvent object.
	 */
	public ClientEvent(Object source)
	{
		super(source);
	}
}
