package server.network;

import java.util.ArrayList;

import server.network.event.ChangeEvent;
import server.network.event.ChangeListener;

/**
 * Server abstact
 * @author DM
 */
public abstract class ServerAbstract
{
	protected ArrayList<ChangeListener> changeListeners;
	private State state;
	private String stateMessage;
	
	public enum State 
	{
		ENABLE,
		DISABLE,
		PENDING
	}
	
	/**
	 * Constructs an ServerAbstract object
	 */
	public ServerAbstract()
	{
		changeListeners = new ArrayList<ChangeListener>();
		setState(State.DISABLE);
	}
	
	/**
	 * Adds an <code>ChangeListener</code> to the server
	 */
	public void addChangeListener(ChangeListener l)
	{
		changeListeners.add(l);
	}
	
	/**
	 * Removes an <code>ChangeListener</code> from the server
	 */
	public void removeChangeListener(ChangeListener l)
	{
		changeListeners.remove(l);
	}
	
	/**
	 * Returns an list of all the <code>ChangeListener</code>s added
	 */
	public ArrayList<ChangeListener> getChangeListeners()
	{
		return changeListeners;
	}
	
	/**
	 * Notifies all listeners that state changed
	 */
	public void fireStateChanged()
	{
		for (ChangeListener l : changeListeners)
		{
			ChangeEvent e = new ChangeEvent(this);
			l.stateChanged(e);
		}
		
		stateMessage = "";
	}
	
	protected void setState(State state, String message)
	{
		stateMessage = message;
		setState(state);
	}
	
	/**
	 * Set state
	 * @param state state server
	 */
	protected void setState(State state)
	{
		this.state = state;
		fireStateChanged();
	}
	
	/**
	 * Get state
	 * @return state
	 */
	public State getState()
	{
		return state;
	}
	
	public String getStateMessage()
	{
		return stateMessage;
	}
}