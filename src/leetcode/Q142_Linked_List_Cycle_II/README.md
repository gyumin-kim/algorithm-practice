Problem
-------------

Given a linked list, return the node where the cycle begins. If there is no cycle, return `null`.

To represent a cycle in the given linked list, we use an integer `pos` which represents the position (0-indexed) in the linked list where tail connects to. If `pos` is `-1`, then there is no cycle in the linked list.

**Note**: Do not modify the linked list.

**Example 1:**
```
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
```
![example 1](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png)

**Example 2:**
```
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```
![example 2](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png)

**Example 3:**
```
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
```
![example 3](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png)


Solution
-------------

처음 생각한 풀이로는 테스트 케이스를 통과하지 못해 [다른 사람의 풀이](https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.?orderBy=most_votes)를 참고하였다.

while문에서 slow와 fast가 만나는 if 조건까지는 141번 문제와 동일하다.  
if문 내부를 이해하기 위해서는 다음이 먼저 증명되어야 한다.  

head부터 cycle이 시작되는 지점까지의 거리를 a,  
cycle이 시작되는 지점부터 slow와 fast가 만난 지점까지의 거리를 b,  
slow와 fast가 만난 지점부터 cycle이 시작되는 지점까지의 거리를 c라고 할 때,  
(a + b + c + b) == 2 * (a + b) 이므로, a와 c는 같다.
그렇기 때문에 tmp와 slow가 한번씩 다음으로 이동하다가 서로 만나면 그 지점이 바로 cycle이 시작되는 지점이다.  

fast는 한 번에 2개씩 이동하므로 a+b에 2를 곱해줘야 한다고 하는데, 이 부분이 잘 이해가 안 된다.

```java
public class Solution {

  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
  
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
  
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
  
      if (slow == fast) {
        ListNode tmp = head;
        while (tmp != slow) {
          tmp = tmp.next;
          slow = slow.next;
        }
        return tmp;
      }
    }
  
    return null;
  }
}
```