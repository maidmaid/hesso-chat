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
import javax.swing.JTextField;

import controller.AbstractController;

import view.AbstractView;

import network.client.Client;


public class ClientMessagePanel extends AbstractClientView implements ActionListener
{
	private JPanel panel;
	private String frameName = "Message Client";
	private String message;
	private String readText;
	
	private JTextField inputMessage;
	private JTextField readMessage;
	
	private JPanel inputMessagePan;
	private JPanel readMessagePan;
	
	private JButton btEnterMessage;
	
	private Client client;
	
	public ClientMessagePanel(AbstractController controller)
	{	
		super(controller);
		
		panel = new JPanel();
		
		readMessage = new JTextField();
		Font police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		readMessage.setFont(police);
		readMessage.setBackground(Color.pink);
		readMessage.setHorizontalAlignment(JTextField.CENTER);
		readMessage.setPreferredSize(new Dimension(280,30));
		readMessage.setMargin(null);           
		readMessage.setBorder(BorderFactory.createEmptyBorder());
		readMessage.setEditable(false);
		
		readMessagePan = new JPanel();
		readMessagePan.setPreferredSize(new Dimension(360,100));
		readMessagePan.setBackground(Color.pink);
		
		readMessagePan.add(readMessage);
		readMessagePan.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		panel.add(readMessagePan, BorderLayout.CENTER);
		
		inputMessage = new JTextField("Rédiger message");
		police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		inputMessage.setFont(police);
		inputMessage.setEditable(true);
		inputMessage.setBackground(Color.white);
		inputMessage.setHorizontalAlignment(JTextField.CENTER);
		inputMessage.setPreferredSize(new Dimension(280,30));
		inputMessage.setMargin(null);           
		inputMessage.setBorder(BorderFactory.createEmptyBorder());
		
		inputMessagePan = new JPanel();
		inputMessagePan.setPreferredSize(new Dimension(360,100));
		inputMessagePan.setBackground(Color.white);
		
		inputMessagePan.add(inputMessage);
		inputMessagePan.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		panel.add(inputMessagePan, BorderLayout.CENTER);
		
		btEnterMessage = new JButton("Send Message");
		panel.add(btEnterMessage, BorderLayout.CENTER);
		btEnterMessage.setPreferredSize(new Dimension(200,60));
		btEnterMessage.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btEnterMessage)
		{
			message = inputMessage.getText();
			client.send(message);
		}
	}
	
	public void readMessage()
	{
		readMessage.setText(message);
	}

}
