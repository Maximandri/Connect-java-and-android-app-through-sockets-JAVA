package com.apiplayer.forms;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.apiplayer.socket.SocketServer;

import java.awt.Font;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ServerForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(ServerForm.class);
	private static SocketServer server = new SocketServer(6000);
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public ServerForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbIpAdress = null;
		try {
			lbIpAdress = new JLabel(InetAddress.getLocalHost().toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		lbIpAdress.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbIpAdress.setHorizontalAlignment(SwingConstants.CENTER);
		lbIpAdress.setBounds(44, 54, 481, 112);
		contentPane.add(lbIpAdress);
		
		JButton btnStartServer = new JButton("Start server");
		btnStartServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!server.isAlive()) {
					logger.info("Running server...");
					server.startServer();
				}
			}
		});
		btnStartServer.setBorder(null);
		btnStartServer.setBackground(new Color(34, 139, 34));
		btnStartServer.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnStartServer.setBounds(127, 177, 310, 74);
		contentPane.add(btnStartServer);
		
		JButton btnStopServer = new JButton("Exit");
		btnStopServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				System.exit(0);
			}
		});
		btnStopServer.setBorder(null);
		btnStopServer.setBackground(new Color(255, 0, 0));
		btnStopServer.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnStopServer.setBounds(127, 262, 310, 74);
		contentPane.add(btnStopServer);
		
	}
}
