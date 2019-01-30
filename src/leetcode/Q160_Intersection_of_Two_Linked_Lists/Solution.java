package leetcode.Q160_Intersection_of_Two_Linked_Lists;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  /**
   * Brute force (Runtime: 564 ms)
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode tmpA = headA;

    while (tmpA != null) {
      ListNode tmpB = headB;
      while (tmpB != null) {
        if (tmpA == tmpB)
          return tmpA;
        tmpB = tmpB.next;
      }
      tmpA = tmpA.next;
    }

    return null;
  }

  /**
   * Hash Table (Runtime: 8 ms)
   */
  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    Set<ListNode> set = new HashSet<>();
    ListNode tmpA = headA;
    while (tmpA != null) {
      set.add(tmpA);
      tmpA = tmpA.next;
    }

    ListNode tmpB = headB;
    while (tmpB != null) {
      if (set.contains(tmpB))
        return tmpB;
      tmpB = tmpB.next;
    }

    return null;
  }

  /**
   * Two pointers (Runtime: 1 ms)
   */
  public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    ListNode tmpA = headA;
    ListNode tmpB = headB;

    // lastA, lastB: Last node in each list traverse
    ListNode lastA = null;
    ListNode lastB = null;

    while (tmpA != tmpB) {
      if (tmpA.next == null) {
        lastA = tmpA;
        tmpA = headB;
      } else {
        tmpA = tmpA.next;
      }

      if (tmpB.next == null) {
        lastB = tmpB;
        tmpB = headA;
      } else {
        tmpB = tmpB.next;
      }

      // If there's no cycle in both lists, return null
      if (lastA != null && lastB != null
          && lastA != lastB)
        return null;
    }

    return tmpA;
  }
}
