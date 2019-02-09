Problem
-------------
https://leetcode.com/problems/binary-tree-inorder-traversal/  

Given a binary tree, return the inorder traversal of its nodes' values.  

**Example:**  

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
```  

**Follow up:** Recursive solution is trivial, could you do it iteratively?
  
  
My Idea & Solution
-------------

1. Recursive  
Binary Tree Preorder Traversal 문제와 거의 똑같다. list에 `val`을 넣어주는 시점만 다를 뿐이다. 

2. Iterative  
이 문제도 마찬가지로 stack 개념을 사용하며, leetcode의 solution을 참고했다.  
Inorder이므로, Left - T - Right 순서대로 list에 넣어야 한다. 먼저 `root`부터 시작해 
null이 나올 때까지 계속 left child를 참조하면서 순서대로 stack에 넣는다. null을 만나면 
자기 자신의 `val`을 list에 넣고, right child를 참조하도록 한 뒤 다시 반복문을 시작한다.  
즉, 반복문을 다시 시작할 때마다 해당 참조변수부터 시작해 가능한 모든 left child들을 방문하면서 
stack에 넣고, null을 만나면 자신의 `val`을 넣고 right로 이동, 다시 처음부터 시작...&nbsp; 이런 
방식이다. 만약 right로 갔는데 null이 나오면 stack에서 pop해서 꺼내 쓴다. pop하면 트리의 
레벨이 낮아지는(트리의 위쪽) 것이다.