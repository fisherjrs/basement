package katas;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) throws Exception {

		Solution solution = new Solution();
		solution.go();

	}

	public Solution() {

	}

	private void go() {
		// {"12 12 24 24", "48 48 64 64"}

		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// System.out.print("Enter String");
		// String s = br.readLine();

		Field field = new Field(0, 0, 399, 599);
		
		//Keep a list of rects that will hold overlap areas of rects ... it will help to prevent from subtracting overlapped barren areas more than once.
		//We also don't want to add the barren areas to the subtraction side more than once so we'll need to do a hit test for these as well.
		List<Rectangle> superBarrenRects = new ArrayList<Rectangle>();
		
		String h = "{\"0 292 399 307\"}";
		String v = "{\"45 0 100 599\"}";
		String guitarFrets = "{\"0 292 399 307\", \"100 25 110 575\", \"170 25 110 575\"}";

		List<Integer> rawNumbers = convertInputToList(guitarFrets);
		Map<Integer, Rectangle> inputMap = createMapOfInputRects(rawNumbers);
		
		//Use a map to keep track of intersection calculations so we don't have to do them over and over again.
		Map<Integer, IntersectLog> intersectMap = new HashMap<Integer, IntersectLog>();
		

		Rectangle boundingRect = field.getRect();

		for (Map.Entry<Integer, Rectangle> entry : inputMap.entrySet()) {

			Integer currentKey = entry.getKey();
			Rectangle currentRect = entry.getValue();
			IntersectLog ilog = new IntersectLog();
			System.out.println("Key :: " + currentKey);
			System.out.println("west boundary :: " + boundaryTest(currentRect, field.west));
			System.out.println("north boundary :: " + boundaryTest(currentRect, field.north));
			System.out.println("east boundary :: " + boundaryTest(currentRect, field.east));
			System.out.println("south boundary :: " + boundaryTest(currentRect, field.south));
			
			for (Map.Entry<Integer, Rectangle> entry2 : inputMap.entrySet()) {
				if(!entry.equals(entry2)) {
					Integer nextKey = entry2.getKey();
					Rectangle nextRect = entry2.getValue();
					System.out.println(String.format("Next key %4s :: %b", nextKey, intersectTest(currentRect, nextRect)));
				}
			}
			System.out.println("");
/*			
			if (currentRect.x <= boundingRect.x) {
				ilog.westIntersect = Boolean.TRUE;
			}

			if ((currentRect.x + currentRect.width + 1) >= (boundingRect.x + boundingRect.width)) {
				ilog.eastIntersect = Boolean.TRUE;
			}

			if (ilog.dividerHTest()) {
				// Stop we have a horizantal divider.
				Integer bounding = boundingRect.width * boundingRect.height;
				Integer southernBounds = (currentRect.width + 1)
						* currentRect.y;
				Integer northernBounds = (currentRect.width + 1)
						* (boundingRect.height - (currentRect.y
								+ currentRect.height + 1));

				System.out.println(String.format("%s %s", southernBounds,
						northernBounds));
				return;
			}

			if (currentRect.y <= boundingRect.y) {
				ilog.southIntersect = Boolean.TRUE;
			}

			if ((currentRect.y + currentRect.height) >= (boundingRect.y + boundingRect.height)) {
				ilog.northIntersect = Boolean.TRUE;
			}

			ilog.PrintLog();

			intersectMap.put(currentKey, ilog);
*/
		}

	}
	
	private Integer calculateFertileArea(Rectangle field, Integer barrenArea, List<Rectangle> superBarrenRects) {
		List<Rectangle> minimizedSuperBarrenRects = new ArrayList<Rectangle>();
		for(Rectangle superBarrenRect : superBarrenRects) {
			
		}
	}
	
	private Integer calculateBarrenArea(Rectangle current, Rectangle next) {
		
	}
	
	private Boolean intersectTest(Rectangle current, Rectangle next, List<Rectangle> overlap) {
		Boolean result = Boolean.TRUE;
		
		Rectangle r = current.intersection(next);
		if(r != null) {
			overlap.add(r);
			result = Boolean.TRUE;
		}
		return result;
	}

	private Boolean boundaryTest(Rectangle current, Line2D line) {
		Boolean test = current.intersectsLine(line);
		return test;
	}
	
	private void publishResult(Integer[] results) {
		System.out.println(results);
	}

	

	// Create rectangle from input coordinates.
	private Rectangle createRectangle(Integer[] coords) {

		Rectangle rect = new Rectangle();
		rect.x = coords[0];
		rect.y = coords[1];
		rect.width = Math.abs(coords[2] - coords[0]);
		rect.height = Math.abs(coords[3] - coords[1]);
		
		System.out.println("rect : " + rect);

		return rect;
	}
	

	private List<Integer> convertInputToList(String input) {
		// Clean up string... (necessary?)
		input.replaceAll("\\p{P}", "");

		// Pull numbers from string.
		List<Integer> rawNumbers = new ArrayList<Integer>();
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(input);
		
		while (m.find()) {
			rawNumbers.add(Integer.parseInt(m.group()));
		}

		if (rawNumbers.size() == 0 || rawNumbers.size() % 4 > 0) {
			System.err.println("Invalid coordinates. Check that your list is in the format {\"n1 n2 n3 n4\", \"n1 n2 n3 n4\", ...}");
			// System.exit(0);
			throw new IllegalArgumentException("Invalid coordinates");
		}

		System.out.println("Numbers " + rawNumbers.toString());
		return rawNumbers;
	}
	
	private Map<Integer, Rectangle> createMapOfInputRects(List<Integer> rawNumbers) {
		Map<Integer, Rectangle> inputMap = new HashMap<Integer, Rectangle>();
		int count = 0;
		Integer mapKey = 0;
		Integer[] coords = new Integer[4];
		for (Integer coord : rawNumbers) {
			if (count < 4) {
				coords[count] = coord;
			}

			count++;

			if (count == 4) {
				inputMap.put(mapKey, createRectangle(coords));
				mapKey++;
				count = 0;
			}
		}

		System.out.println("Number of Input Rects : " + inputMap.size());
		return inputMap;
	}

	private class IntersectLog {
		public Integer key;
		public Boolean westIntersect;
		public Boolean northIntersect;
		public Boolean eastIntersect;
		public Boolean southIntersect;
		public List<Integer> inputRectIntersectList = new ArrayList<Integer>();

		public Boolean dividerHTest() {
			return (westIntersect && eastIntersect);
		}

		public Boolean dividerVTest() {
			return (northIntersect && eastIntersect);
		}

		public void PrintLog() {
			System.out.println(this.westIntersect + " " + this.eastIntersect);
		}
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
