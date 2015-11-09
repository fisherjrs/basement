package katas;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class Sweep {

	public static void main(String[] args) throws Exception {

		Sweep sweep = new Sweep();
		sweep.go();

	}
	
	public Sweep() {

	}

	private void go() {
		// {"12 12 24 24", "48 48 64 64"}

		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// System.out.print("Enter String");
		// String s = br.readLine();

		Field field = new Field(0, 0, 399, 599);
		String h = "{\"0 292 399 307\"}";
		String v = "{\"45 0 100 599\"}";
		String guitarFrets = "{\"0 292 399 307\", \"100 25 110 575\", \"170 25 110 575\"}";
		
	}
	
	
	private class Field {
		
		private Integer x;
		private Integer y;
		private Integer width;
		private Integer height;
		private Point SW;
		private Point NW;
		private Point NE;
		private Point SE;
		private Line2D.Double west;
		private Line2D.Double north;
		private Line2D.Double east;
		private Line2D.Double south;
		private Rectangle rect;
		
		public Field(Integer x, Integer y, Integer w, Integer h) {
			this.x = x;
			this.y = y;
			this.width = w;
			this.height = h;
			this.SW = new Point(x, y);
			this.NW = new Point(x, height);
			this.NE = new Point(width, height);
			this.SE = new Point(width, y);
			this.west = new Line2D.Double(SW, NW);
			this.north = new Line2D.Double(NW, NE);
			this.east = new Line2D.Double(NE, SE);
			this.south = new Line2D.Double(SE, SW);
			this.rect = new Rectangle(x, y, width, height);			
		}
		
		public Point getSW() {
			return this.SW;
		}
		
		public Point getNW() {
			return this.NW;
		}
		
		public Point getNE() {
			return this.SE;
		}
		
		public Point getSE() {
			return this.SE;
		}
		
		public Line2D getWest() {
			return this.west;
		}
		
		public Line2D getNorth() {
			return this.north;
		}
		
		public Line2D getEast() {
			return this.east;
		}
		
		public Line2D getSouth() {
			return this.west;
		}
		
		public Rectangle getRect() {
			return this.rect;
		}
		
		
	}
	
}
