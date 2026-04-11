import java.util.Random;

public class linearsearch {

    public static long linearSearch(int[] arr, int key) {
        long comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == key) {
                return comparisons;
            }
        }
        return comparisons;
    }

    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }

    public static int[] generateSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] sizes = {10, 20, 30, 40};

        for (int size : sizes) {
            int[] arr = generateSortedArray(size);

            System.out.println("Input Size: " + size);

            long best = linearSearch(arr, arr[0]);          // first element
            long avg = linearSearch(arr, arr[size/2]);      // middle element
            long worst = linearSearch(arr, -1);             // not present

            System.out.println("Best Case Comparisons: " + best);
            System.out.println("Average Case Comparisons: " + avg);
            System.out.println("Worst Case Comparisons: " + worst);
            System.out.println("-----------------------------");
        }
    }
}