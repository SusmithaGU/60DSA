import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
    class pair {
        int start;
        int end;

        pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {
        PriorityQueue<pair> pq = new PriorityQueue<pair>((a, b) -> a.start - b.start);
        for (int i = 0; i < intervals.length; i++) {
            pq.add(new pair(intervals[i][0], intervals[i][1]));
        }
        List<pair> al = new ArrayList<pair>();
        pair prev = pq.poll();
        al.add(prev);
        while (!pq.isEmpty()) {
            pair curr = pq.poll();
            int s = curr.start;
            int e = curr.end;
            if (s >= prev.start && s <= prev.end) {
                al.remove(al.size() - 1);
                if (prev.end > e) {
                    curr = new pair(prev.start, prev.end);
                    al.add(curr);
                } else {
                    curr = new pair(prev.start, e);
                    al.add(curr);
                }
            } else {
                curr = new pair(s, e);
                al.add(curr);

            }
            prev = curr;
        }
        int ans[][] = new int[al.size()][2];
        int u = 0;
        for (pair p : al) {
            ans[u][0] = p.start;
            ans[u][1] = p.end;
            u++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 4 }, { 0, 2 }, { 3, 5 } };
        MergeIntervals t = new MergeIntervals();
        t.merge(a);
        System.out.println(" ");
    }
}


//tc=o(nlogn)
