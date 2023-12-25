public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String ans="";
        int maxlen=0;
        if(s.isEmpty()||s.length()==1)return s;
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            int j=ch.length-1;

            //Find identical char to the one at i to check if palindrome.If not then try to find more such identical chars 
            while(i<=j){
                if(ch[i]==ch[j]){
                 if(checkPalindrome(ch,i,j,s)){
                   if(maxlen<j-i+1){
                     maxlen=j-i+1;
                     ans=s.substring(i,j+1);
                     break;
                   }
                 }
                }
                j--;
            }
        }
        return ans;
    }
 
    public boolean checkPalindrome(char[] ch,int i,int j,String s){
        int k=i,h=j;
        while(k<=h){
            if(ch[k]==ch[h]){
                k++;
                h--;
            }
            else return false;
        }
       return true;
    } 

    public static void main(String[] args) {
    LongestPalindromicSubstring l=new LongestPalindromicSubstring();
    l.longestPalindrome("babb");
    }
}


//optimised solution-O(n^2)

/*
 * class Solution {
   public String longestPalindrome(String s) {
  int n = s.length();
  String res = null;
    
  boolean[][] dp = new boolean[n][n];
    
  for (int i = n - 1; i >= 0; i--) {
    for (int j = i; j < n; j++) {
      dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
            
      if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
        res = s.substring(i, j + 1);
      }
    }
  }
    
  return res;
}
}
 */