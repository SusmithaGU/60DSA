import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTrees {
    public static List<Integer> findMHTs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph= createGraph(n, edges);
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1)
                leaves.add(i);
        }

        while (n > 2) {
            n=n-leaves.size();
            ArrayList<Integer> newleaves = new ArrayList<>();
            for (int leave : leaves) {
                int u = graph.get(leave).iterator().next();
                graph.get(u).remove(leave);//this is remove object and not index
                if (graph.get(u).size() == 1)
                    newleaves.add(u);
            }

            leaves = newleaves;
        }
        return leaves;
    }

    private static ArrayList<ArrayList<Integer>> createGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] edges={{3,0},{3,1},{3,2},{3,4},{5,4}};
        List<Integer> ans=findMHTs(6, edges);
        System.out.println(" ");
    }
}


//link for this solution in leetcode solutions:
//https://leetcode.com/problems/minimum-height-trees/solutions/76055/share-some-thoughts/


//My solution which exceeded time limit

/*
 * static class pair {
        int node;
        int height;

        pair(int node, int height) {
            this.height = height;
            this.node = node;
        }
    }

    public static List<Integer> findMHTs(int n, int[][] edges) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        List<Integer> ans = new ArrayList<>();

        ArrayList<ArrayList<Integer>> graph = createGraph(n, edges);
        for (int i = 0; i < n; i++) {
            int height = findHeight(i, graph, n);
            pq.add(new pair(i, height));
        }
        pair first = pq.poll();
        int minheight = first.height;
        ans.add(first.node);
        while (pq.peek().height == minheight) {
            ans.add(pq.poll().node);
        }
        return ans;
    }

    private static ArrayList<ArrayList<Integer>> createGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        return list;
    }

    private static int findHeight(int node, ArrayList<ArrayList<Integer>> graph, int n) {

        boolean[] visited=new boolean[n];
        Queue<Integer> curr = new LinkedList<Integer>();
        curr.add(node);
        int count = 0;
        visited[node]=true;
        while (!curr.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (!curr.isEmpty()) {
                int a = curr.poll();
                for(int j:graph.get(a)){
                    if(!visited[j]){
                        temp.add(j);
                        visited[j]=true;
                    }
                }
               // temp.addAll(graph.get(a).stream().filter(t->!visited[t]).collect(Collectors.toList()));
            }
            curr.addAll(temp);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] edges={{1,0},{1,2},{1,3}};
        List<Integer> ans=findMHTs(4, edges);
        System.out.println("");
    }
 */