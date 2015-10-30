package katas;

import java.awt.Rectangle;
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

		String s = "{\"0 292 399 307\"}";

		List<Integer> rawNumbers = convertInputToList(s);
		Map<Integer, Rectangle> inputMap = createMapOfInputRects(rawNumbers);
		
		//Use a map to keep track of intersection calculations so we don't have to do them over and over again.
		Map<Integer, IntersectLog> intersectMap = new HashMap<Integer, IntersectLog>();
		

		Rectangle boundingRect = new Rectangle(0, 0, 400, 600);

		for (Map.Entry<Integer, Rectangle> entry : inputMap.entrySet()) {

			Integer currentKey = entry.getKey();
			Rectangle currentRect = entry.getValue();
			IntersectLog ilog = new IntersectLog();

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
		}
	}

	private void publishResult(Integer[] results) {
		System.out.println(results);
	}

	private Boolean boundaryTest() {
		return Boolean.TRUE;
	}

	// Create rectangle from input coordinates.
	private Rectangle createRectangle(Integer[] coords) {

		Rectangle rect = new Rectangle();
		rect.x = coords[0];
		rect.y = coords[1];
		rect.width = Math.abs(coords[2] - coords[0]);
		rect.height = Math.abs(coords[3] - coords[1]);

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

		System.out.print(rawNumbers.toString());
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

		System.out.println("Input Rects : " + inputMap.size());
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
	

}
