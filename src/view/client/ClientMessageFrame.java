package view.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import user.User;
import model.ClientModel;
import network.client.event.DisconnectionEvent;
import network.client.event.MessageEvent;
import network.message.MessageConversationOpened;
import network.message.MessageConversationUpdated;
import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.MessageUserDisconnected;
import network.message.event.MessageListener;
import controller.AbstractController;
import controller.ClientController;


public class ClientMessageFrame extends AbstractClientView implements ActionListener
{
	//private JPanel pnlContainer;
	private JFrame messageFrame;
	private JPanel pnlContainer;
	private String message;
	private String readText;
	private JTextArea areInputMessage;
	private JTextArea areReadMessage;
	private JPanel pnlInputMessage;
	private JPanel pnlReadMessage;
	private JLabel lblReadMessage;
	private JLabel lblInputMessage;
	private JButton btnEnterMessage;
	private User user;
	
	/**
	 *CHOICE ELEMENT'S PREFIXING :
	 * 
	 * JPanel		:	pnl
	 * JTextField	:	fld
	 * JLabel		:	lbl
	 * JButton 		:	btn
	 * JTextArea	:	are
	 * */
	
	public ClientMessageFrame(AbstractController controller, User user)
	{	
		super(controller);
		this.user = user;
		
		pnlContainer = new JPanel();
		messageFrame = new JFrame();
		messageFrame.setContentPane(pnlContainer);
		
		messageFrame.setTitle("Client Application");
		messageFrame.setSize(400, 600);
		messageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		messageFrame.setLocationRelativeTo(null);
		messageFrame.setResizable(false);
		messageFrame.addWindowListener(new FrameClosedListener(this));
		
		lblReadMessage = new JLabel("Message received : ");
		lblReadMessage.setVisible(true);
		pnlContainer.add(this.lblReadMessage, BorderLayout.NORTH);
		
		areReadMessage = new JTextArea();
		Font police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		areReadMessage.setFont(police);
		areReadMessage.setBackground(Color.gray);
		areReadMessage.setPreferredSize(new Dimension(280,150));
		areReadMessage.setMargin(null);           
		areReadMessage.setBorder(BorderFactory.createEmptyBorder());
		//readMessage.setEditable(false);
		pnlContainer.add(new JScrollPane(areReadMessage));
		
		pnlReadMessage = new JPanel();
		pnlReadMessage.setPreferredSize(new Dimension(360,200));
		pnlReadMessage.setBackground(Color.gray);
		
		pnlReadMessage.add(areReadMessage);
		pnlReadMessage.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		pnlContainer.add(pnlReadMessage, BorderLayout.CENTER);
		
		lblInputMessage = new JLabel("Send a Message : ");
		lblInputMessage.setVisible(true);
		pnlContainer.add(this.lblInputMessage, BorderLayout.NORTH);
		
		areInputMessage = new JTextArea(" ");
		police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		areInputMessage.setFont(police);
		areInputMessage.setEditable(true);
		areInputMessage.setBackground(Color.white);
		areInputMessage.setPreferredSize(new Dimension(280,150));
		areInputMessage.setMargin(null);           
		areInputMessage.setBorder(BorderFactory.createEmptyBorder());
		pnlContainer.add(new JScrollPane(areInputMessage));
		
		pnlInputMessage = new JPanel();
		pnlInputMessage.setPreferredSize(new Dimension(360,200));
		pnlInputMessage.setBackground(Color.white);
		
		pnlInputMessage.add(areInputMessage);
		pnlInputMessage.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		pnlContainer.add(pnlInputMessage, BorderLayout.CENTER);
		
		btnEnterMessage = new JButton("Send Message");
		pnlContainer.add(btnEnterMessage, BorderLayout.CENTER);
		btnEnterMessage.setPreferredSize(new Dimension(360, 60));
		btnEnterMessage.addActionListener(this);
		
		messageFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnEnterMessage)
		{
			message = areInputMessage.getText();
			getController().conversationUpdated(user.getId(), message);
		}
	}
	
	public void readMessage()
	{
		areReadMessage.setText(message);
	}
	
//	public JPanel getContainer()
//	{
//		return pnlContainer;
//	}
	
	public JFrame getFrame()
	{
		return messageFrame;
	}

	@Override
	public void messageReceived(MessageEvent e)
	{
		
	}

	private class FrameClosedListener extends WindowAdapter
	{
		private MessageListener listener;
		
		public FrameClosedListener(MessageListener listener)
		{
			this.listener = listener;
		}
		
		@Override
		public void windowClosed(WindowEvent e)
		{
			super.windowClosed(e);
			getController().getModel().getMessageDecoder().removeMessageListener(listener);
		}
	}
	
	@Override
	public void connexionEstablished() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void idAssigned(MessageIdAssigned message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userChanged(MessageUserChanged message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnectionOccured(DisconnectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userDisconnected(MessageUserDisconnected message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void conversationOpened(MessageConversationOpened message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void conversationUpdated(MessageConversationUpdated message)
	{
		String username = message.getAuthor().getUsername();
		String msg = message.getMessage();
		areReadMessage.append(username + ": " + msg);
	}
}
