package leetcode.Q707_Design_Linked_List;

/**
 * https://leetcode.com/problems/design-linked-list
 */
public class MySinglyLinkedList {

  public class Node {
    private int val;
    private Node next;

    Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }
  }

  private Node head;
  private int size;

  /** Initialize your data structure here. */
  public MySinglyLinkedList() {
    this.head = null;
    this.size = 0;
  }

  /** Get the value of the index-th node in the linked list.
   * If the index is invalid, return -1. */
  public int get(int index) {
    if (index < 0 || index >= this.size)
      return -1;

    Node tmp = this.head;
    while (index > 0) {
      tmp = tmp.next;
      index--;
    }

    return tmp.val;
  }

  /** Add a node of value val before the first element of the linked list.
   * After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    Node newNode;
    if (this.size == 0) {
      newNode = new Node(val, null);
    } else {
      newNode = new Node(val, this.head);
    }
    this.head = newNode;
    this.size++;
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    if (this.size == 0) {
      addAtHead(val);
      return;
    }
    Node tmp = this.head;
    while (tmp.next != null) {
      tmp = tmp.next;
    }
    tmp.next = new Node(val, null);
    this.size++;
  }

  /** Add a node of value val before the index-th node in the linked list.
   * If index equals to the length of linked list, the node will be appended to the end of linked list.
   * If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    if (this.size < index)  return;
    if (index == 0) {
      addAtHead(val);
      return;
    }
    if (this.size == index) {
      addAtTail(val);
      return;
    }

    Node tmp = this.head;
    while (index > 1) {
      tmp = tmp.next;
      index--;
    }
    tmp.next = new Node(val, tmp.next);

    this.size++;
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    if (this.size <= index)
      return;
    if (index == 0)
      head = head.next;

    Node tmp = this.head;
    while (index > 1) {
      tmp = tmp.next;
      index--;
    }
    Node deletedNode = tmp.next;
    tmp.next = deletedNode.next;
    deletedNode.next = null;
    this.size--;
  }
}

/**
 * Your MySinglyLinkedList object will be instantiated and called as such:
 * MySinglyLinkedList obj = new MySinglyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */