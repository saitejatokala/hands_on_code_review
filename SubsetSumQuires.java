package dp;

public class NbricksMcolors {
    public static void main(String[] args) {
        NbricksMcolors nbricksMcolors = new NbricksMcolors();

        System.out.println(nbricksMcolors.ways(3, 2, 2));
    }

    private int ways(int n, int m, int k) {
        Integer[][] dp = new Integer[n + 1][k + 1];
        return rec(0, n, m, k, dp);
    }

    private int rec(int level, int n, int m, int k, Integer[][] dp) {
        if (k < 0) {
            return 1;
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
            same = rec(level + 1, n, m, k - 1, dp);
            if(k>0) {
                notSame = (m - 1) * rec(level + 1, n, m, k, dp);
            }
        }else {
                notSame = m * rec(level + 1, n, m, k, dp);
        }

        dp[level][k] = same + notSame;
        return same + notSame;
    }
}
