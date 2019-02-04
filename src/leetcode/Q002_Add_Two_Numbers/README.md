Problem
-------------
https://leetcode.com/problems/add-two-numbers  

You are given two **non-empty** linked lists representing two non-negative integers. 
The digits are stored in **reverse order** and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, 
except the number 0 itself.  

**Example:**  

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```  
  
  
My Idea & Solution
-------------

두 개의 리스트가 있을 때, 각 리스트의 첫 노드부터 값을 더해 나가고, carry가 있으면(더한 수가 9를 
초과하면) 다음 노드로 넘겨 가면서 계속 더한다. 모든 수들을 더한 결과가 담긴 리스트를 리턴한다.  

문제 설명과 Example의 Explanation 부분에서 문제 이해를 잘못했다. 이로 인해 Input으로 
주어진 리스트를 다시 역순으로 돌리고 덧셈을 시작하는 등 완전히 잘못 풀고 있었다.  
문제에서 Input으로 들어온 두 리스트의 노드들은 이미 원래 수의 역순으로 담겨 있는 상태다. 
그러니 그냥 리스트의 맨 앞부터 더해 나가면 결과적으로는 원래 수(만약 리스트가 
2 -> 4 -> 3 순서라면 원래 수는 342인 것이다)들끼리 더한 것과 같다.

Input으로 들어온 리스트가 원래 덧셈을 하려는 수의 역순이므로, 만약 두 리스트의 길이가 다르다고 
해도 그냥 앞에서부터 더해 나가면 된다. 즉 4자리 수와 3자리 수를 더할 때 일의 자리부터 같이 
더해나가는 것과 같다.

그리고 이 문제에서도 'Dummy Head'를 이용하면 깔끔하게 풀 수 있으며, 자릿수가 다를 경우 
어느 한쪽(p 혹은 q)은 null인 상태일 수 있으니 조건을 적절하게 걸어줘야 NPE가 발생하지 않는다.

*time complexity*: `O(max(m, n))`  
*space complexity*: `O(max(m, n))` 