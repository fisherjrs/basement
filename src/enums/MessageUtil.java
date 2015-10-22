package enums;

enum MessageUtil {
	//No enum instance
	; //required to avoid compiler error.
	
	public static String getFormattedMessage(String message) {
		return String.format("The sky is blue ::: %s", message);
	}
}