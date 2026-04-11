package codes.dynamicProgramming;
import java.util.*;

class Activity {
    int start, finish;

    Activity(int s, int f) {
        start = s;
        finish = f;
    }
}

public class ActivitySelection {

    public static void selectActivities(Activity arr[]) {

        Arrays.sort(arr, (a, b) -> a.finish - b.finish);

        System.out.println("Selected Activities:");

        int lastFinish = arr[0].finish;
        System.out.println("(" + arr[0].start + ", " + arr[0].finish + ")");

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].start >= lastFinish) {
                System.out.println("(" + arr[i].start + ", " + arr[i].finish + ")");
                lastFinish = arr[i].finish;
            }
        }
    }

    public static void main(String[] args) {

        Activity arr[] = {
            new Activity(1, 2),
            new Activity(3, 4),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(8, 9),
            new Activity(5, 9)
        };

        selectActivities(arr);
    }
}