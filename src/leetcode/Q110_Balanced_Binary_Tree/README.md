Problem
-------------
https://leetcode.com/problems/balanced-binary-tree/

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

> a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

**Example 1:**

Given the following tree `[3,9,20,null,null,15,7]`:

```
    3
   / \
  9  20
    /  \
   15   7
```  

Return true.  

**Example 2:**

Given the following tree `[1,2,2,3,3,null,null,4,4]`:

```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

Return false.


My Idea & Solution
-------------
- 일단 어느 쪽의 sub-tree라도 문제의 조건(좌우 각각 sub-tree의 depth 차이가 1보다 크면 balanced 
tree가 아니다)을 만족하지 않으면 바로 `false`를 리턴하고 끝내면 되므로, DFS로 풀어야겠다고 생각했다.  
특정 node의 depth를 구하는 `maxDepth`는 이전에 'Maximum Depth of Binary Tree' 문제에서 적용한 
방식과 똑같다. 
`isBalanced`에서는 특정 node의 좌우 sub-tree의 depth 차이의 절대값이 1보다 큰지 아닌지를 
먼저 판단하고, 재귀적으로 자기 자신을 호출하되 좌우 sub-tree들에 대해 호출하고 두 결과가 
모두 `true`여야만 결과적으로 `true`가 된다.  

결론적으로 이 방식은 "**Brute force top-down recursion**"이다.  
*time complexity: `O(N^2)`*  
*stack space: `O(N)`*   

- 위 방법은 위에서 아래로 내려가면서, 매 node마다 `maxDepth`를 호출한다는 단점을 갖고 있다. 
그렇다면, 위에서 아래가 아니라 아래에서 위로, 즉 **Bottom-up** 방식이라면 이 문제가 해결될 것이다.  
Bottom-up 방향으로 각 노드의 depth를 구하면서 해당 트리가 balanced한지 알아내야 하는데, 
이를 위해 보초값(Sentinel value)으로 -1을 사용한다.  
`maxDepth2`는 호출될 때마다, 해당 node의 왼쪽 자식이 unbalanced한지(리턴값이 `-1`인지) 검사하고, 
만약 unbalanced한 것으로 나타나면 -1을 바로 리턴하고 끝내버린다.  
-1이 아니라면, 즉 balanced한 sub-tree라면 좌우 sub-tree들의 maximum depth에 1을 더한 값을 리턴해준다. 이 값을 
다음 위쪽 노드에서 다시 사용한다.   

이 방식은 "**Bottom-up recursion**"이다.  
*time complexity: `O(N)`*     
*stack space: `O(N)`*