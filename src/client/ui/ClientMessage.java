package client.ui;

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

public class ClientMessage extends JPanel
							implements ActionListener
{
	private String frameName = "Message Client";
	private String message;
	private String readText;
	
	private JTextField inputMessage;
	private JTextField readMessage;
	
	private JPanel inputMessagePan;
	private JPanel readMessagePan;
	
	private JButton btEnterMessage;
	
	public ClientMessage(){
		
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
		add(readMessagePan, BorderLayout.CENTER);
		
		inputMessage = new JTextField();
		police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		inputMessage.setFont(police);
		inputMessage.setEditable(true);
		inputMessage.setBackground(Color.lightGray);
		inputMessage.setHorizontalAlignment(JTextField.CENTER);
		inputMessage.setPreferredSize(new Dimension(280,30));
		inputMessage.setMargin(null);           
		inputMessage.setBorder(BorderFactory.createEmptyBorder());
		
		inputMessagePan = new JPanel();
		inputMessagePan.setPreferredSize(new Dimension(360,100));
		inputMessagePan.setBackground(Color.lightGray);
		
		inputMessagePan.add(inputMessage);
		inputMessagePan.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		add(inputMessagePan, BorderLayout.CENTER);
		
		btEnterMessage = new JButton("Send Message");
		add(btEnterMessage, BorderLayout.CENTER);
		btEnterMessage.setPreferredSize(new Dimension(200,60));
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

}