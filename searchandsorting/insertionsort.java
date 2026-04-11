// This is a Java program for insertion Sort algorithm with step counter with arrays having 10 , 20, 30, 40 elements

import java.util.Random;

public class insertionsort {

    public static long insertionSort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comparisons++;   // counting comparison
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

            long best = insertionSort(generateSortedArray(size));
            long worst = insertionSort(generateReverseArray(size));
            long avg = insertionSort(generateRandomArray(size));

            System.out.println("Best Case Comparisons: " + best);
            System.out.println("Worst Case Comparisons: " + worst);
            System.out.println("Average Case Comparisons: " + avg);
            System.out.println("-----------------------------");
        }
    }
}