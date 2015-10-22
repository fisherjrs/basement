package datatypes;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class PrimitiveKatas { 
	
	private static Logger LOG = LoggerFactory.getLogger(PrimitiveKatas.class);
	
	public static void main(String[] args) {
		LOG.debug(String.format("run the app %s", "now"));
		PrimitiveKatas pk = new PrimitiveKatas();
		pk.casting();
	}
	
	private PrimitiveKatas(){
		
	}
	
	public void casting(){
		byte b = 127;
		int i = 1999999999;
		long l2 = 3104353456547457644L;
		byte convertB = (byte) l2;
		int convertI = (int) l2;
		LOG.debug(String.format("Result:: %4s, %4s, %4s", l2, convertB, convertI));
	}
}