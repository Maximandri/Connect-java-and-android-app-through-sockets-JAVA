package com.apiplayer.main;

import java.awt.EventQueue;
import java.io.FileNotFoundException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.apiplayer.forms.LoginForm;
import com.apiplayer.socket.SocketServer;

public class Main {
	
	static {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) throws FileNotFoundException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		/*
		SocketServer server = new SocketServer(6000);
		
		logger.info("Running server...");
		server.startServer();
		*/
		/*
		 * ProcessBuilder p = new
		 * ProcessBuilder("C:\\Program Files\\VideoLAN\\VLC\\vlc.exe"
		 * ,"C:\\Users\\cameanu\\Videos\\TEST_VIDEO.mp4");
		 * 
		 * try { p.start(); } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}
}
