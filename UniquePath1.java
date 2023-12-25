public class UniquePath1 {
    
        public int uniquePaths(int m, int n) {
            int[][] p = new int[m][n];
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (i == 0 || j == 0) {
                        p[i][j] = 1;
                    }
                    else {
                        p[i][j] = p[i][j-1] + p[i-1][j];
                    }
                }
            }
            return p[m-1][n-1];
        }
    public static void main(String[] args) {
        UniquePath1 p=new UniquePath1();
        p.uniquePaths(3,2 );
    }
}


//optimised ans-- Bottom up
/*
 * 
 * class Solution {
    public int uniquePaths(int m, int n) {
        int[][] p = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 || j == 0) {
                    p[i][j] = 1;
                }
                else {
                    p[i][j] = p[i][j-1] + p[i-1][j];
                }
            }
        }
        return p[m-1][n-1];
    }
}
 */