package leetcode.Q203_Remove_Linked_List_Elements;

public class Solution {

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode removeElements(ListNode head, int val) {
    ListNode prev = head;
    ListNode pointer = head;

    while (pointer != null) {
      if (pointer.val == val) {
        // Remove element
        ListNode next = pointer.next;
        if (pointer == head)
          head = next;
        prev.next = pointer.next;
        pointer.next = null;
        pointer = next;
      }
      else {
        prev = pointer;
        pointer = pointer.next;
      }
    }

    return head;
  }

  public ListNode removeElements2(ListNode head, int val) {
    ListNode fakeHead = new ListNode(-1); // prev을 사용하기 위한 가짜 node
    fakeHead.next = head;

    ListNode prev = fakeHead;
    ListNode curr = head;

    while (curr != null) {
      if (curr.val == val)
        prev.next = curr.next;
      else
        prev = prev.next;
      curr = curr.next;
    }
    return fakeHead.next; // (= head)
  }
}
