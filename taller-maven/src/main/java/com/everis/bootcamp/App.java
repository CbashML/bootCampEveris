package com.everis.bootcamp;

import org.joda.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
		System.out.println("Hello World!");
		System.out.printf("%s-%s-%s", date.getDayOfMonth(), date.getMonthOfYear(), date.getYear());

	}
}
