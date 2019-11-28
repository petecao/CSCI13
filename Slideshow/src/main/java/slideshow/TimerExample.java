import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer example
 */
public class TimerExample {
    private Timer timer;

    private TimerExample(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    private class RemindTask extends TimerTask {
        public void run() {
            System.out.format("Time's up!%n");
            timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
        new TimerExample(5);
        System.out.format("Task scheduled.%n");
    }
}
