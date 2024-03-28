
import java.util.*;

public class Main {

    public static final int MOD = 1000000007;

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
        return rec(0, k, n, m, dp) % MOD;
    }

    private long rec(int level, int k, int n, int m, Long[][] dp) {

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
            same = rec(level + 1, k, n, m, dp) % MOD;
            if (k > 0) {
                notSame = (m - 1) * rec(level + 1, k - 1, n, m, dp) % MOD;
            }
        } else {
            notSame = (m) * rec(level + 1, k, n, m, dp)%MOD;
        }


        dp[level][k] = (same + notSame)%MOD;
        return dp[level][k] ;
    }
}
