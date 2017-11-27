package com.hasanac.freeworld;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatForm {

	private JFrame frame;
	private JTextArea chatText;
	private JButton send;
	private JTextArea sendingText;
	private JButton clear;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 */
	public void initializeChatForm() throws IOException {
		ChatForm window = new ChatForm();
		window.frame.setVisible(true);
//		ServerSocket ss = new ServerSocket(3333);
//		Socket s = ss.accept();
//		DataInputStream din = new DataInputStream(s.getInputStream());
//		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		String str = "", str2 = "";
//		while (!str.equals("stop")) {
//			str = din.readUTF();
//			System.out.println("client says: " + str);
//			str2 = br.readLine();
//			dout.writeUTF(str2);
//			dout.flush();
//		}
//		din.close();
//		s.close();
//		ss.close();

	}

	/**
	 * Create the application.
	 */
	public ChatForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		chatText = new JTextArea();
		chatText.setEnabled(false);
		chatText.setEditable(false);
		chatText.setBackground(Color.WHITE);
		chatText.setLineWrap(true);
		chatText.setBounds(6, 6, 438, 198);

		JScrollPane scroll = new JScrollPane(chatText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setSize(438, 202);
		scroll.setLocation(6, 6);

		frame.getContentPane().add(scroll);

		send = new JButton("Send");
		send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sendText();
			}
		});
		send.setBounds(321, 220, 58, 52);
		frame.getContentPane().add(send);

		sendingText = new JTextArea();
		sendingText.setWrapStyleWord(true);
		sendingText.setBounds(6, 220, 310, 52);
		frame.getContentPane().add(sendingText);

		clear = new JButton("Clear");
		clear.setBounds(385, 220, 59, 52);
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearChatText();
			}
		});
		frame.getContentPane().add(clear);

	}

	public void sendText() {
		chatText.append(sendingText.getText() + "\n");
		sendingText.setText("");
	}

	public void clearChatText() {
		chatText.setText("");
		sendingText.setText("");
	}

}
