Problem
-------------
https://leetcode.com/problems/binary-tree-preorder-traversal/  

Given a binary tree, return the preorder traversal of its nodes' values.  

**Example:**  

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
```  

**Follow up:** Recursive solution is trivial, could you do it iteratively?
  
  
My Idea & Solution
-------------

1. Recursive  
재귀적으로 구현한 방법이며, 로직이 간단하고 직관적이다.    
**68 / 68** test cases passed.  
Status: Accepted  
Runtime: **0 ms**  
Memory Usage: **25.3 MB**  

2. Iterative  
재귀 메소드를 사용하지 않고, Stack 자료구조를 응용해 반복적으로 해결하는 방법이다.   
Youtube [Iterative Preorder Traversal of Binary Tree](https://www.youtube.com/watch?v=elQcrJrfObg) 영상을 참고하였다.  
**68 / 68** test cases passed.  
Status: Accepted  
Runtime: **1 ms**  
Memory Usage: **20.1 MB**  

반복적인 방법이 메모리를 덜 쓰기는 하지만 전반적으로 두 방법 모두 큰 차이는 없다.