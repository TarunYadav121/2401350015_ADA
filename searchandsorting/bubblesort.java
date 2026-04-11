// This is a Java program for Bubble Sort algorithm with step counter with arrays having 10 , 20, 30, 40 elements
import java.util.Random;

public class bubblesort {

    public static long bubbleSort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
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

    public static int[] generateReverseArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] sizes = {10, 20, 30, 40};

        for (int size : sizes) {
            System.out.println("Input Size: " + size);

            long best = bubbleSort(generateSortedArray(size));
            long worst = bubbleSort(generateReverseArray(size));
            long avg = bubbleSort(generateRandomArray(size));

            System.out.println("Best Case Comparisons: " + best);
            System.out.println("Worst Case Comparisons: " + worst);
            System.out.println("Average Case Comparisons: " + avg);
            System.out.println("-----------------------------");
        }
    }
}