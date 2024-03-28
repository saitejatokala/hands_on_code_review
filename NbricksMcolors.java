package dp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main nbricksMcolors = new Main();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println(t);
        for (int p = 0; p < t; p++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(nbricksMcolors.ways(n, m, k));

        }
    }

    private int ways(int n, int m, int k) {
        Integer[][] dp = new Integer[n + 1][k + 1];
        return rec(0, k, n, m, dp);
    }

    private int rec(int level, int k, int n, int m, Integer[][] dp) {
        if (k < 0) {
            return 0;
        }
        if (level >= n) {
            if (k == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[level][k] != null) {
            return dp[level][k];
        }
        int same = 0;
        int notSame = 0;
        if (level != 0) {
            same = rec(level + 1, k, n, m, dp);
            notSame = (m - 1) * rec(level + 1, k - 1, n, m, dp);
        } else {
            notSame = (m) * rec(level + 1, k, n, m, dp);
        }


        dp[level][k] = same + notSame;
        return same + notSame;
    }
}
