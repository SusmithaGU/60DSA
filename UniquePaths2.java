import java.util.Arrays;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return util(m, n, 0, 0, dp, obstacleGrid);
    }

    public int util(int m, int n, int i, int j, int[][] dp, int[][] grid) {
        if (i == m || n == j)
            return 0;
        if (grid[i][j] == 1)
            return 0;
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];
        int bottom = 0, right = 0;

        if (i + 1 < m && grid[i + 1][j] != 1) {
            bottom = util(m, n, i + 1, j, dp, grid);
        }
        if (j + 1 < n && grid[i][j + 1] != 1) {
            right = util(m, n, i, j + 1, dp, grid);
        }

        return dp[i][j] = bottom + right;
    }

    public static void main(String[] args) {
        int[][] g={{0,0,0},{0,1,0},{0,0,0}};
        UniquePaths2 u2=new UniquePaths2();
        u2.uniquePathsWithObstacles(g);
    }
}


