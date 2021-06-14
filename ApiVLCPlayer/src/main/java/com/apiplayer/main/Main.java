package com.apiplayer.main;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.apiplayer.socket.SocketServer;

public class Main {
	
	static {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {

		SocketServer server = new SocketServer(6000);
		
		logger.info("Running server...");
		server.startServer();

		/*
		 * System.out.println(System.getProperty("user.name"));
		 * 
		 * List<String> windowsUsers = new ArrayList<String>(); for (File userDirectory
		 * : new File("C:/Users").listFiles()) {
		 * windowsUsers.add(userDirectory.getName()); }
		 * 
		 * System.out.println(windowsUsers);
		 * 
		 * String dirName = "/users/cameanu/";
		 * 
		 * File file = new File(dirName); String[] directories = file.list(new
		 * FilenameFilter() {
		 * 
		 * @Override public boolean accept(File current, String name) { return new
		 * File(current, name).isDirectory(); } });
		 * System.out.println(Arrays.toString(directories));
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
