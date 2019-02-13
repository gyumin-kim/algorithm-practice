Problem
-------------
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

**Example:**

```
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
```  

Return true.  


My Idea & Solution
-------------
**Divide and Conquer(분할 정복)**, **Binary Search Tree(이진 검색 트리)** 개념이 결합된 문제다.  

일단 Binary search를 떠올릴 수 있는 것은 `nums` 배열이 모든 요소가 정렬되어 있는 배열이기 때문이다. 
그리고 Balanced BST를 만들어야 하는데, 트리(sub-tree 포함)의 root는 해당 범위의 배열의 가운데 요소를 
`val`로 갖도록 하면 된다.  

즉, `makeBST`의 첫 단계에서는 전체 트리의 root node부터 만드는데, 이 때의 root node의 `val`은 
배열 `nums`의 전체 범위 중에서 가운데 있는 요소가 된다. 이렇게 전체 트리의 root node를 만든 것이다.  
그리고 Balanced BST를 만드는 것이 목표이므로, 방금 만든 root node의 좌측・우측 node를 만들어 연결시켜줘야 한다. 
이 때 배열 `nums`가 정렬된 배열이라는 특성에 주목한다.  

root node를 만들 때 사용했던 배열 요소를 기준으로, 좌측과 우측 요소들로 2개의 배열이 생겼다고 생각한다. 
root node의 좌측・우측 sub-tree를 만들 때는 이 2개의 배열을 각각 사용한다. `val`을 할당하는 방법은? 
root node를 만들 때와 동일하다. 동일한 방식으로 배열의 모든 요소를 사용해 Balanced BST를 완성하는데, 
배열의 범위를 계속 절반씩 쪼개면서 진행하므로 Divide & Conquer라고 할 수 있다.  

- *time complexity*: O(N) (배열 요소의 개수만큼 진행)  
- *stack space*: O(logN)
