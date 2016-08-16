package ch33.sec2;

public class Point {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(int x, int y) {
		this.x -= x;
		this.y -= y;
	}

	public Point subtract(int x, int y) {
		Point p = new Point(this.x - x, this.y - y);
		return p;
	}
	
	public Point subtract(Point p1) {
		Point p = subtract(p1.x, p1.y);
		return p;
	}

	public Point add(int x, int y) {
		Point p = new Point(this.x + x, this.y + y);
		return p;
	}

	public Point add(Point p1) {
		Point p = add(p1); 
		return p;
	}
	
	public double distance(Point p2) {
		double v1 = x - p2.x;
		double v2 = x - p2.x;
		return Math.sqrt(v1 * v1 + v2 * v2);
	}
	
	//calculates p x p1
	public int crossProduct(Point p2) {
		return x * p2.y - y * p2.x;
	}

	//calculates p x p1 , taking p2 as origin 
	public int crossProduct(Point p1, Point p2) {
		return this.subtract(p2).crossProduct(p1.subtract(p2));
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}
