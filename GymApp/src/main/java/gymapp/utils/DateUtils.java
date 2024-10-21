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
}
