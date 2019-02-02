Problem
-------------
https://leetcode.com/problems/reverse-linked-list  

Reverse a singly linked list.  

**Example:**  

```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```  

**Follow up:**  

A linked list can be reversed either iteratively or recursively. Could you implement both?  
  
  
My Idea & Solution
-------------

1. 반복하는 방식은 하나의 loop 안에서 총 3개의 링크를 수정한다는 것이 포인트다. 최초에 맨 앞에 있었던 노드가
맨 뒤까지, 즉 next가 null이 될 때까지 반복한다.  
*time complexity*: `O(n)`  
*space complexity*: `O(1)`  

2. 재귀적인 방식은 Solution을 참고하였다. 노드의 위치를 움직인다는 느낌이 아니라, 모든 링크의 방향을 반대로 
바꾼다는 느낌으로 생각하면 이해하는 데 도움이 된다.  
원래 노드들이 자신의 오른쪽 노드를 next로 갖고 있었다면, 맨 마지막 노드부터 하나씩 그 방향을 왼쪽으로 바꿔주는 것이다. 
자신의 오른쪽에 있던 노드의 next를 자기 자신으로 바꾸어 화살표 방향을 전환한다.  
재귀 흐름의 가장 안쪽(head.next가 null인 것)에서 자기 자신(head)을 리턴하면, 그 바깥 재귀함수에서는 그것을 `p`로 
받는다. 그 p는 모든 재귀함수 호출이 끝났을 때 최종적으로 리턴되는 레퍼런스가 되는데, 그로 인해 리스트 전체를 reverse시킨 결과가 된다.  
*time complexity*: `O(n)`  
*space complexity*: `O(n)` (재귀호출로 인해 stack에 메소드가 쌓인다. n은 리스트의 길이) 