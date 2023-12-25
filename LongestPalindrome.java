import java.util.HashSet;

public class LongestPalindrome {
    public static int lp(String s){
        int count=0;
        HashSet<Character> set=new HashSet<>();
        for(Character i:s.toCharArray()){
          if(set.contains(i)){
            set.remove(i);
            count++;
          }
          else{
            set.add(i);
          }
        }

        if(!set.isEmpty()) return count*2+1;
        return count*2;
    }

    public static void main(String[] args) {
       int ans=lp("abccccdd");
       System.out.println(ans);
    }
}
