package gymapp.utils;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class DateUtils {

	public static Date stringToDate(String stringDate) throws ParseException {
		Date ret = null;
		String string = "January 2, 2010";
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
		ret = format.parse(string);

		return ret;
	}
}
