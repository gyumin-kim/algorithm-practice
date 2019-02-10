Problem
-------------
https://leetcode.com/problems/maximum-depth-of-binary-tree/  

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Note:** A leaf is a node with no children.

**Example:**  
Given binary tree `[3,9,20,null,null,15,7]`,  

```
    3
   / \
  9  20
    /  \
   15   7
```  

return its depth = 3.  

  
My Idea & Solution
-------------

Leetcode "Learn > Binary Tree > Solve Problems Recursively"에 정리된 내용을 
읽고 도움을 받았다.  
문제에서 주어진 메소드의 매개변수는 `root` 하나뿐이었으므로, 자식 노드들에게 depth를 넘겨주는 
구조는 아니다. 따라서 bottom-up 방식으로 풀어야겠다고 생각했다.  
bottom-up이란 자식들이 depth와 관련된 값을 이미 갖고 있는 상태에서, 그 부모 node에서 값을 
구하고자 했을 때 왼쪽과 오른쪽 자식의 값 중 더 큰 값을 구하고 1을 더하면 해당 node의 depth의 
최대값이 된다는 것이다.  
이 문제를 재귀로 푸는 것이 가능한 이유는, 어떤 node의 왼쪽과 오른쪽 자식들도 각각의 트리, 즉 
sub-tree이기 때문이다.  

*time complexity*: `O(N)`. 모든 node들을 한 번씩 다 방문한다.  
*space complexity*: `O(logN)`. binary tree의 depth의 최대치는 logN이고, 스택에 
쌓이는 재귀함수의 개수도 그에 비례한다. 