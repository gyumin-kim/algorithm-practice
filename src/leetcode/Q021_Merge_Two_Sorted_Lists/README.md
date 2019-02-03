Problem
-------------
https://leetcode.com/problems/merge-two-sorted-lists  

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.  

**Example:**  

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```  
  
  
My Idea & Solution
-------------

이 문제는 dummy node를 사용한다는 점이 눈여겨볼 것들 중 하나인 것 같다. dummy란, 주로 테스트 용도로 쓰이는 
가상의 무언가를 뜻하는 말인데, 여기서도 가상의 node로서 역할을 수행하며 실제 메소드의 리턴값은 dummy의 next가 된다. 
문제를 풀 때 가정하는 실제 node들보다 하나 앞선 위치에 있다고 보면 된다.  

처음에는 dummy와 `p`(pointer 역할; 계속 앞으로 움직인다)가 같은 곳을 가리키도록 하고, `l1`과 `l2`의
`val`을 각각 비교하면서 진행한다. `l1`의 `val`이 더 작으면, `p`의 `next`는 현재 `l1`이 되고, `l1`을 하나 뒤로 진행시킨다.
그 반대도 마찬가지 방식이다. 당연히 하나의 node를 비교할 때마다 `p`도 뒤로 진행되어야 한다.  

`l1`과 `l2` 중 어느 하나가 끝까지 진행됐다면, 다른쪽 ListNode를 `p`의 `next`에 붙여주면 된다.   

주의할 점은 리턴값인데, 처음 시작할 때 `p`가 `dummy`를 가리키도록 해놓고 `p.next`, `p.next`, ...와 같이 진행했으므로, 
리턴은 `dummy.next`를 하면 된다.  
굳이 이렇게 하는 이유는, 새로운 리스트의 head를 따로 초기화할 필요가 없기 때문이다. 203번 문제(Remove Linked List Elements)의 
두번째 메소드에서도 유사한 방법을 사용했다.  

'Dummy Head'를 사용하는 비슷한 문제로는 [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/), 
[24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/), 
[23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)가 있다.