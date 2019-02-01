package leetcode.Q206_Reverse_Linked_List;

public class Solution {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  /**
   * iterative한 방식
   */
  public ListNode reverseListIterative(ListNode head) {
    if (head == null)   return null;

    ListNode pointer = head;
    while (pointer.next != null) {
      ListNode toFront = pointer.next;
      pointer.next = pointer.next.next;
      toFront.next = head;
      head = toFront;
    }
    return head;
  }

  /**
   * recursive한 방식
   */
  public ListNode reverseListRecursive(ListNode head) {
    return null;
  }
}
