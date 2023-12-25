public class Trie {
    static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {
            this.isEndOfWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root = new TrieNode();

    public static void insertWord(String word) {
        TrieNode currnode = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currnode.children[index] == null) {
                currnode.children[index] = new TrieNode();
            }
            currnode = currnode.children[index];
        }

        currnode.isEndOfWord = true;
    }

    public static boolean searchWord(String word) {
        TrieNode currnode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currnode.children[index] == null) {
                return false;
            }
            currnode = currnode.children[index];
        }

        return currnode.isEndOfWord;
    }

    public static void main(String[] args) {
        insertWord("and");
        System.out.println(searchWord("and"));
    }

}
