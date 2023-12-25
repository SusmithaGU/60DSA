public class MiddleOfLinkedList {

  static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

  }

  public static ListNode m(ListNode head) {
    ListNode fast = head, slow = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  /*
   * Each time, slow go 1 steps while fast go 2 steps.
   * When fast arrives at the end, slow will arrive right in the middle.
   */
}
