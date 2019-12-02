package day2;

import java.io.IOException;

public class Day2Main {
	
	public static void main(String[] args) throws IOException {
		
		Day2Task1 t1 = new Day2Task1();
		Day2Task2 t2 = new Day2Task2();
		
		System.out.print("Task 1: ");
		t1.init(12,2);
		System.out.print("Task 2: ");
		int noun,verb,res;
		for(noun = 0; noun < 100; noun++) {
			for(verb = 0; verb < 100; verb++) {
				res = t2.init(noun, verb);
				if(res == 19690720) {
					System.out.println("Noun: " + noun + ", Verb: " + verb);
					noun = 100;
					break;
				}
				if (res + 100 < 19690720) {
					noun++;
				}
				if(res > 19690720) noun--;
			}
		}

	}

}
