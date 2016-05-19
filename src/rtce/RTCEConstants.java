package rtce;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class RTCEConstants {
	
	//The character set to be used for all char and string variables
	private static final Charset RTCECHARSET = StandardCharsets.US_ASCII;
	
	//The number of characters maximum in a request name
	private static final int REQUESTLENGTH = 8;
	
	//The number of characters maximum in a username
	private static final int USERNAMELENGTH = 20;
	
	//The number of characters maximum in a document title
	private static final int DOCTITLELENGTH = 20;
	
	/**
	 * Returns the character set
	 * @return the character set (ASCII)
	 */
	public static Charset getRtcecharset() {
		return RTCECHARSET;
	}

	/**
	 * Returns the length of the request
	 * @return the number of characters in the request (8)
	 */
	public static int getRequestLength() {
		return REQUESTLENGTH;
	}

	/**
	 * Returns the length of the username
	 * @return the number of characters in the username (20)
	 */
	public static int getUsernameLength() {
		return USERNAMELENGTH;
	}
	
	/**
	 * Returns the length of the document title
	 * @return the number of characters in the document Title (20)
	 */
	public static int getDocTitleLength() {
		return DOCTITLELENGTH;
	}
}
