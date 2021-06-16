package com.apiplayer.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ListFilesAndDirectories {
	
	private static final Logger logger = LogManager.getLogger(ListFilesAndDirectories.class);
	
	public static synchronized ArrayList<String> execute(String path) throws FileNotFoundException {
		//Checking if the path passed is null or not
		if(path == null || path.trim().isEmpty()) {
			throw new IllegalArgumentException("The path passed is null");
		}
		
		// Creating a File object for directory
		File directoryPath = new File(path);
		
		//Checking if the path passed exist
		if(!directoryPath.exists()) {
			throw new FileNotFoundException("Directory not found");
		}
		
		// List of all files and directories
		File contents[] = directoryPath.listFiles();
		logger.info("List of files and directories (Folders) in the specified directory:");
		ArrayList<String> folders = new ArrayList<String>();
		
		for (File file : contents) {
			
			folders.add(file.getName());
			logger.info(file.getName());
			logger.info(file.getAbsolutePath());
			
			/*
			if (file.getName().indexOf(".") != -1) {
				if (file.getName().indexOf("mp4") != -1) {
					logger.info("mp4 File: " + file.getName());
				} else if (file.getName().indexOf("mp3") != -1) {
					logger.info("mp3 File: " + file.getName());
				}
			} else {
				logger.info("Folder: " + file.getName());
			}
			 */
		}
			
		return folders;
	}

}
