package network.server;

import java.util.ArrayList;

import network.server.event.ChangeEvent;
import network.server.event.ClientEvent;
import network.server.event.ServerListener;


/**
 * Server abstact
 * @author DM
 */
public abstract class AbstractServer
{
	protected ArrayList<ServerListener> listeners;
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
	public AbstractServer()
	{
		listeners = new ArrayList<ServerListener>();
		setState(State.DISABLE);
	}
	
	/**
	 * Adds an <code>ServerListener</code> to the server
	 */
	public void addServerListener(ServerListener l)
	{
		listeners.add(l);
	}
	
	/**
	 * Removes an <code>ServerListener</code> from the server
	 */
	public void removeServerListener(ServerListener l)
	{
		listeners.remove(l);
	}
	
	/**
	 * Returns an list of all the <code>ChangeListener</code>s added
	 */
	public ArrayList<ServerListener> getServerListeners()
	{
		return listeners;
	}
	
	/**
	 * Notifies all listeners that state changed
	 */
	public void fireStateChanged()
	{
		for (ServerListener l : listeners)
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
	
	/**
	 * Notifies all listeners that client connected
	 */
	public void fireClientConnected()
	{
		for (ServerListener l : listeners)
		{
			ClientEvent e = new ClientEvent(this);
			l.clientConnected(e);
		}
	}
}