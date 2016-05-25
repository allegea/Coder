import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PathsToTheTop {

    private static final int[] steps = { 1, 2, 3};
    private static Long[] dp;

    private static int findPaths(int n, int current) {
        if (current == n) return 1;
        if (current > n)  return 0;
        int count = 0;
        for (int x : steps) {
            count += findPaths(n, current + x);
        }
        return count;
    }

    private static long findPathsDP(int n, int current) {
        if (current == n) return 1L;
        if (current > n) return 0L;
        if (dp[current] != null) return dp[current];
        long count = 0;
        for (int x : steps)
            count += findPathsDP(n, current + x);
        return dp[current] = count;
    }
    
    private static long findPathDPBottomUp(int n) {
        long[] dps = new long[n + 1];
        for (int x : steps) {
            if (x > n) break;
            dps[x] = 1L;
        }
        for (int i = 1; i <= n; i++) {
            for (int x : steps) {
                if (i + x > n) break;
                dps[i + x] += dps[i];
            }
        }
        return dps[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        dp = new Long[n + 1];
        System.out.println(findPathsDP(n, 0));
        System.out.println(findPathDPBottomUp(n));
        //System.out.println(findPaths(n, 0));
        in.close();
    }
}
