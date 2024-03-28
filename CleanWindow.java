
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        int tests = getNextInt(sc);
        for (int t = 0; t < tests; t++) {
            int n = getNextInt(sc);
            int m = getNextInt(sc);
            Node[] order = new Node[(n * m)];
            order[0] = null;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int x = getNextInt(sc);
                    order[x - 1] = new Node(i, j);
                }
            }
            Integer[][] dp = new Integer[n][m];

            for (int i = order.length - 1; i >= 0; i--) {
                clean(dp, order[i]);
            }
            for (Integer[] integers : dp) {
                System.out.println(Arrays.toString(integers));
            }
        }
    }

    private static void clean(Integer[][] dp, Node node) {
        if (dp[node.x][node.y] != null) {
            return;
        }
        dp[node.x][node.y] = 1;
        dirty(dp, node.x + 1, node.y - 1);
        dirty(dp, node.x + 1, node.y);
        dirty(dp, node.x + 1, node.y + 1);
    }

    private static void dirty(Integer[][] dp, int x, int y) {
        if (x < dp.length && x >= 0 && y < dp[0].length && y >= 0) {
            if (dp[x][y] != null) {
                return;
            }
            dp[x][y] = 0;
            dirty(dp, x + 1, y - 1);
            dirty(dp, x + 1, y);
            dirty(dp, x + 1, y + 1);
        }
    }


    private static int getNextInt(Scanner sc) {
        return sc.nextInt();
    }

    record Node(int x, int y) {
    }
}
