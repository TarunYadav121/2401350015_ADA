// This is a Java program for Selection Sort algorithm with step counter with arrays having 10 , 20, 30, 40 elements


import java.util.Random;

public class selectionsort {

    public static long selectionSort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;   // counting comparison
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

            long best = selectionSort(generateSortedArray(size));
            long worst = selectionSort(generateReverseArray(size));
            long avg = selectionSort(generateRandomArray(size));

            System.out.println("Best Case Comparisons: " + best);
            System.out.println("Worst Case Comparisons: " + worst);
            System.out.println("Average Case Comparisons: " + avg);
            System.out.println("-----------------------------");
        }
    }
}