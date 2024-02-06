import java.util.ArrayList;
import java.util.List;

public class AnagramsInString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if (p.length() > s.length())
            return list; // Base Condition

        int N = s.length(); // Array1 of s
        int M = p.length(); // Array2 of p
        int[] count = freq(p); // intialize only 1 time

        int[] currentCount = freq(s.substring(0, M)); // freq function, update every-time according to sliding window

        if (areSame(count, currentCount)) // areSame function
            list.add(0);

        int i;
        for (i = M; i < N; i++) { // going from 3 to 9 in above example
            currentCount[s.charAt(i - M) - 'a']--; // blue pointer, decrement frequency
            currentCount[s.charAt(i) - 'a']++; // red pointer, increment frequency
            if (areSame(count, currentCount)) { // now check, both array are same
                list.add(i - M + 1); // if we find similar add their index in our list
            }
        }
        return list;
    }

    private static boolean areSame(int[] x, int[] y) {
        for (int i = 0; i < 26; i++) {
            if (x[i] != y[i]) // compare all the frequency & doesnn't find any di-similar frequency return
                              // true otherwise false
                return false;
        }

        return true;
    }

    private static int[] freq(String s) {
        int[] count = new int[26]; // create array of size 26
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // update acc. to it's frequency
        }

        return count; // and return count
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        findAnagrams(s, p);

    }
}


//My solution which exceeded the time limit
/*
 * public static List<String> findAnagrams(char[] s, char[] ch, boolean[] visited, int index, List<String> ans) {
        if (index == s.length) {
            String a = new String(ch);
            ans.add(a);
            return ans;
        }
        for (int i = 0; i < s.length; i++) {
            if (!visited[i]) {
                ch[i] = s[index];
                visited[i] = true;
                ans = findAnagrams(s, ch, visited, index + 1, ans);
                visited[i] = false;
            }
        }
        return ans;
    }

    public static List<Integer> util(List<String> anagrams, String s) {
        List<Integer> g = new ArrayList<>();
        for (String anagram : anagrams) {
            int i = 0;
            while (i < s.length()) {
                int y = s.indexOf(anagram, i);
                if(y<0) break;
                g.add(y);
                i = ++y;

            }
        }
        return g;
    }

    public static void main(String[] args) {
        String s = "yqrbgjdwtcaxzsnifvhmou";
        List<String> ans = new ArrayList<>();
        char[] ch = new char[s.length()];
        String p = "caxzsnifvhmouwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmou";
        boolean[] visited = new boolean[s.length()];
        List<String> a = findAnagrams(s.toCharArray(), ch, visited, 0, ans);
        //List<Integer> res = util(a, p);
        System.out.println("");
        System.out.println(p.indexOf("acb",5));
    }
 */