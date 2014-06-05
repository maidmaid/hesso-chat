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
import controller.AbstractController;


public class ClientMessagePanel extends AbstractClientView implements ActionListener
{
	private JPanel container;
	private String frameName = "Message Client";
	private String message;
	private String readText;
	private JTextArea inputMessage;
	private JTextArea readMessage;
	private JPanel inputMessagePan;
	private JPanel readMessagePan;
	private JLabel readMessageLablel;
	private JLabel inputMessageLablel;
	private JButton btEnterMessage;
	
	public ClientMessagePanel(AbstractController controller)
	{	
		super(controller);
		
		container = new JPanel();
		
		readMessageLablel = new JLabel("Message received : ");
		readMessageLablel.setVisible(true);
		container.add(this.readMessageLablel, BorderLayout.NORTH);
		
		readMessage = new JTextArea();
		Font police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		readMessage.setFont(police);
		readMessage.setBackground(Color.gray);
		readMessage.setPreferredSize(new Dimension(280,150));
		readMessage.setMargin(null);           
		readMessage.setBorder(BorderFactory.createEmptyBorder());
		//readMessage.setEditable(false);
		container.add(new JScrollPane(readMessage));
		
		readMessagePan = new JPanel();
		readMessagePan.setPreferredSize(new Dimension(360,200));
		readMessagePan.setBackground(Color.gray);
		
		readMessagePan.add(readMessage);
		readMessagePan.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		container.add(readMessagePan, BorderLayout.CENTER);
		
		inputMessageLablel = new JLabel("Send a Message : ");
		inputMessageLablel.setVisible(true);
		container.add(this.inputMessageLablel, BorderLayout.NORTH);
		
		inputMessage = new JTextArea(" ");
		police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		inputMessage.setFont(police);
		inputMessage.setEditable(true);
		inputMessage.setBackground(Color.white);
		inputMessage.setPreferredSize(new Dimension(280,150));
		inputMessage.setMargin(null);           
		inputMessage.setBorder(BorderFactory.createEmptyBorder());
		container.add(new JScrollPane(inputMessage));
		
		inputMessagePan = new JPanel();
		inputMessagePan.setPreferredSize(new Dimension(360,200));
		inputMessagePan.setBackground(Color.white);
		
		inputMessagePan.add(inputMessage);
		inputMessagePan.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		container.add(inputMessagePan, BorderLayout.CENTER);
		
		btEnterMessage = new JButton("Send Message");
		container.add(btEnterMessage, BorderLayout.CENTER);
		btEnterMessage.setPreferredSize(new Dimension(360, 60));
		btEnterMessage.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btEnterMessage)
		{
			message = inputMessage.getText();
		}
	}
	
	public void readMessage()
	{
		readMessage.setText(message);
	}
	
	public JPanel getContainer()
	{
		return container;
	}
}
