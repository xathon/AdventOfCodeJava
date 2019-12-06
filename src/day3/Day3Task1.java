package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
The gravity assist was successful, and you're well on your way to the Venus refuelling station. During the rush back on Earth, the fuel management system wasn't completely installed, so that's next on the priority list.

Opening the front panel reveals a jumble of wires. Specifically, two wires are connected to a central port and extend outward on a grid. You trace the path each wire takes as it leaves the central port, one wire per line of text (your puzzle input).

The wires twist and turn, but the two wires occasionally cross paths. To fix the circuit, you need to find the intersection point closest to the central port. Because the wires are on a grid, use the Manhattan distance for this measurement. While the wires do technically cross right at the central port where they both start, this point does not count, nor does a wire count as crossing with itself.

For example, if the first wire's path is R8,U5,L5,D3, then starting from the central port (o), it goes right 8, up 5, left 5, and finally down 3:

...........
...........
...........
....+----+.
....|....|.
....|....|.
....|....|.
.........|.
.o-------+.
...........
Then, if the second wire's path is U7,R6,D4,L4, it goes up 7, right 6, down 4, and left 4:

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
These wires cross at two locations (marked X), but the lower-left one is closer to the central port: its distance is 3 + 3 = 6.

Here are a few more examples:

R75,D30,R83,U83,L12,D49,R71,U7,L72
U62,R66,U55,R34,D71,R55,D58,R83 = distance 159
R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
U98,R91,D20,R16,D67,R40,U7,R15,U6,R7 = distance 135
What is the Manhattan distance from the central port to the closest intersection?
*/
public class Day3Task1 {
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
		int distance = 0;
		int cd = 0;
		for(Point p : route1) {
			cd = p.Manhattan();
			if(distance == 0 || cd<distance) { //Effizienzinator
				if(route2.contains(p)) {
					if(distance == 0) distance = p.Manhattan();
					distance = (distance < cd ? distance : cd);
				}
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

