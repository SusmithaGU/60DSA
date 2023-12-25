public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] counter=new int[26];
        for(char c: magazine.toCharArray()){
            counter[c-'a']++;
        }

        for(char ch: ransomNote.toCharArray()){
            if(--counter[ch-'a']<0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }
}
