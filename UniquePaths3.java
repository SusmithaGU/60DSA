public class UniquePaths3 {
    public int paths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean found = false;
        int i = 0, j = 0;

        // Find the starting point
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }
        // ---------
        int count = 0;
        visited[i][j] = true;
        return util(grid, m, n, visited, i, j, count);
    }

    public int util(int[][] grid, int m, int n, boolean[][] visited, int i, int j, int count) {

        //If found the end point this path should be considered for validation
        if (grid[i][j] == 2) {

            //check If all the cells are touched by our path before including this path in answer
            if (isValidPath(grid, visited, m, n)) {
                count = count + 1;
                return count;
            }
        }

        //If you find an obstacle return back
        if (grid[i][j] == -1)
            return 0;

        // Move forward when you can
        if (i + 1 < m && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            count = util(grid, m, n, visited, i + 1, j, count);
            visited[i + 1][j] = false;
        }
        if (j + 1 < n && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            count = util(grid, m, n, visited, i, j + 1, count);
            visited[i][j + 1] = false;
        }
        if (i - 1 >= 0 && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            count = util(grid, m, n, visited, i - 1, j, count);
            visited[i - 1][j] = false;
        }
        if (j - 1 >= 0 && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            count = util(grid, m, n, visited, i, j - 1, count);
            visited[i][j - 1] = false;
        }
        return count;
    }

    public boolean isValidPath(int[][] grid, boolean[][] visited, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] g = { { 0, 0, 0, 0, 0, 0, 2, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 } };
        UniquePaths3 u3 = new UniquePaths3();
        int p = u3.paths(g);
        System.out.println(p);
    }
}
// https://leetcode.com/problems/unique-paths-iii/


//optimised solution
/*
 * class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zero = 0 , a = 0, b = 0 ;
        for(int r = 0; r < grid.length ; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0)   zero++;
                   else if(grid[r][c] == 1){
                    a = r;
                    b = c;
                }
            }
        }
        return path(grid, a, b, zero);
    }
    private int path(int[][] grid, int x, int y, int zero){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1)
           return 0;
        if(grid[x][y] == 2)
           return zero == -1 ? 1 : 0;
        grid[x][y] = -1;
        zero--;
        int totalCount = path(grid, x + 1, y, zero) + path(grid, x, y + 1, zero) +
                         path(grid, x - 1, y, zero) + path(grid, x, y - 1, zero);
        grid[x][y] = 0;
        zero++;

        return totalCount;
    }
}
 */