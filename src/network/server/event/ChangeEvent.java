package network.server.event;

import java.util.EventObject;

/**
 * Event which indicates that the server state change occured.
 * @author DM
 */
public class ChangeEvent extends EventObject
{
	/**
	 * Constructs an ChangeEvent object.
	 */
	public ChangeEvent(Object source)
	{
		super(source);
	}
}
