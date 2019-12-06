package day3;

public class Vector {
	char dir;
	int l;
	
	public Vector() {
		dir = 'U';
		l = 0;
	}
	public Vector(String s, int le) {
		dir = s.charAt(0);
		l = le;
	}
	
}
