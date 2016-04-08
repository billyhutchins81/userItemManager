package testpack;

public class OurUtils {
	public static boolean validateTextParam(String val) {
		boolean isValid = true;
		
		if(val == null || val.trim().equals("")) {
			isValid = false;
		}
		return isValid;
	}

	public static String validateErrorMessage(String val) {
		String message = "";
		
		if(val != null && !val.trim().equals("")) message = val;
		
		return message;
	}
	
}
