Problem
-------------
https://leetcode.com/problems/remove-linked-list-elements  

Remove all elements from a linked list of integers that have value ***val***.  

**Example:**  

```
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
```  
  
  
My Idea & Solution
-------------

`removeElements`가 내가 짠 코드이다. 현재 node와 이전 node를 가리키는 2개의 pointer를 만들고, 
`val`을 비교해 pointer를 적절히 이동시켜준다. 
단, 첫번째 node를 삭제해야 하는 경우를 대비해 while문 안에서 '현재 pointer가 head와 같은 곳을 가리키고 있는지'를 
검사한다. 조건에 부합할 경우 head도 현재 pointer의 다음 node를 가리키도록 수정한다.  

`removeElements2`는 leetcode에 게시된 다른 사람의 풀이이다. 여러 개의 pointer를 활용한다는 점은 비슷하지만,
처음에 `fakeHead`라는 임시 node를 맨 앞에 두고, 그 node를 가리키는 `prev`라는 pointer를 둔다. 
즉 `prev` - `curr` pointer를 앞, 뒤로 놓고 처음부터 시작하기 위해 `fakeHead`가 필요하다.