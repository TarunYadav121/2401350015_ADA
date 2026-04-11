public class binnarysearch {

    public static long binarySearch(int[] arr, int key) {
        long comparisons = 0;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return comparisons;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return comparisons;
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

            long best = binarySearch(arr, arr[size/2]);   // middle element
            long worst = binarySearch(arr, -1);           // not present
            long avg = binarySearch(arr, arr[size/3]);    // some random position

            System.out.println("Best Case Comparisons: " + best);
            System.out.println("Average Case Comparisons: " + avg);
            System.out.println("Worst Case Comparisons: " + worst);
            System.out.println("-----------------------------");
        }
    }
}