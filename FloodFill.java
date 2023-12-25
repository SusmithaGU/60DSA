public class FloodFill {
    static int[][] fill(int[][] image, int sr, int sc, int newcolor) {
        int color = image[sr][sc];
        if (color != newcolor) {// this is the most important check, without this stackoverflow occura
            dfs(image, sr, sc, color, newcolor);
        }
        return image;
    }

    static void dfs(int[][] image, int sr, int sc, int color, int newcolor) {
        if (image[sr][sc] == color) {
            image[sr][sc] = newcolor;
            if (sr - 1 >= 0)
                dfs(image, sr - 1, sc, color, newcolor);
            if (sc - 1 >= 0)
                dfs(image, sr, sc - 1, color, newcolor);
            if (sr + 1 < image.length)
                dfs(image, sr + 1, sc, color, newcolor);
            if (sc + 1 < image[0].length) // the image might not always be a square matrix
                dfs(image, sr, sc + 1, color, newcolor);
        }
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        fill(image, 1, 1, 2);
        // int[][] image={{0,0,0},{0,0,0}};
        // fill(image,0,0,0);

        for (int[] i : image) {
            for (int j : i) {
                System.out.print(" " + j);
            }
            System.out.println();
        }
    }
}
