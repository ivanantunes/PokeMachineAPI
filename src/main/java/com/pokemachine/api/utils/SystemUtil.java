package com.pokemachine.api.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class Contains useful functions for the system.
 * @author ivanantunes
 */
public class SystemUtil {
    
    /**
     * Constructor
     */
    private SystemUtil() {  }

    /**
	 * Takes the current date and time and returns formatted
	 * @return Date and Time Format
	 */
	public static String currentDateTime() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		return dateTimeFormatter.format(LocalDateTime.now());
	}

	/**
	 * Generates a log in the Console and returns the log text
	 * @param msg - Message
	 * @return Log generated
	 */
	public static String log(String msg) {
		String base = "[Sistema - " + SystemUtil.currentDateTime() + "]: ";
		
		System.out.println(base + msg);
		
		return base + msg;
	}


}
