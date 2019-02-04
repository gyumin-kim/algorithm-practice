package leetcode.Q002_Add_Two_Numbers;

/**
 * @author Gyumin Kim
 * @since 2019-02-04
 */
public class Solution {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      this.val = x;
    }
  }

  public ListNode addTwoNumbersSolution(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1;
    ListNode q = l2;
    ListNode curr = dummyHead;

    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int digit = x + y + carry;
      carry = digit / 10;
      curr.next = new ListNode(digit % 10);
      curr = curr.next;
      if (p != null) p = p.next;
      if (q != null) q = q.next;
    }

    if (carry > 0) {
      curr.next = new ListNode(carry);
    }

    return dummyHead.next;
  }
}
