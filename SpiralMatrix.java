import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        visited[0][0] = true;
        ans.add(matrix[0][0]);
        int i = 0, j = 0;

        while (true) {
            boolean swapped = false;
            while (j + 1 < n && !visited[i][j + 1]) {
                ans.add(matrix[i][j + 1]);
                visited[i][j + 1] = true;
                j++;
                swapped = true;
            }
            if (j >= n)
                j--;
            while (i + 1 < m && !visited[i + 1][j]) {
                ans.add(matrix[i + 1][j]);
                visited[i + 1][j] = true;
                i++;
                swapped = true;
            }
            if (i >= m)
                i--;
            while (j - 1 >= 0 && !visited[i][j - 1]) {
                ans.add(matrix[i][j - 1]);
                visited[i][j - 1] = true;
                j--;
                swapped = true;
            }
            if (j < 0)
                j++;
            while (i - 1 >= 0 && !visited[i - 1][j]) {
                ans.add(matrix[i - 1][j]);
                visited[i - 1][j] = true;
                i--;
                swapped = true;
            }
            if (i < 0)
                i++;
            if (!swapped)
                break;
        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        SpiralMatrix tg=new SpiralMatrix();
        tg.spiralOrder(nums);
        System.out.println();
    }
}
