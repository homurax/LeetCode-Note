/**
 * 62. Unique Paths
 *
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 7
 * Output: 28
 *
 *
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 *
 * Example 3:
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 *
 * Example 4:
 *
 * Input: m = 3, n = 3
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths {

    /**
     * dp[i][j] 为走到 (i, j) 的路径数量
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] += dp[i - 1][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] += dp[0][j - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

}
