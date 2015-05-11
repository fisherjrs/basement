package utils;

public class BinaryRep {

	public static void main (String[] args) {
		BinaryRep br = new BinaryRep();
		String binaryString = br.convertIntToBinary(5);
		System.out.println(binaryString);
	}
	
	public String convertIntToBinary(int i) {
		return Integer.toBinaryString(i);
	}
}
