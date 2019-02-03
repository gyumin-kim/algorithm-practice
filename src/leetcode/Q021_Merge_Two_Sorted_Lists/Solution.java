package leetcode.Q021_Merge_Two_Sorted_Lists;

/**
 * @author Gyumin Kim
 * @since 2019-02-03
 */
public class Solution {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode p = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else if (l1.val > l2.val) {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }

    if (l1 == null) p.next = l2;
    if (l2 == null) p.next = l1;

    return dummy.next;
  }



















  /*
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergedList;
        if (l1.val < l2.val) {
            mergedList = l1;    // l1, mergedList => ListNode (both)
            mergedList.next = mergeTwoLists(l1.next, l2);
        }
        else {
            mergedList = l2;
            mergedList.next = mergeTwoLists(l1, l2.next);
        }

        return mergedList;
   */
}