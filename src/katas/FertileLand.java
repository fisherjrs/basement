package katas;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class FertileLand {

	public static void main(String[] args) {
		FertileLand land = new FertileLand();
		
		Rectangle fullField = new Rectangle(0,0, 400, 600);
		Integer totalArea = fullField.width * fullField.height;
		
		Rectangle rect1 = new Rectangle(0, 292, 400 - 0, 307 - 292);
		//Rectangle rect1 = new Rectangle(192, 0, 207-192, 600 );
		System.out.println(rect1);
		
		if( rect1.width >= fullField.width && rect1.height >= fullField.height) {
			System.out.println("Stop processing. There is no fertile land.");
		}
		
		Integer subtractArea = rect1.width * rect1.height;
		
		List<Integer> areas = new ArrayList<Integer>();
		
		if(rect1.width >= fullField.width) {
			System.out.println("Split the field north and south");
			Rectangle southField = new Rectangle(0,0,rect1.width, rect1.y);
			Rectangle northField = new Rectangle(0,rect1.y + rect1.height, rect1.width, fullField.height - (rect1.y + rect1.height + 1) );
			System.out.println("southField" + southField);
			System.out.println("northField" + northField);
			areas.add(southField.width * southField.height);
			areas.add(northField.width * northField.height);
			
		} else if(rect1.height >= fullField.height) {
			System.out.println("Split the field east & west");
			Rectangle westField = new Rectangle(0,0,rect1.x, rect1.height);
			Rectangle eastField = new Rectangle(rect1.x + rect1.width, 0, fullField.width - (rect1.x + rect1.width +1), rect1.height);
			System.out.println("westField" + westField);
			System.out.println("eastField" + eastField);
			areas.add(westField.width * westField.height);
			areas.add(eastField.width * eastField.height);
		}
		
		
		
		//Integer remainingArea = totalArea - subtractArea;
		
		System.out.println(areas.toString());
	}
	
	public FertileLand() {
		// TODO Auto-generated constructor stub
	}
	
//	public Polygon subtract(Rectangle rect) {
//		
//	}

}
