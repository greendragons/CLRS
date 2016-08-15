import java.io.PrintWriter;

import greendragons.clrs.utils.io.FastScanner;

public class SegmentIntersect {
	static FastScanner in;
	static PrintWriter out;

	public static void main(String[] args) {
		int t;
		in = new FastScanner(System.in);
		t = in.nextInt();

		while(t != 0) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			Point p1 = new Point(x1,y1);
			Point p2 = new Point(x2,y2);
			Segment s1 = new Segment(p1,p2);

			x1 = in.nextInt();
			y1 = in.nextInt();
			x2 = in.nextInt();
			y2 = in.nextInt();

			Point p3 = new Point(x1,y1);
			Point p4 = new Point(x2,y2);
			Segment s2 = new Segment(p3,p4);
			System.out.println(s1.intersect(s2));
			t--;
		}
	}

}
