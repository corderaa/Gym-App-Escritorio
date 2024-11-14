package gymapp.utils;

public class Functionalities {
	public int timeToInt(String time) {
		int ret = 0;
		String[] splitedTime = time.split(":");

		ret = Integer.parseInt(splitedTime[0]) * 60 + Integer.parseInt(splitedTime[1]);
		if (splitedTime.length == 3)
			ret = ret * 60 + Integer.parseInt(splitedTime[2]);
		return ret;
	}

	public String percentProgress(String time, String estimatedTime) {

		String ret = null;
		int timeInt = 0;
		int estimatedTimeInt = 0;
		int percent = 0;

		timeInt = timeToInt(time);
		estimatedTimeInt = timeToInt(estimatedTime);
		percent = timeInt * 100 / estimatedTimeInt;
		ret = percent + "%";
		return ret;
	}
}
