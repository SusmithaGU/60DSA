import java.util.Arrays;

public class ValidAnagram {
    public static boolean isValid(String s,String t){
         if(s.length()!=t.length()) return false;
        char[] sch=s.toCharArray();
        Arrays.sort(sch);  // time complexity for sort operation=O(n log(n))
        
        char[] tch=t.toCharArray();
        Arrays.sort(tch);
        
        for(int i=0;i<sch.length;i++){
            if(sch[i]!=tch[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("anagram","nagaram"));
        System.out.println(isValid("ab", "b"));
    }
}
//tc=O(nlogn)