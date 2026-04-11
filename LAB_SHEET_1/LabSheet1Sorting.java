import java.util.*;

public class LabSheet1Sorting {

    // ---------- Bubble Sort ----------
    public static long bubbleSort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;  // comparison count
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // optimization
        }
        return comparisons;
    }

    // ---------- Selection Sort ----------
    public static long selectionSort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;  // comparison count
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return comparisons;
    }

    // ---------- Insertion Sort ----------
    public static long insertionSort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comparisons++;  // comparison count
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        return comparisons;
    }

    // ---------- Generate Random Array ----------
    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }

    // ---------- Generate Sorted Array (Best Case) ----------
    public static int[] generateSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // ---------- Generate Reverse Sorted Array (Worst Case) ----------
    public static int[] generateReverseArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    // ---------- Main ----------
    public static void main(String[] args) {

        int[] sizes = {10, 20, 30, 40};

        for (int size : sizes) {

            System.out.println("=================================");
            System.out.println("Input Size: " + size);
            System.out.println("=================================");

            // ---------- Best Case ----------
            int[] best = generateSortedArray(size);

            System.out.println("BEST CASE (Sorted Input)");
            System.out.println("Bubble Sort Comparisons: " + bubbleSort(best.clone()));
            System.out.println("Selection Sort Comparisons: " + selectionSort(best.clone()));
            System.out.println("Insertion Sort Comparisons: " + insertionSort(best.clone()));

            // ---------- Worst Case ----------
            int[] worst = generateReverseArray(size);

            System.out.println("\nWORST CASE (Reverse Sorted Input)");
            System.out.println("Bubble Sort Comparisons: " + bubbleSort(worst.clone()));
            System.out.println("Selection Sort Comparisons: " + selectionSort(worst.clone()));
            System.out.println("Insertion Sort Comparisons: " + insertionSort(worst.clone()));

            // ---------- Average Case ----------
            int[] avg = generateRandomArray(size);

            System.out.println("\nAVERAGE CASE (Random Input)");
            System.out.println("Bubble Sort Comparisons: " + bubbleSort(avg.clone()));
            System.out.println("Selection Sort Comparisons: " + selectionSort(avg.clone()));
            System.out.println("Insertion Sort Comparisons: " + insertionSort(avg.clone()));

            System.out.println("\n\n");
        }
    }
}