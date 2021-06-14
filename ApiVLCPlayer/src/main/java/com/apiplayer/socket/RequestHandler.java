package com.apiplayer.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RequestHandler extends Thread {
	private Socket socket;
	private static final Logger logger = LogManager.getLogger(RequestHandler.class);
	
	RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			logger.info("Received a connection");

			// Get input and output streams
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());

			// Write out our header to the client
			out.println("Echo Server 1.0");
			out.flush();

			// Echo lines back to the client until the client closes the connection or we
			// receive an empty line
			String line = in.readLine();
			while (line != null && line.length() > 0) {
				logger.info("Android: " + line);
				out.flush();
				line = in.readLine();
			}

			// Close our connection
			in.close();
			out.close();
			socket.close();

			logger.info("Connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
