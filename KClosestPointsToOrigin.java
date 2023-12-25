import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
      static class pair {
        int index;
        int val;

        pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int i = 0, n = points.length;
        for (i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int sumOfSquare = (x * x) + (y * y);

            pq.add(new pair(i, sumOfSquare));  //O(logn)
        }
        int j = 0;
        while (!pq.isEmpty() && j < k) {
            pair p = pq.poll();      //O(logn)
            ans[j][0] = points[p.index][0];
            ans[j][1] = points[p.index][1];
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] points = { { -2, 2 }, { 1, 3 } };
        int[][] ans = kClosest(points, 1);
        System.out.println();
    }
}


//tc= O(nlogn)