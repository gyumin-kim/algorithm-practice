package leetcode.Q141_Linked_List_Cycle;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
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

  /**
   * while문에서 주석 처리한 부분이 최초에 푼 것이고,
   * 실제 실행되는 코드는 다른 사람의 풀이를 참고한 것이다.
   *
   * 같은 지점(head)에서 시작해 slow는 1개 노드씩, fast는 2개 노드씩 움직인다.
   * 만약 cycle이 없다면 fast가 언젠가는 null을 만나 while문을 빠져나와 false를 리턴할 것이고,
   * cycle이 존재한다면 언젠가 fast와 slow가 만나 true를 리턴할 것이다.
   *
   * time complexity: O(n)
   * space complexity: O(1)
   */
  public boolean hasCycle(ListNode head) {
    if (head == null)
      return false;

    ListNode slow = head;
    ListNode fast = head;

//    while (slow.next != null && fast.next.next != null) {
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast)
        return true;
    }

    return false;
  }

  /**
   * Hash Table을 이용하는 방법
   *
   * time complexity: O(n)
   * space complexity: O(n)
   */
  public boolean hasCycle2(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    while (head != null) {
      if (set.contains(head)) {
        return true;
      }
      set.add(head);
      head = head.next;
    }

    return false;
  }
}

/**
 * Follow up:
 *
 * Can you solve it using O(1) (i.e. constant) memory?
 */