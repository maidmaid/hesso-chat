package network.client.event;

public interface ClientListener
{
	public void messageReceived(MessageEvent e);
	public void connexionEstablished();
}
