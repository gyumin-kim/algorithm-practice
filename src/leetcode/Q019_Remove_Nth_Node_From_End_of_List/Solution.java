package leetcode.Q019_Remove_Nth_Node_From_End_of_List;

public class Solution {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode first = head;
    ListNode second = head;

    for (int i = 0; i < n; i++) {
      if (first.next == null) {
        head = second.next;
        return head;
      }
      first = first.next;
    }

    while (first.next != null) {
      first = first.next;
      second = second.next;
    }

    // Delete the node
    ListNode deletedNode = second.next;
    second.next = deletedNode.next;
    deletedNode.next = null;

    return head;
  }
}
