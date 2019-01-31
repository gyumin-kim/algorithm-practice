Problem
-------------
https://leetcode.com/problems/remove-nth-node-from-end-of-list  

Given a linked list, remove the n-th node from the end of list and return its head.  

**Example:**  

```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```  

**Note:** 

Given n will always be valid.  

**Follow up:**  

Could you do this in one pass?  
  
  
My Idea & Solution
-------------

Leetcode 'Explore > Learn'에서 이 문제가 'Two Pointer Technique' section에 묶여 있어, 이 문제도
2개의 포인터를 적절히 이용하면 풀리지 않을까 생각했다.   

먼저 2개의 포인터(`first`, `second`)를 `head`가 가리키는 곳과 같은 곳을 가리키도록 한 다음, `first`를 n번
뒤로 보낸다.  
그런 다음에는, `first`와 `second`를 나란히 한 번씩 뒤로 보낸다. 이를 `first`가 리스트의 맨 끝에 도달할 때까지
계속 진행한다. 그리고 `second`가 가리키는 곳 다음에 있는 노드를 삭제하면 된다.   

다만 추가로 고려해야 하는 것은, `first`를 n번 뒤로 보내기 이전에 리스트의 끝에 도달해버리는 경우이다.
그런데 문제에서는 **주어진 n은 항상 유효(valid)할 것**이라고 전제가 깔려 있다. 이 말은 결국 리스트의 사이즈보다
큰 n이 입력되는 경우는 없다는 것이고, 따라서 이 경우는 무조건 첫번째 노드를 삭제하면 된다.  

*time complexity*: `O(L)` (L: length of the list)  

#### 다른 풀이
위의 풀이는 2개의 pointer를 사용하는데, 1개의 pointer만 사용할 수도 있다. 먼저 리스트를 전체 순회하여 리스트의
길이를 구하고, 이를 L이라 한다. 그러면 결국 지워야 하는 노드는 (L - n + 1)번째 노드다.  
따라서 이 방법은 전체 리스트를 2번 순회해야 한다. 정확하게 계산한다면 (2N - n)개의 노드를 방문하게 된다.  

pointer 몇 개를 사용하던 관계 없이 시간복잡도는 똑같이 `O(L)`이지만, pointer 2개를 사용하면 노드를 방문하는 횟수를 
줄일 수 있다.