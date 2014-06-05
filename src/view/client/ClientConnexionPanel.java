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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import network.client.event.MessageEvent;
import controller.AbstractController;

public class ClientConnexionPanel extends AbstractClientView implements ActionListener
{
	private JPanel pnlContainer;
	private JTextField txtIp;
	private JLabel lblIp;
	private JPanel pnlIp;
	private JButton btEnter;
	private String ipAdress;
	private String frameName = "Connection Client";
	private String errorMessage;
	private JTextArea areError;
	private JPanel pnlError;
	private JLabel lblError;

	/**
	 *CHOICE ELEMENT'S PREFIXING :
	 * 
	 * JPanel		:	pnl
	 * JTextField	:	fld
	 * JLabel		:	lbl
	 * JButton 		:	btn
	 * JTextArea	:	are
	 * */
	
	public ClientConnexionPanel(AbstractController controller)
	{
		super(controller);

		pnlContainer = new JPanel();

		// Initialization of the ip's JLabel
		lblError = new JLabel("Error Message");

		//Initialization of the errorText
		areError = new JTextArea(" ");
		Font policeError = new Font("Ds-digital", Font.TYPE1_FONT,15);
		areError.setFont(policeError);
		areError.setForeground(Color.red);
		pnlContainer.add(new JScrollPane(areError));
		
		areError.setEditable(false);
		areError.setSize(280, 50);
	
		pnlError = new JPanel();
		pnlError.setPreferredSize(new Dimension (360,80));
		pnlError.setBackground(Color.white);

		pnlError.add(lblError);
		pnlError.add(areError);
		pnlError.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		pnlError.setVisible(false);
		pnlContainer.add(pnlError, BorderLayout.CENTER);
		
		// Initialization of the ip's JLabel
		lblIp = new JLabel("Type your IP Address");
		pnlContainer.add(this.lblIp, BorderLayout.NORTH);
		
		//Initialization of the JTextField ipText
		txtIp = new JTextField(15);
		Font police = new Font("Ds-digital", Font.TYPE1_FONT,20);
		txtIp.setFont(police);
		txtIp.setHorizontalAlignment(JTextField.CENTER);
		txtIp.setPreferredSize(new Dimension(280,30));
		txtIp.setMargin(null);           
		txtIp.setBorder(BorderFactory.createEmptyBorder());

		//Initialization of the ipText's panel
		pnlIp = new JPanel();
		pnlIp.setPreferredSize(new Dimension(360,50));
		pnlIp.setBackground(Color.white);
		pnlIp.add(txtIp);
		pnlIp.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		pnlContainer.add(pnlIp, BorderLayout.CENTER);

		//Initialization of the Enter button
		btEnter = new JButton("Enter");
		pnlContainer.add(btEnter, BorderLayout.SOUTH);
		btEnter.setPreferredSize(new Dimension(360,60));
		btEnter.addActionListener(this);
	}	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btEnter)
		{
			pnlError.setVisible(false);
			
			//setIpAdress(ipText.getText());
			ipAdress = txtIp.getText();
			try
			{
				//controller.getModel().getClient().connect(ipAdress);
				getController().getModel().getClient().connect(ipAdress);
			} catch (IOException exception) {
				errorMessage = ("ERREUR " + exception.getMessage());
				System.out.println(errorMessage);
				areError.setText(exception.getMessage());
				areError.revalidate();
				pnlError.setVisible(true);
			}
		}
	}

	public String getIpAdress() {
		return ipAdress;
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

