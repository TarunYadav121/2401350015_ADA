public class FibonacciSimple {

    static int callCount = 0;

    public static long fibonacci(int n) {
        callCount++;
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        int[] inputs = {5, 10, 15, 20};   // SAME input sizes

        System.out.println("Best Case (Small n)");
        for (int n : inputs) {
            callCount = 0;
            fibonacci(n);
            System.out.println("n = " + n + " | Calls = " + callCount);
        }

        System.out.println("--------------------------");

        System.out.println("Average Case (Medium n)");
        for (int n : inputs) {
            callCount = 0;
            fibonacci(n);
            System.out.println("n = " + n + " | Calls = " + callCount);
        }

        System.out.println("--------------------------");

        System.out.println("Worst Case (Large n)");
        for (int n : inputs) {
            callCount = 0;
            fibonacci(n);
            System.out.println("n = " + n + " | Calls = " + callCount);
        }
    }
}

