package day3;

public class Point {
	int x,y;
	public Point(int xx, int yy) {
		x = xx;
		y = yy;
	}
	public int Manhattan() {
		
		return Math.abs(x)+Math.abs(y);

	}
	@Override
	public boolean equals (Object o) {
		
		return((o != null) && (o instanceof Point) && this.x == ((Point)o).x && this.y == ((Point)o).y);
	}
}
