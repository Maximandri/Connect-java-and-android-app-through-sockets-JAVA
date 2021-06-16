package com.apiplayer.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.apiplayer.utilities.ListFilesAndDirectories;

public class RequestHandler extends Thread {
	private Socket socket;
	private static final Logger logger = LogManager.getLogger(RequestHandler.class);
	public static String resultText = "";
	
	RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			logger.info("Received a connection");

			// Get input and output streams
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());

			String pathFromAndroid = in.readLine();
			
			List<String> folders = ListFilesAndDirectories.execute(pathFromAndroid);
			
			for(int i = 0; i < folders.size(); i++) {
				pw.write(folders.get(i) + "\n");
				RequestHandler.resultText += folders.get(i) + "\n";
				logger.info(folders.get(i));
			}
			
			pw.flush();
			// Close our connection
			in.close();
			pw.close();
			socket.close();

			logger.info("Connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
