package view.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ClientController;



public class ClientConnexionPanel extends JPanel implements ActionListener
{
	private ClientController controller;
	private JTextField ipText;
	private JLabel ipLabel;
	private JPanel ipTextPan;
	private JButton btEnter;
	private String ipAdress;
	private String frameName = "Connection Client";
	
	public ClientConnexionPanel(ClientController controller)
	{
		this.controller = controller;
		// Initialization of the ip's JLabel
		ipLabel = new JLabel("IP Address");
		add(this.ipLabel,BorderLayout.NORTH);

		//Initialization of the JTextField ipText
		ipText = new JTextField(15);
		Font police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		ipText.setFont(police);
		ipText.setHorizontalAlignment(JTextField.CENTER);
		ipText.setPreferredSize(new Dimension(280,30));
		ipText.setMargin(null);           
		ipText.setBorder(BorderFactory.createEmptyBorder());

		//Initialization of the ipText's panel
		ipTextPan = new JPanel();
		ipTextPan.setPreferredSize(new Dimension(360,50));
		ipTextPan.setBackground(Color.white);

		ipTextPan.add(ipText);
		ipTextPan.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		add(ipTextPan, BorderLayout.CENTER);

		//Initialization of the Enter button
		btEnter = new JButton("Enter");
		add(btEnter, BorderLayout.SOUTH);
		btEnter.setPreferredSize(new Dimension(100,60));
		btEnter.addActionListener(this);
	}	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btEnter)
		{
			//setIpAdress(ipText.getText());
			ipAdress = ipText.getText();
			try
			{
				controller.getModel().getClient().connect(ipAdress);
			} catch (IOException exception) {
				System.out.println("ERREUR " + exception.getMessage());
			}
		}
	}

	public String getIpAdress() {
		return ipAdress;
	}
//
//	public void setIpAdress(String ipAdress) {
//		this.ipAdress = ipAdress;
//	}
}

