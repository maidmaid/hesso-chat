package view.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import network.client.Client;
import network.client.event.MessageEvent;
import controller.AbstractController;


public class ClientMessagePanel extends AbstractClientView implements ActionListener
{
	private JPanel pnlContainer;
	private String frameName = "Message Client";
	private String message;
	private String readText;
	private JTextArea areInputMessage;
	private JTextArea areReadMessage;
	private JPanel pnlInputMessage;
	private JPanel pnlReadMessage;
	private JLabel lblReadMessage;
	private JLabel lblInputMessage;
	private JButton btnEnterMessage;
	
	/**
	 *CHOICE ELEMENT'S PREFIXING :
	 * 
	 * JPanel		:	pnl
	 * JTextField	:	fld
	 * JLabel		:	lbl
	 * JButton 		:	btn
	 * JTextArea	:	are
	 * */
	
	public ClientMessagePanel(AbstractController controller)
	{	
		super(controller);
		
		pnlContainer = new JPanel();
		
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
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnEnterMessage)
		{
			message = areInputMessage.getText();
		}
	}
	
	public void readMessage()
	{
		areReadMessage.setText(message);
	}
	
	public JPanel getContainer()
	{
		return pnlContainer;
	}

	@Override
	public void messageReceived(MessageEvent e)
	{
		
	}

	@Override
	public void connexionEstablished() {
		// TODO Auto-generated method stub
		
	}
}
