package network.server.event;

/**
 * The listener interface for receiving change events.
 * @author DM
 */
public interface ServerListener
{
	/**
	 * Invoked when an change state occurs.
	 */
	void stateChanged(ChangeEvent e);
	
	/**
	 * Invoked when an connection client occurs.
	 */
	void clientConnected(ClientEvent e);
}
