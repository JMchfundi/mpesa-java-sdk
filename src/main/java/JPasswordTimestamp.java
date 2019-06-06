import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;

/**
 * 
 */

/**
 * @author root
 *
 */

public class JPasswordTimestamp {

	public static String timestampGenerator() {
		return (new SimpleDateFormat("yyyyMMddhhmmss").format(new Timestamp(System.currentTimeMillis()))).toString();
	}

	public static String pwdGenerator(String businessShortcode, String passkey) {
		String password = businessShortcode + "" + passkey + "" + JPasswordTimestamp.timestampGenerator();
		byte[] bytes = null;
		try {
			bytes = password.getBytes("ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		return Base64.getEncoder().encodeToString(bytes);
	}
}
