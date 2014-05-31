package server.network.event;

/**
 * The listener interface for receiving change events.
 * @author DM
 */
public interface ChangeListener
{
	/**
	 * Invoked when an change state occurs.
	 */
	void stateChanged(ChangeEvent e);
}
