package client.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import client.chat.ClientChat;

public class ClientConnexion extends JFrame
								implements ActionListener
{
		
	private JTextField ipText = new JTextField(15);
	
	private JLabel ipLabel = new JLabel("IP Address");
	
	private JPanel ipTextPan = new JPanel();
	private JPanel positionPan = new JPanel();
	
	private JButton btEnter = new JButton("Enter");
	
	private String ipAdress;

	public ClientConnexion()
	{
		this.setTitle("Connexion Client");
		this.setSize(400, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		intitComponent();
		this.setContentPane(positionPan);
		this.setVisible(true);
	}	
			
	private void intitComponent(){
		
		// Initialization of the ip's JLabel
		positionPan.add(this.ipLabel,BorderLayout.NORTH);
		
		//Initialization of the JTextField ipText
		Font police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		ipText.setFont(police);
		ipText.setHorizontalAlignment(JTextField.CENTER);
		ipText.setPreferredSize(new Dimension(280,30));
		ipText.setMargin(null);           
		ipText.setBorder(BorderFactory.createEmptyBorder());
		this.getContentPane().add(this.ipText, BorderLayout.CENTER);
		
		//Initialization of the ipText's panel
		ipTextPan.setPreferredSize(new Dimension(360,50));
		ipTextPan.setBackground(Color.white);
		
		ipTextPan.add(ipText);
		ipTextPan.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		positionPan.add(ipTextPan, BorderLayout.CENTER);
		
		//Initialization of the Enter button
		positionPan.add(btEnter, BorderLayout.SOUTH);
		btEnter.setPreferredSize(new Dimension(100,60));
		btEnter.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btEnter)
		{
			ipAdress = ipText.getText();
		}
		
	}
	

}

