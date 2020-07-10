package tw.com.util;

import java.util.UUID;

public class UUIDUtil {
	public static String getRandomByUUID() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString().replace("-", "");
	}
}
