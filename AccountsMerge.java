import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountsMerge {
    public static List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();

        //Step-1 Make an email as its own parent and add map its owners name to use in the end
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }

        //Step-2 Iterate through all emails in accounts and 
        //make parents,children trees for each account(remember it is different from inheritance tree)
        //Here this is done to group emails in a single account
        for (List<String> a : acts) {

            //Find the parent of first email in each account
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                // Now add this first email as parent to remaining accounts
                parents.put(find(a.get(i), parents), p);
        }

        //Step-3 Using Find method create inheritance trees and then create unions 
        for (List<String> a : acts) {

            //Now again get the parents of first email in each account, 
            //find method will do the real logic of fetching the inheritance of each email.
            //which now you can add in a unified union

            String p = find(a.get(1), parents);
            if (!unions.containsKey(p))
                unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList<String>(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }

    private static String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }

    public static void main(String[] args) {
        String[][] a = { { "David", "David0@m.co", "David1@m.co" }, { "David", "David3@m.co", "David4@m.co" },
                { "David", "David4@m.co", "David5@m.co" }, { "David", "David2@m.co", "David3@m.co" },
                { "David", "David1@m.co", "David2@m.co" } };
        List<List<String>> al = new ArrayList<>();
        for (String[] b : a) {

            List<String> l = new ArrayList<>();
            for (String c : b) {
                l.add(c);
            }

            al.add(l);
        }

        accountsMerge(al);
    }
}
