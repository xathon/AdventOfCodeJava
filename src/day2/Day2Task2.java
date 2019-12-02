package day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2Task2 {
	Scanner s;
	ArrayList<Integer> memory;
	
	public int init(int op0, int op1) throws IOException {
		s = new Scanner(new File("./src/day2/input.txt"));
		s.useDelimiter(",");
		memory = new ArrayList<Integer>();
		while(s.hasNext()) {
			memory.add(Integer.parseInt(s.next()));
		}
		memory.set(1, op0);
		memory.set(2, op1);
		int position = 0;
		boolean run = true;
		while(run) {
			switch(memory.get(position)) {
			case 1:
				add(position+1,position+2,position+3);
				position += 4;
				break;
			case 2:
				mult(position+1,position+2,position+3);
				position +=4;
				break;
			case 99:
				run = false;
				break;
			default:
				throw new IOException("There's an error in the opcode!");
			}

		}
		//System.out.println(memory.get(0));
		return memory.get(0);
	}
	public void add(int add1, int add2, int res) {
		
		memory.set(memory.get(res), memory.get(memory.get(add1))+memory.get(memory.get(add2)));

	}
	public void mult(int mult1, int mult2, int res) {
		memory.set(memory.get(res),memory.get(memory.get(mult1))*memory.get(memory.get(mult2)));
	}

}
