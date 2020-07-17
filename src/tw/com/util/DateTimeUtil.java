package tw.com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	public static String getNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		return sdf.format(new Date());
	}
	public static String getGoodsNo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");		
		return sdf.format(new Date());
	}
}
