package ch33.sec1;

public class Segment {
	Point p1, p2;
	double length;
	
	Segment(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		length = p1.distance(p2);
	}

	public Point getp1() {
		return p1;
	}

	public Point getp2() {
		return p2;
	}
	
	public void move(int x, int y) {
		p1.move(x, y);
		p2.move(x, y);
		length = p1.distance(p2);
	}

	public double length() {
		return length;
	}
	
	//finds whether two segments intersect or not..
	public boolean intersect(Segment s1) {
		int d1 = p1.crossProduct(p2, s1.getp1()) ;
		int d2 = p1.crossProduct(p2, s1.getp2()) ;
		int d3 = s1.getp1().crossProduct(s1.getp2(), p1);
		int d4 = s1.getp1().crossProduct(s1.getp2(), p2);

		if(d1 * d2 < 0 || d3 * d4 < 0)
			return true;
		else if((d1 == 0 && onSegment(s1.getp1())) || 
				(d2 == 0 && onSegment(s1.getp2())) || 
				(d3 == 0 && s1.onSegment(p1)) || 
				(d4 == 0 && s1.onSegment(p2))) 
			return true;
		else 
			return false;
	}
	
	//finds whether given point is on line segment or not
	public boolean onSegment(Point p) {
		int minX = p1.x < p2.x ? p1.x : p2.x;
		int minY = p1.y < p2.y ? p1.y : p2.y;

		int maxX = p1.x > p2.x ? p1.x : p2.x;
		int maxY = p1.y > p2.y ? p1.y : p2.y;

		return p.x >= minX && p.x <= maxX && p.y >= minY && p.y <= maxY;
	}
	
	@Override
	public String toString() {
		return p1 + " , " + p2;
	}
}

