Problem
-------------
https://leetcode.com/problems/cousins-in-binary-tree/  

In a binary tree, the root node is at depth `0`, and children of each depth `k` node are at depth `k+1`.

Two nodes of a binary tree are cousins if they have the same depth, but have **different parents**.

We are given the `root` of a binary tree with unique values, and the values `x` and `y` of two different nodes in the tree.

Return `true` if and only if the nodes corresponding to the values `x` and `y` are cousins.  

**Example 1:**  

![tree1](https://assets.leetcode.com/uploads/2019/02/12/q1248-01.png)
```
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
```  

**Example 2:**

![tree2](https://assets.leetcode.com/uploads/2019/02/12/q1248-02.png)
```
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
```

**Example 3:**

![tree3](https://assets.leetcode.com/uploads/2019/02/13/q1248-03.png)
```
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
```

**Note:**
1. The number of nodes in the tree will be between `2` and `100`.
2. Each node has a unique integer value from `1` to `100`.


  
My Idea & Solution
-------------
Binary tree 문제를 몇 개 풀어본 게 있어서, 이 문제도 할 수 있을 거라고 생각했는데 결국 실전에서 
성공하지 못했다. leetcode 풀이를 참고하였다.  
기본적인 아이디어는 모든 node 각각의 depth와 parent node를 기록한 뒤, `isCousins`의 
매개변수로 들어온 두 수 `x`와 `y`를 `val`로 갖는 두 node가 depth가 같고 parent가 다른지 여부를 
검사하는 것이다. 만약 그렇다면 cousin이 맞으므로 `true`를 리턴한다.  
따라서 depth와 parent라는 Map을 만들고, root node부터 DFS를 통해(Top-down) 각 node의 
depth와 parent를 기록한다.