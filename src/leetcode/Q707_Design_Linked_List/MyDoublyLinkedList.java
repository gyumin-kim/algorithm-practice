package leetcode.Q707_Design_Linked_List;

/**
 * @author Gyumin Kim
 * @since 2019-02-03
 * https://leetcode.com/problems/design-linked-list
 */
public class MyDoublyLinkedList {

  class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int value) {
      this.val = value;
    }
  }

  private ListNode head;
  private ListNode tail;
  private int size;

  /** Initialize your data structure here. */
  public MyDoublyLinkedList() {
    head = new ListNode(0);
    tail = new ListNode(0);
    head.next = tail;
    tail.prev = head;
  }

  /** Get the value of the index-th node in the linked list.
   * If the index is invalid, return -1. */
  public int get(int index) {
    if (index < 0 || index >= size)
      return -1;

    ListNode curr = head;
    while (index >= 0) {
      curr = curr.next;
      index--;
    }
    return curr.val;
  }

  /** Add a node of value val before the first element of the linked list.
   * After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    addAtIndex(0, val);
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    addAtIndex(size, val);
  }

  /** Add a node of value val before the index-th node in the linked list.
   * If index equals to the length of linked list, the node will be appended to the end of linked list.
   * If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    if (index < 0 || index > size)
      return;

    ListNode curr = head;
    while (index >= 0) {
      curr = curr.next;
      index--;
    }

    ListNode newNode = new ListNode(val);
    newNode.next = curr;
    newNode.prev = curr.prev;
    curr.prev.next = newNode;
    curr.prev = newNode;

    size++;
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size)
      return;

    ListNode curr = head;
    while (index >= 0) {
      curr = curr.next;
      index--;
    }

    curr.prev.next = curr.next;
    curr.next.prev = curr.prev;
    size--;
  }
}
