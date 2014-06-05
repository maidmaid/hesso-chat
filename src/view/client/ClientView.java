package view.client;

import javax.swing.JFrame;

import network.client.event.MessageEvent;
import controller.AbstractController;

public class ClientView extends AbstractClientView
{
	private JFrame frame;
	private ClientConnexionPanel pnlConnexion;
	private ClientMessagePanel pnlMessage;

	/**
	 *CHOICE ELEMENT'S PREFIXING :
	 * 
	 * JPanel		:	pnl
	 * JTextField	:	fld
	 * JLabel		:	lbl
	 * JButton 		:	btn
	 * JTextArea	:	are
	 * */
	
	public ClientView(AbstractController controller)
	{
		super(controller);
		
		frame = new JFrame();
		
		pnlConnexion = new ClientConnexionPanel(controller);
		pnlMessage = new ClientMessagePanel(controller);
		frame.setContentPane(pnlConnexion.getContainer());
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
		return pnlConnexion;
	}
	
	public ClientMessagePanel getMessagePanel()
	{
		return pnlMessage;
	}

	@Override
	public void messageReceived(MessageEvent e)
	{
		System.out.println("message recu");
	}

	@Override
	public void connexionEstablished()
	{
		frame.setContentPane(pnlMessage.getContainer());
	}
}