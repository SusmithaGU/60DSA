public class RottingOranges {
    static int rottenOranges(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int max_minutes = m * n;
        int k = 0, i, j;
  
        for (k = 0; k < max_minutes; k++) {
           boolean changed = false;
           boolean swapped[][] = new boolean[m][n];
           for (i = 0; i < m; i++) {
              for (j = 0; j < n; j++) {
                 if (arr[i][j] == 2 && !swapped[i][j]) {
                    changed = rotten(arr, i, j, changed, swapped);
                 }
              }
           }
           if (!changed)
              break;
        }
  
        for (i = 0; i < m; i++) {
           for (j = 0; j < n; j++) {
              if (arr[i][j] == 1) {
                 return -1;
              }
           }
        }
        return k;
     }
  
     static boolean rotten(int[][] arr, int i, int j, boolean changed, boolean[][] swapped) {
  
        if (i - 1 >= 0 && arr[i - 1][j] == 1) {
           arr[i - 1][j] = 2;
           swapped[i - 1][j] = true;
           changed = true;
        }
        if (j - 1 >= 0 && arr[i][j - 1] == 1) {
           arr[i][j - 1] = 2;
           swapped[i][j - 1] = true;
           changed = true;
        }
        if (i + 1 < arr.length && arr[i + 1][j] == 1) {
           arr[i + 1][j] = 2;
           swapped[i + 1][j] = true;
           changed = true;
        }
        if (j + 1 < arr[0].length && arr[i][j + 1] == 1) {
           arr[i][j + 1] = 2;
           swapped[i][j + 1] = true;
           changed = true;
        }
        return changed;
     }
  
     public static void main(String[] args) {
        // int[][] arr={
        // {2,1,1},{1,1,0},{0,1,1}
        // };
        //int[][] arr = { { 0, 2 } };
        long start=System.currentTimeMillis();
        int[][] arr={{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(rottenOranges(arr));
        System.out.println(orangesRotting(arr));
        long end=System.currentTimeMillis();
        System.out.println(end-start);
     }
      
        //solution that beats 100 % on leetcode
        public static int orangesRotting(int[][] grid) {
            if(grid == null || grid.length == 0) return -1;
            
            for(int i=0; i<grid.length; i++) {
                for(int j=0; j<grid[0].length; j++) {
                    if(grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
                }
            }
            
            int minutes = 2;
            for(int[] row : grid) {
                for(int cell : row) {
                    if(cell == 1) return -1;
                    minutes = Math.max(minutes, cell);
                }
            }
            
            return minutes - 2;
        }
        
        private static void rotAdjacent(int[][] grid, int i, int j, int minutes) {
            if(i < 0 || i >= grid.length /* out of bounds */
              || j < 0 || j >= grid[0].length /* out of bounds */
              || grid[i][j] == 0 /* empty cell */
              || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
              ) return;
            else {
                grid[i][j] = minutes;
                rotAdjacent(grid, i - 1, j, minutes + 1);
                rotAdjacent(grid, i + 1, j, minutes + 1);
                rotAdjacent(grid, i, j - 1, minutes + 1);
                rotAdjacent(grid, i, j + 1, minutes + 1);
            }
        }
}
