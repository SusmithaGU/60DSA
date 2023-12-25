public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
            if (first == second)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=head;
        System.out.println(hasCycle(head));
    }
}
