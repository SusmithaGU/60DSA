import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static List<String> m(char[] s, char[] ch, boolean[] visited, int index, List<String> ans) {
        if (index == s.length) {
            String a = new String(ch);
            ans.add(a);
            return ans;
        }
        for (int i = 0; i < s.length; i++) {
            if (!visited[i]) {
                ch[i] = s[index];
                visited[i] = true;
                ans = m(s, ch, visited, index + 1, ans);
                visited[i] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcd";
        List<String> ans = new ArrayList<>();
        char[] ch = new char[s.length()];

        boolean[] visited = new boolean[s.length()];
        m(s.toCharArray(), ch, visited, 0, ans);
        System.out.println("");
    }
}
