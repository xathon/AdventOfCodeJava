package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*--- Part Two ---
An Elf just remembered one more important detail: the two adjacent matching digits are not part of a larger group of matching digits.

Given this additional criterion, but still ignoring the range rule, the following are now true:

112233 meets these criteria because the digits never decrease and all repeated digits are exactly two digits long.
123444 no longer meets the criteria (the repeated 44 is part of a larger group of 444).
111122 meets the criteria (even though 1 is repeated more than twice, it still contains a double 22).
How many different passwords within the range given in your puzzle input meet all of the criteria?
*/
public class Day4Task2 {
	Scanner s;

	public void init() throws FileNotFoundException {
		s = new Scanner(new File("./src/day4/input.txt"));
		s.useDelimiter("-");
		String min = s.next();
		String max = s.next();
		s.close();

		int lastDigit = 10;
		int currentDigit = 0;
		int counter = 0;
		int staysTheSameFor = 1;

		boolean dbl = false;
		boolean allgood = false;
		for (int i = Integer.parseInt(min); i <= Integer.parseInt(max); i++) {
			lastDigit = 10;
			dbl = false;
			allgood = false;
			staysTheSameFor = 1;
			
			for (int j = 0; j < 6; j++) {
				currentDigit = (int) ((i / Math.pow(10, j) % 10));
				
				if (currentDigit > lastDigit) {
					dbl = false;
					allgood = false;
					break;
				} else if (currentDigit == lastDigit) {
					dbl = true;
					staysTheSameFor++;
					
				} else {
					staysTheSameFor = 1;
				}
				lastDigit = currentDigit;
				if ((dbl && staysTheSameFor < 2) || (dbl && staysTheSameFor == 2 && j == 5) ) {
					allgood = true;
				} 
				if(staysTheSameFor > 2) {
					dbl = false;
				}
			}
			if (allgood)
				counter++;

		}

		System.out.println(counter);
	}
}
