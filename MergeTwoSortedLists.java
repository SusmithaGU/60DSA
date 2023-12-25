public class MergeTwoSortedLists {
    static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        ListNode l2=new ListNode(2);
        ListNode result=mergeLists(l1, l2);

        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
        System.out.println(" ");

    }
}
