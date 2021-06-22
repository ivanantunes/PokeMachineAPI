package com.pokemachine.api.utils;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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

	/**
	 * Generate random numbers for code creation.
	 * @param min - Min Value
	 * @param max - Max Value
	 * @return String of Random
	 */
	public static BigInteger randomNumber(BigInteger min, BigInteger max) { 

		Random random = new Random();

		BigInteger bigInteger = max.subtract(min);
		
		int length = max.bitLength();

		BigInteger resultRandom = new BigInteger(length, random);

		if (resultRandom.compareTo(min) < 0) {
			resultRandom.add(min);
		}

		if (resultRandom.compareTo(max) >= 0) {
			resultRandom = resultRandom.mod(bigInteger).add(min);
		}

		return resultRandom;
	}
}
