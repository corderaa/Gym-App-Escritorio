package gymapp.utils;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class DateUtils {

	public static Date stringToDate(String stringDate) throws ParseException {
		Date ret = null;
		DateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.US);
		ret = format.parse(stringDate);

		return ret;
	}
	
	public static String dateToString(Date date) throws ParseException {
		String ret = null;
		DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.US);
		ret = dateFormat.format(date);
		return ret;
	}
	
	public static Long dateToLong(Date date) throws ParseException {
		Long ret = null;
		ret = date.getTime();
		return ret;
	}
}
