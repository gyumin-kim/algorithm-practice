Problem
-------------
https://leetcode.com/problems/minimum-depth-of-binary-tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

**Example:**

Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```  

return its minimum depth = 2.  



My Idea & Solution
-------------

1. Depth-first traversal  
유사한 문제인 Maximum Depth of Binary Tree와 비슷한 방식으로 풀되, 왼쪽 자식들의 depth와 오른쪽 자식들의 depth의 
**'최소값'** 에 1을 더하는 것으로 수정하였다. 최대값이 아니라 최소값인 점이 다르다.  
그런데 root node의 어느 한 쪽 자식이 `null`인 경우, 즉 예를 들어 root node의 `val`이 1이고 왼쪽 자식 node의 `val`이 2, 
오른쪽 자식 node는 `null`이라고 가정했을 때, 왼쪽과 오른쪽 depth는 각각 1, 0으로 최소값은 0이고 거기에 1을 더해 최종적으로 
리턴되는 값은 1이 된다. 트리 전체의 depth는 2이므로 이는 올바른 값이 아니다.  
`minDepth`에서는 현재 가리키는 node가 `null`이면 0을 리턴하는데, 왼쪽과 오른쪽 depth의 '최소값'에 1을 더하면서 올라오므로 
어느 한쪽이 `null`이면 위로 리턴되는 값은 무조건 1이 되어버린다. 따라서 어느 한쪽만 `null`이면 그 반대쪽 node의 
minimum depth에 1을 더한 값을 리턴하는 방식으로 수정해주면 된다.  

2. Breadth-first traversal  
DFS 방식의 문제점은 만약 트리가 매우 불균형한 트리, 즉 예를 들어 왼쪽・오른쪽 순서로 재귀호출하는데 
오른쪽에 depth가 매우 작은 sub-tree가 있는데 왼쪽에 depth가 큰 sub-tree가 있을 경우, 
불필요한 연산을 계속 수행한다는 점이다. 따라서 이러한 경우에 대비하기 위해서는 DFS보다는 BFS
(= In-order traversal)가 좀 더 적절하다고 볼 수도 있다.  
먼저 queue에 root node를 넣고 시작한다. 각 node의 좌우 자식을 queue에 매 번 넣고, 각 level이 
끝날 때마다 `depth`를 1 증가시킨다. 그리고 `rightMost`라는 변수를 만들고(초기값은 `root`), 
직전 level에서 `rightMost`에 도달했을 때 해당 node의 `node.right`를 `rightMost`에 넣어 
놓는다. 각 level의 끝인지 여부는 현재 node와 `rightMost`가 같은지 검사해서 알아낸다. 
이를 queue가 빌 때까지 반복하고, 반복이 끝나면 `depth`를 리턴한다.  
위에 적었던 바와 같이, 이 방법은 매우 불균형한 트리인 경우에 DFS보다 훨씬 적절하다.
