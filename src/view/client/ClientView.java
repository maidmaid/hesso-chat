package view.client;

import javax.swing.JFrame;

import network.client.event.DisconnectionEvent;
import network.client.event.MessageEvent;
import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.MessageUserDisconnected;
import user.User;
import view.client.table.UsersTable;
import controller.AbstractController;

public class ClientView extends AbstractClientView
{
	private JFrame frame;
	private ClientConnexionPanel pnlConnexion;
	private ClientMessagePanel pnlMessage;
	private UsersTable pnlUsers;

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
		pnlUsers = new UsersTable(controller);
		frame.setContentPane(pnlConnexion.getContainer());
		//frame.setContentPane(messagePanel.getContainer());
		//frame.setContentPane(pnlUsers.getContainer());
		
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

	public UsersTable getUsersPanel()
	{
		return pnlUsers;
	}
	
	@Override
	public void messageReceived(MessageEvent e)
	{
		System.out.println("message recu : " + e.getMessage());
	}

	@Override
	public void connexionEstablished()
	{
		frame.setContentPane(pnlUsers.getContainer());
	}

	@Override
	public void idAssigned(MessageIdAssigned message)
	{
		
	}

	@Override
	public void userChanged(MessageUserChanged message) {
		// TODO Auto-generated method stub
		User u = message.getUser();
	}

	@Override
	public void disconnectionOccured(DisconnectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userDisconnected(MessageUserDisconnected message) {
		User u = message.getUser();
		
	}

}