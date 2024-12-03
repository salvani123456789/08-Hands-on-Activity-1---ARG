import java.time.LocalTime;
import java.util.Scanner;

public class Monday {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time for alarm in this format (HH:MM): ");
        String inputTime = scanner.nextLine();

        Weekday weekday = new MyWeekday();
        weekday.setAlarm(inputTime);
        weekday.showAlarm();
    }
}

interface Alarm {
    void setAlarm(String time);
    void showAlarm();
}

abstract class Weekday implements Alarm {
    private String alarmTime;

    @Override
    public void setAlarm(String time) {
        this.alarmTime = time;
    }

    @Override
    public void showAlarm() {
        LocalTime alarm = LocalTime.parse(alarmTime);
        LocalTime now = LocalTime.now();

        if (alarm.isAfter(now)) {
            System.out.println("Alarm is set for tomorrow!");
        } else {
            System.out.println("I'll wake you up later!");
        }
    }
}
class MyWeekday extends Weekday {
}