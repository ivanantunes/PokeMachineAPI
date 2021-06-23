package com.pokemachine.api.utils;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import com.pokemachine.api.enums.EPartDate;

/**
 * Class Contains useful functions for the system.
 * 
 * @author ivanantunes
 */
public class SystemUtil {

	/**
	 * Constructor
	 */
	private SystemUtil() {
	}

	/**
	 * Takes the current date and time and returns formatted
	 * 
	 * @return Date and Time Format
	 */
	public static String currentDateTime() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		return dateTimeFormatter.format(LocalDateTime.now());
	}

	/**
	 * Generates a log in the Console and returns the log text
	 * 
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

	/**
	 * Take Part Of Date
	 * @param part - Part Date
	 * @param sum - number to add
	 * @return String of Part Date
	 */
	public static String takePartOfDate(EPartDate part, int sum) {

		LocalDate today = LocalDate.now();

		int value = 0;
		String result = "";

		switch (part) {
			case DAY:
				value = today.getDayOfMonth();
				break;
			case MONTH:
				value = today.getMonthValue();
				break;
			case YEAR:
				value = today.getYear();
				break;
		}

		result = (value + sum) + "";

		if (value < 10) {
			result = "0" + value;
		}

		if (result.length() > 2) {
			result = result.substring(result.length() - (result.length() - 2));
		}

		return result;
	}
}
