Problem
-------------
https://leetcode.com/problems/intersection-of-two-linked-lists  

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:
![example1](https://assets.leetcode.com/uploads/2018/12/13/160_statement.png)  
begin to intersect at node c1.  
  

**Example 1:**  
![example1](https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png)
```
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
```  
  
**Example 2:**  
![example2](https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png)
```
Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
```  

**Example 3:**  
![example3](https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png)
```
Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
```

**Notes:**

- If the two linked lists have no intersection at all, return null.
- The linked lists must retain their original structure after the function returns.
- You may assume there are no cycles anywhere in the entire linked structure.
- Your code should preferably run in O(n) time and use only O(1) memory.  
  
  
  

My Idea & Solution
-------------

문제를 잘못 이해한 부분이 있었다.  
원래는 교차점이 존재하면 그 교차점으로부터 각 List의 맨 마지막 노드로 갈 때까지 갈라지지 않고 계속 이어져야만 하는 것으로 
생각했으나, 문제의 의도는 그냥 교차점이 처음 발견되면 그 부분을 바로 리턴하면 되는 것이었다.

- 방문한 각 노드마다, 직전에 자기 자신을 가리킨 노드의 레퍼런스 변수를 갖고 있다가 서로 다른 변수가 2개가 들어온다면 
그 곳에서 교차(intersect)하는 것으로 판단할 수 있지 않을까? 라는 생각이 들었으나, 문제에서 되도록이면 O(1)의 메모리를
사용해야 한다는 조건에 부합하지 않는다.

- 상수 크기의 메모리를 사용하는 아이디어가 잘 떠오르지 않아서, 일단 방문한 노드들의 값을 배열에 순서대로
저장하는 방식은 어떨까 생각해보았다. 그러나 이 방법은 적합하지 않다. 만약 두 배열의 값이 특정 구간부터 같다고 해도,
그것이 두 ListNode가 특정 지점에서 교차한다는 것을 보장하지는 못할 것이다.
이 아이디어에서 비교의 기준이 되는 것은 각 노드의 값이기 때문이다. 만약 값만 같고 레퍼런스 값은 다르면 아무 의미가 없다.

1. Brute force  
ListA의 각 노드에 대해, 해당 노드가 ListB에 있는지 일일이 대조한다. ListA의 모든 노드에 대해 작업을 끝낸 뒤에도
같은 노드가 없으면 null을 리턴한다.  
*time complexity*: `O(n^2)`(혹은 `O(m*n)`) (최악의 경우 ListA와 ListB의 각 노드들을 모두 순회해야 하므로)  
*space complexity*: `O(1)`

2. Hash table  
위에 적은 첫번째 아이디어와 유사하다. ListA의 각 노드의 레퍼런스를 HashSet에 저장해 놓고, ListB의 각 노드들을 순회하면서
같은 것이 있는지 비교한다.  
*time complexity*: `O(n)` (혹은 `O(m+n)`)  
*space complexity*: `O(n)` (자료구조가 추가로 필요하므로 O(1)은 아니지만, 1번 방법에 비해 탐색에 소요되는 시간을 크게 줄일 수 있다).   

3. Two pointers  
각 List의 head를 가리키는 2개의 pointer를 놓고 하나씩 순회하되, 마지막 노드 이후에는 반대편 List부터 다시 순회하는 방식이다.  
만약 두 List에 교차점(intersection)이 존재한다면, 두 pointer는 언젠가는 만나게 될 것이고 그 곳이 바로 교차점이다.  
교차점이 없는 경우도 판별해야 하는데, 반대편 리스트로 넘어가기 전에 해당 순서의 마지막 노드를 따로 저장해 놓고, 각자의 마지막 노드가 다른
노드인 경우 교차점이 없는 것으로 판단해 null을 리턴한다. 
즉 각자의 마지막 노드가 다르다는 것은 두 List가 경로를 전혀 공유하지 않는다는 뜻이며, 따라서 교차점이 없다.  
*time complexity*: `O(n)` (혹은 `O(m+n)`)  
*space complexity*: `O(1)`  

