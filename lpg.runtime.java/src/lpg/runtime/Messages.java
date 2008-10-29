package lpg.runtime;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class Messages {

	static protected ResourceBundle bundle;
	static {
		bundle = ResourceBundle.getBundle("lpg.runtime.Messages");
	}
	
	public static String getString(String s) {
		return bundle.getString(s);
	}
}
