package codes.dynamicProgramming;
public class LCS {

    public static void findLCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int dp[][] = new int[m + 1][n + 1];

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Print length
        System.out.println("Length of LCS = " + dp[m][n]);

        // Backtracking to get sequence
        int i = m, j = n;
        String lcs = "";

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs = X.charAt(i - 1) +" "+ lcs;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("LCS = " + lcs);
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCAB";

        findLCS(X, Y);
    }
}