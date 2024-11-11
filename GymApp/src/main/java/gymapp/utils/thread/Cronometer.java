package gymapp.utils.thread;

import javax.swing.JLabel;

public class Cronometer extends Thread{
	boolean isCountdown = false;
	int init = 0;
	JLabel display = null;
	
	public Cronometer (boolean isCountdown, int init, JLabel display) {
		this.isCountdown = isCountdown;
		this.init = init;
		this.display = display;
	}
	
	@Override
	public void run() {
		if(isCountdown) {
			while(true) {
				try {
					Thread.sleep(1000);
					init--;
					display.setText(timeToString(init));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else {
			while(true) {
				try {
					Thread.sleep(1000);
					init++;
					display.setText(timeToString(init));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
    public String timeToString(int i) {
    	
    	int hours = 0;
    	int minutes = 0;
    	int seconds = 0;
    	
    	String hoursString = null;
    	String minutesString = null;
    	String secondsString = null;
    	String time = null;
        
    	hours = i/3600;
        if(hours <10){
            hoursString = "0" + hours;
        }else{
            hoursString = String.valueOf(hours);
        }
        minutes = (i/60)%60;
        if(minutes <10){
            minutesString = "0"+ minutes;
        }else{
            minutesString = String.valueOf(minutes);
        }
        seconds = i%60;
        if(seconds <10){
            secondsString = "0"+ seconds;
        }else{
            secondsString = String.valueOf(seconds);
        }
        time = hoursString +":"+ minutesString +":"+ secondsString;
        
        return time;
    }
}
