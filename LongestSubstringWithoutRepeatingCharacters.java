import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, start = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
               start = Math.max(start, map.get(s.charAt(i))+1);// max of previous start(j) or position of element next to previous start
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

// above is nearly like two pointer technique