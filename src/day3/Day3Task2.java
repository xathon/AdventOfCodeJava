package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
--- Part Two ---
It turns out that this circuit is very timing-sensitive; you actually need to minimize the signal delay.

To do this, calculate the number of steps each wire takes to reach each intersection; choose the intersection where the sum of both wires' steps is lowest. If a wire visits a position on the grid multiple times, use the steps value from the first time it visits that position when calculating the total value of a specific intersection.

The number of steps a wire takes is the total number of grid squares the wire has entered to get to that location, including the intersection being considered. Again consider the example from above:

...........
.+-----+...
.|.....|...
.|..+--X-+.
.|..|..|.|.
.|.-X--+.|.
.|..|....|.
.|.......|.
.o-------+.
...........
In the above example, the intersection closest to the central port is reached after 8+5+5+2 = 20 steps by the first wire and 7+6+4+3 = 20 steps by the second wire for a total of 20+20 = 40 steps.

However, the top-right intersection is better: the first wire takes only 8+5+2 = 15 and the second wire takes only 7+6+2 = 15, a total of 15+15 = 30 steps.

Here are the best steps for the extra examples from above:

R75,D30,R83,U83,L12,D49,R71,U7,L72
U62,R66,U55,R34,D71,R55,D58,R83 = 610 steps
R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
U98,R91,D20,R16,D67,R40,U7,R15,U6,R7 = 410 steps
What is the fewest combined steps the wires must take to reach an intersection?
*/
public class Day3Task2 {
	Scanner s;
	ArrayList<Vector> cable1,cable2;

	public void init() throws FileNotFoundException {
		s = new Scanner(new File("./src/day3/input.txt"));
		
		cable1 = new ArrayList<Vector>();
		cable2 = new ArrayList<Vector>();
		
		
		String in1,in2,read;
		in1 = s.nextLine();
		in2 = s.nextLine();
		s.close();
		
		Scanner c1 = new Scanner(in1);
		c1.useDelimiter(",");
		Scanner c2 = new Scanner(in2);
		c2.useDelimiter(",");
		
		while(c1.hasNext()) 
		{
			Vector v = new Vector();
			read = c1.next();
			v.dir = read.charAt(0);
			v.l = Integer.parseInt(read.substring(1));
			cable1.add(v);
		}
		c1.close();
		while(c2.hasNext()) 
		{
			Vector v = new Vector();
			read = c2.next();
			v.dir = read.charAt(0);
			v.l = Integer.parseInt(read.substring(1));
			cable2.add(v);
		}
		c2.close();
		ArrayList<Point> route1 = buildRoute(cable1);
		ArrayList<Point> route2 = buildRoute(cable2);
		int distance = route1.size()+route2.size();
		Point pt;
		for(int i = 0; i < route1.size(); i++) {
			pt = route1.get(i);
			if(distance > i && route2.contains(pt)) {
				int d2 = route2.indexOf(pt);
				if(distance == 0) distance = i+d2 + 2; //+2 hier weil der letzte Schritt jedes Kabels nicht gezählt wird
				distance = (distance < i + d2 +2 ? distance : i + d2 + 2);
			
			}
		}
		
		

		System.out.println(distance);
		
	}
	public ArrayList<Point> buildRoute (ArrayList<Vector> cable) {
		ArrayList<Point> p = new ArrayList<Point>();
		int posX = 0,posY = 0;
		
		for(int i = 0; i < cable.size(); i++) {
			for(int j = 0; j < cable.get(i).l; j++) {
				switch(cable.get(i).dir) {
				case 'U':
					posY++;
					break;
				case 'D':
					posY--;
					break;
				case 'L':
					posX--;
					break;
				case 'R':
					posX++;
					break;
				}
				p.add(new Point(posX,posY));
			}
		}
		
		
		return p;
	}
}

