Problem
-------------
https://leetcode.com/problems/binary-tree-postorder-traversal/  

Given a binary tree, return the postorder traversal of its nodes' values.  

**Example:**  

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
```  

**Follow up:** Recursive solution is trivial, could you do it iteratively?
  
  
My Idea & Solution
-------------

1. Recursive  
Binary Tree Preorder, Inorder Traversal 문제와 거의 똑같다. list에 `val`을 넣어주는 시점만 다를 뿐이다. 

2. Iterative  
Postorder traverse를 iterative하게 풀려면 stack 2개가 필요하다. 코드를 보면 직관적으로 
이해가 쉽게 된다. `s1`이 모두 비워질 때까지 진행하면 `s2`에 있는 TreeNode들의 `val`을 위에서부터 
list에 담아주고 리턴하면 된다.  
Leetcode에 가장 많은 표를 받은 다른 풀이는 iterative하면서도 stack을 1개만 사용하는 방법인데, 
ArrayList가 아닌 LinkedList를 사용하고 Postorder(left - right - t)의 역순을 기준으로 
(t를 만나면 바로 list에 포함, 그 다음 right, 그 다음 left, ...) 만나는 노드의 `val`을 
`addFirst`한다.  
Iterative한 위의 두 방법은 성능 상 거의 차이가 없다. 첫번째 방법이 좀 더 이해하기가 쉬운 것 같다. 