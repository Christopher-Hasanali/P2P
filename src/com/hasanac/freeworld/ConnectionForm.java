package com.hasanac.freeworld;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ConnectionForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ConnectionForm connectionForm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectionForm window = new ConnectionForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnectionForm() {
		initialize();
		this.connectionForm = this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(101, 49, 181, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(327, 49, 117, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 87, 211, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				connectionForm.frame.setVisible(false);
				ChatForm chatForm = new ChatForm();
				try {
					chatForm.initializeChatForm();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(327, 85, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblFriendName = new JLabel("Friend name:");
		lblFriendName.setBounds(13, 54, 89, 16);
		frame.getContentPane().add(lblFriendName);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(294, 54, 36, 16);
		frame.getContentPane().add(lblPort);
		
		JLabel lblIpAddress = new JLabel("IP address:");
		lblIpAddress.setBounds(23, 92, 79, 16);
		frame.getContentPane().add(lblIpAddress);
	}
}
