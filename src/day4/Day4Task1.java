package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*--- Day 4: Secure Container ---
You arrive at the Venus fuel depot only to discover it's protected by a password. The Elves had written the password on a sticky note, but someone threw it out.

However, they do remember a few key facts about the password:

It is a six-digit number.
The value is within the range given in your puzzle input.
Two adjacent digits are the same (like 22 in 122345).
Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
Other than the range rule, the following are true:

111111 meets these criteria (double 11, never decreases).
223450 does not meet these criteria (decreasing pair of digits 50).
123789 does not meet these criteria (no double).
How many different passwords within the range given in your puzzle input meet these criteria?
*/
public class Day4Task1 {
	Scanner s;
	public void init() throws FileNotFoundException {
		s = new Scanner(new File("./src/day4/input.txt"));
		s.useDelimiter("-");
		String min = s.next();
		String max = s.next();
		s.close();
		
		int lastDigit=10;
		int currentDigit = 0;
		int counter = 0;

		boolean dbl = false;
		for(int i = Integer.parseInt(min); i <= Integer.parseInt(max); i++) {
			lastDigit = 10;
			dbl = false;
			for(int j = 0; j < 6; j++) {
			currentDigit = (int) ((i / Math.pow(10, j)%10));
			if(currentDigit > lastDigit) {
				dbl = false;
				break;
			}
			else if(currentDigit == lastDigit) dbl = true;
			lastDigit = currentDigit;
			}
			if(dbl) counter++;

		}
		
		System.out.println(counter);
	}
}
