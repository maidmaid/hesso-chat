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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.AbstractView;

import controller.AbstractController;
import controller.ClientController;



public class ClientConnexionPanel extends AbstractClientView implements ActionListener
{
	private JPanel container;
	private JTextField ipText;
	private JLabel ipLabel;
	private JPanel ipTextPan;
	private JButton btEnter;
	private String ipAdress;
	private String frameName = "Connection Client";
	private String errorMessage;
	private JTextArea errorText;
	private JPanel errorTextPan;
	private JLabel errorLabel;

	public ClientConnexionPanel(AbstractController controller)
	{
		super(controller);

		container = new JPanel();

		// Initialization of the ip's JLabel
		errorLabel = new JLabel("Error Message");
		errorLabel.setVisible(false);
		container.add(this.errorLabel, BorderLayout.NORTH);

		//Initialization of the errorText
		errorText = new JTextArea(" ");
		Font policeError = new Font("Ds-digital", Font.TYPE1_FONT,15);
		errorText.setFont(policeError);
		errorText.setForeground(Color.red);
		container.add(new JScrollPane(errorText));
		
		errorText.setEditable(false);
		errorText.setSize(280, 50);
		errorText.setVisible(false);
	
		errorTextPan = new JPanel();
		errorTextPan.setPreferredSize(new Dimension (360,80));
		errorTextPan.setBackground(Color.white);

		errorTextPan.add(errorText);
		errorTextPan.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		errorTextPan.setVisible(false);
		container.add(errorTextPan, BorderLayout.CENTER);
		
		// Initialization of the ip's JLabel
		ipLabel = new JLabel("Type your IP Address");
		container.add(this.ipLabel, BorderLayout.NORTH);
		
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
		container.add(ipTextPan, BorderLayout.CENTER);

		//Initialization of the Enter button
		btEnter = new JButton("Enter");
		container.add(btEnter, BorderLayout.SOUTH);
		btEnter.setPreferredSize(new Dimension(360,60));
		btEnter.addActionListener(this);
	}	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btEnter)
		{
			errorTextPan.setVisible(false);
			
			//setIpAdress(ipText.getText());
			ipAdress = ipText.getText();
			try
			{
				//controller.getModel().getClient().connect(ipAdress);
				getController().getModel().getClient().connect(ipAdress);
			} catch (IOException exception) {
				errorMessage = ("ERREUR " + exception.getMessage());
				System.out.println(errorMessage);
				errorText.setText(exception.getMessage());
				errorText.revalidate();
				errorTextPan.setVisible(true);
				errorLabel.setVisible(true);
				errorText.setVisible(true);
			}
		}
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public JPanel getContainer()
	{
		return container;
	}
	//
	//	public void setIpAdress(String ipAdress) {
	//		this.ipAdress = ipAdress;
	//	}
}

