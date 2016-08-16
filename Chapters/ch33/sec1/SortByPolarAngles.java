package ch33.sec1;
import java.util.Arrays;
import java.util.Comparator;

/*
 *	Given n points {p1, p2, ... , pn}, sort them in non-decreasing order of their polar angle
 *	formed with reference to a given point p0. 
 *	Not allowed to use trigonometric functions, to compare angles use cross product.
 *
 *
 *	Algorithm:
 *	We divide points into two categories:
 *		1) Points with +ve value of y
 *		2) Points with -ve value of y
 *
 *	Points within a category are compared using their cross product.
 *		p1 x p2 :
 *			a)  +ve means p2 comes before p1 (as angle is clockwise from p2 to p1)
 *			b)  -ve means p1 comes before p2 (as angle is anti-clockwise from p2 to p1)
 *			c)  0 area means they are colinear within that boundary of y
 *
 *	Point of different category are compared using their value of y coordinate
 *		a) p1.y > p2.y and both of them have opposite sign then p2 comes before p1
 *		b) p1.y < p2.y and both of them have opposite sign then p1 comes before p2
 *		c) p1.y == 0 or p2.y == 0, one of them is 0, means they are co-linear and lie on x axis,
 *		 	then we compare using x axis.
 *
 *	Why we compare based on different y values:
 *
				p6   
				|       p1
				| 	
		--p3----|--p5----p4--
				|
			  	|
			 p2 |
			 	|
			    p7
 *
 *		Angle between these two is greater than 180 degrees, so when we calculate the cross product
 *		we get area based on smaller angle reference, so the sign of area is reversed.
 *		
 *		So to avoid complications of angles when comparing areas, its better to compare within
 *		the value of 180 between points.
 *		
 *		Now for cases where we get area as 0:
 *	
 *			1)	either they are colinear in same quadrant wrt p0, then we return area i.e 0
 *			2)	if they y = 0, then we compare x values, if they are opposite sign, then -ve one comes after
 *					p3 comes after p4	
 *				but if they have same sign then we compare absolute values of x, i.e (0,0) before p5 or p4 
 *			3)	if they x = 0, then we compare y values, if they are opposite sign, then -ve one comes after
 *					p7 comes after p6	
 *				but if they have same sign then we compare absolute values of y, i.e (0,0) before p6
 *
 *			If we ignore p0 as input then we only need to check for opposite sign conditions, no need
 *			to check for abs values.
 * */

class PolarAngleComparator implements Comparator<Point> {

	//base origin point
	Point p0;

	PolarAngleComparator() { }

	PolarAngleComparator(Point p0) {
		this.p0 = p0;
	}

	@Override
	public int compare(Point p1, Point p2) {
		Point temp1 =  p1.subtract(p0);
		Point temp2 =  p2.subtract(p0);
		if((temp1.y < 0 && temp2.y >= 0) || (temp1.y >=0 && temp2.y < 0)) {
			return temp1.y > temp2.y ? -1 : 1;
		}
		int area = -temp1.crossProduct(temp2);

		/*
		 * area 0 means fall on same line, either both points within quadrant or in different quadrants
		 * if same quadrant, then polar angles are same, we can choose to leave it or sort them based
		 * on x or y.
		 * If different quadrant then, we check for -,+ x or -,+ y. -ve one have greater polar angle than +ve
		 * */
		if(area == 0) {
			if((temp1.x < 0 && temp2.x >= 0) || (temp1.x >=0 && temp2.x < 0)) {
				return temp1.x > temp2.x ? -1 : 1;
			}
			/*
			// only required if p0 is also in input, say 0,0 and 10,0, so 0,0 come before 10,0
			else {
				if(temp1.y == temp2.y) {
					return Math.abs(temp1.x) < Math.abs(temp2.x) ? -1 : 1; 
				}
				else if(temp1.x == temp2.x) {
					return Math.abs(temp1.y) < Math.abs(temp2.y) ? -1 : 1; 
				}
			}
			*/
		}

		return area;
	}
	
}

public class SortByPolarAngles {
	static public FastScanner in = new FastScanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		Point p0 = new Point(x,y);
		Point[] pList = new Point[n];

		for(int i=0; i<n; i++) {
			x = in.nextInt();
			y = in.nextInt();
			pList[i] = new Point(x,y);
		}
		
		Arrays.sort(pList, new PolarAngleComparator(p0)) ;
		
		System.out.println("Sorted by Polar angles with reference to p0 : " + p0);
		for(int i=0; i<n; i++) {
			System.out.println(pList[i]);
		}
	}
}
