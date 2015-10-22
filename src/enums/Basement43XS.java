package enums;

public class Basement43XS {
	
	public interface Operation {
		double apply(double x, double y);
	}
	
	public enum Month {
		NOVEMBER("Nov");
		private final String monthName;
		private Month(String monthName) {
			this.monthName = monthName;
		}
		
		@Override
		public String toString() {
			return monthName;
		}
	}
	
	public enum BasicOperation implements Operation {
		PLUS("+") { public double apply(double x, double y) { return x + y; }},
		MINUS("-") { public double apply(double x, double y) { return x - y; }},
		TIMES("*") { public double apply(double x, double y) { return x * y; }},
		DIVIDE("/") { public double apply(double x, double y) { return x + y; }};
		
		private final String symbol;
		
		private BasicOperation(String symbol) {
			this.symbol = symbol;
		}
		
		@Override
		public String toString() {
			return symbol;
		}
	}
	
	public enum ExtendedOperation implements Operation {
		EXP("^") {public double apply(double x, double y) { return Math.pow(x, y);}},
		REMAINDER("%") {public double apply(double x, double y) { return x % y;}};
		
		private final String symbol;
		
		private ExtendedOperation(String symbol) {
			this.symbol = symbol;
		}
		
		@Override
		public String toString() {
			return symbol;
		}
	}
	
	public static void main(String[] args) {
		//ExtendedOperation.REMAINDER.apply(20, 3);
		System.out.println(String.format("Modulus :: %s", ExtendedOperation.REMAINDER));
		System.out.println(String.format("Month :: %s", Month.NOVEMBER));
		
		//Operation myOps = ExtendedOperation.EXP;
		
		test(ExtendedOperation.class, 35, 8);
		//test(Month.class, 23, 12); //Fail. the test method is expecting an enum type T that is also type Operation.
	}
	
	private static <T extends Enum<T> & Operation> void test(Class<T> optSet, double x, double y) {
		for(Operation op : optSet.getEnumConstants()) {
			System.out.println(String.format("Op set enum ::: %s %s %s %s", x, op, y, op.apply(x, y)));
		}
	}

}