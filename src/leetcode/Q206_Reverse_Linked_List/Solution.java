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
      ListNode pointerNextNode = pointer.next;

      /*
        여기서 총 3개의 링크를 바꿔준다. 이 작업을 pointer가 맨 마지막 노드가 될 때까지 반복한다.
        1. pointer(현재 가리키고 있는 곳)가 가리키는 링크 -> 다음다음 노드를 가리키도록
        2. front(pointer 다음에 있는 노드)가 가리키는 링크 -> 현재 head가 가리키고 있는 곳(맨 앞 노드)을 가리키도록
        3. head -> 방금 전에 맨 앞으로 이동한 노드(front)를 가리키도록
       */
      pointer.next = pointer.next.next;
      pointerNextNode.next = head;
      head = pointerNextNode;
    }
    return head;
  }

  /**
   * recursive한 방식
   */
  public ListNode reverseListRecursive(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode p = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;

    // 모든 노드가 뒤집힌 후, p가 첫번째 노드가 된다.
    return p;
  }
}
