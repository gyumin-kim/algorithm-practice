Problem
-------------
https://leetcode.com/problems/validate-binary-search-tree/  

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys **less than** the node's key.
- The right subtree of a node contains only nodes with keys **greater than** the node's key.
- Both the left and right subtrees must also be binary search trees.

**Example 1:**
```
Input:
    2
   / \
  1   3
Output: true
```  

**Example 2:**
```
    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
```

**Example 3:**
```
   10
   / \
  5   15
     /  \
    6   20
```

  
My Idea & Solution
-------------

고민을 잠깐 해보다가 해결방법이 잘 떠오르지 않아 
[Check if Binary Tree is Binary Search Tree](https://www.youtube.com/watch?v=MILxfAbIhrE) 영상을 보고 
아이디어를 배웠다.  

먼저, 단순히 특정 노드의 좌측에는 더 작은 수, 우측에는 더 큰 수가 오는 것만 생각하면, Example 3의 경우 
`15` 기준으로 `6`과 `20`은 문제가 없지만 `10`를 기준으로 바라보면 `6`은 `10`보다 작으므로 이는 BST가 아니다. 즉 이 방법으로는 
문제를 풀 수 없다.  

해결책은 각 노드가 가질 수 있는 `val`의 범위(range)를 구하고 범위 바깥에 있는 수를 갖고 있는 경우 `false`를 리턴하는 것이다. 
맨 처음 `util` 메소드를 호출할 때 2,3번째 인자에 정수의 최소값과 최대값을 넣는다. 그리고 현재 가리키는 node의 `val`이 해당 범위 
바깥에 위치한다면 `false`를 리턴하고, 범위 내에 있다면 왼쪽 자식과 오른쪽 자식에 대해 재귀적으로 호출하고 두 값을 `&&` 연산한 결과를 
리턴한다. 즉 자식들 중에서 한 번이라도 `false`가 나온다면 전체 트리가 BST가 아니므로 메소드 전체에서 `false`를 리턴하게 된다.  

그런데 기존 메소드는 최초에 `isValidBST`에서 `util`을 호출할 때 최소값에 `Integer.MIN_VALUE` 혹은 
최대값에 `Integer.MAX_VALUE`를 넣을 경우 제대로 된 결과가 나오지 않는 문제가 있다. `isValidBST2`와 `util2`는 
이를 해결한 것이다. `util2`에 2,3번째 인자에 `null`을 넣을 수 있도록 `Integer`로 변경하고, `util2` 내부에서 
`null`을 처리하는 부분을 추가해주면 된다.  

마지막 방법은 `val`이 가장 작은(가장 왼쪽 아래쪽 node) node부터 In-order로 순회하면서, 
직전 node의 `val`보다 크지 않은 경우 순회를 멈추고 `false`를 리턴하는 방법이다. Top-down 방법과 시간복잡도는 동일하다.