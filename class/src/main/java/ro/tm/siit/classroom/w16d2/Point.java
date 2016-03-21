package ro.tm.siit.classroom.w16d2;

public class Point {
	
	private int x;
	
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this.x = p.x; 
		this.y = p.y;
	}
	
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void draw(Object surface) {
		//do drawing
	}
	
	public String toString() {
		return "point@[" + this.x + "," + this.y + "]";
	}

}
