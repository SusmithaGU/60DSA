import java.util.ArrayList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = createGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, i, visited, onPath)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<ArrayList<Integer>> createGraph(int n, int[][] prereq) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int j = 0; j <= n; j++) {
            ans.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prereq.length; i++) {

            int a = prereq[i][0];
            int b = prereq[i][1];

            ans.get(a).add(b);
        }

        return ans;
    }

    public boolean hasCycle(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, boolean[] onPath) {

        if (visited[node]) {
            return false;
        }
        onPath[node] = true;
        visited[node] = true;
        for (Integer k : graph.get(node)) {
            if (onPath[k] || hasCycle(graph, k, visited, onPath)) {
                return true;
            }
        }
        onPath[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
        CourseSchedule c = new CourseSchedule();
        System.out.println(c.canFinish(2, prerequisites));
    }
}
