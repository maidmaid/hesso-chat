package view.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

import javax.swing.JFrame;

import network.client.event.DisconnectionEvent;
import network.client.event.MessageEvent;
import network.message.MessageConversationOpened;
import network.message.MessageConversationUpdated;
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
	private UsersTable pnlUsers;
	private Hashtable<Integer, ClientMessageFrame> messageFrameList;
	
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
		messageFrameList = new Hashtable<Integer,ClientMessageFrame>();
		
		pnlConnexion = new ClientConnexionPanel(controller);
		pnlUsers = new UsersTable(controller);
		frame.setContentPane(pnlConnexion.getContainer());

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

	@Override
	public void conversationOpened(MessageConversationOpened message)
	{
		User me = getController().getModel().getUserManager().getMe();
		User user = message.getOtherThanId(me.getId());
		Integer id = user.getId();
		System.out.println(id);
		
		if(message.getAuthor().getId() == me.getId() && !messageFrameList.containsKey(id))
		{
			ClientMessageFrame frame = new ClientMessageFrame(getController());
			frame.getFrame().addWindowListener(new MessageFrameCloseListener(id));
			messageFrameList.put(id, frame);
			
			// Listener
			getController().getModel().getMessageDecoder().addMessageListener(frame);
		}
	}

	private class MessageFrameCloseListener extends WindowAdapter
	{
		private int id;
		
		public MessageFrameCloseListener(int id)
		{
			this.id = id;
		}
		
		@Override
		public void windowClosed(WindowEvent e)
		{
			messageFrameList.remove(id);
		}
	}
	
	@Override
	public void conversationUpdated(MessageConversationUpdated message)
	{
		
	}
}