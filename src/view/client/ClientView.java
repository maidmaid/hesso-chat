package view.client;

import javax.swing.JFrame;

import network.client.event.MessageEvent;
import controller.AbstractController;

public class ClientView extends AbstractClientView
{
	private JFrame frame;
	private ClientConnexionPanel connexionPanel;
	private ClientMessagePanel messagePanel;
	
	public ClientView(AbstractController controller)
	{
		super(controller);
		
		frame = new JFrame();
		
		connexionPanel = new ClientConnexionPanel(controller);
		messagePanel = new ClientMessagePanel(controller);
		frame.setContentPane(connexionPanel.getContainer());
		//frame.setContentPane(messagePanel.getContainer());
		
		frame.setTitle("Client Application");
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public ClientConnexionPanel getConnexionPanel()
	{
		return connexionPanel;
	}
	
	public ClientMessagePanel getMessagePanel()
	{
		return messagePanel;
	}

	@Override
	public void messageReceived(MessageEvent e)
	{
		
	}
}