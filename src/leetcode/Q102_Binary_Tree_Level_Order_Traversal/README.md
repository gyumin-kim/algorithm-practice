Problem
-------------
https://leetcode.com/problems/binary-tree-level-order-traversal/  

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree `[3,9,20,null,null,15,7]`,  

```
    3
   / \
  9  20
    /  \
   15   7
```  

return its level order traversal as:  
```
[
  [3],
  [9,20],
  [15,7]
]
```   

  
My Idea & Solution
-------------

tree의 level 0부터 시작해 각 level에 해당하는 노드들의 `val`을 List에 담아 리턴한다.  
while문에서 각 level을 시작할 때마다 새로운 List<Integer>를 만든다. `size`는 현재 level의 노드의 개수를 의미한다. 
현재 level에 대한 loop이 끝나면 List<Integer>를 List<List<Integer>>에 추가한다.  
이를 queue가 비어있을 때까지 반복한다.  

*time complexity*: `O(n)`