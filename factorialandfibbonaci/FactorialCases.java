public class FactorialCases {

    static int callCount = 0;

    public static long factorial(int n) {
        callCount++;
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void runCase(int[] inputs, String caseName) {
        System.out.println(caseName);
        for (int n : inputs) {
            callCount = 0;
            factorial(n);
            System.out.println("n = " + n + " | Calls = " + callCount);
        }
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {

        int[] bestCase = {5, 6, 7, 8};
        int[] avgCase = {10, 11, 12, 13};
        int[] worstCase = {15, 16, 17, 18};

        runCase(bestCase, "Best Case");
        runCase(avgCase, "Average Case");
        runCase(worstCase, "Worst Case");
    }
}