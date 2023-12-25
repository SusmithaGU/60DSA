public class NumberOfIslands {
    public static int countIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length, i, j, count = 0;

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    reduceGrid(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void reduceGrid(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        reduceGrid(grid, i + 1, j);
        reduceGrid(grid, i, j + 1);
        reduceGrid(grid, i - 1, j);
        reduceGrid(grid, i, j - 1);
    }

    public static void main(String[] args) {
        // int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, {
        // 0, 0, 0, 1, 1 } };

        int[][] grid = { { 1, 1, 1 }, { 0, 1, 0 }, { 1, 1, 1 } }; // this case show that its imp to go for i-1 and j-1
                                                                  
        System.out.println(countIslands(grid));
    }
}