import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main nbricksMcolors = new Main();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int p = 0; p < t; p++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(nbricksMcolors.ways(n, m, k));

        }
    }

    private long ways(int n, int m, int k) {
        Long[][] dp = new Long[n + 1][k + 1];
        return rec(0, k, n, m, dp)%1000000007;
    }

    private long rec(int level, int k, int n, int m, Long[][] dp) {
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
        long same = 0;
        long notSame = 0;
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
