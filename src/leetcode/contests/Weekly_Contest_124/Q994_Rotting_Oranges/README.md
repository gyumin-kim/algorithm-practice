Problem
-------------
https://leetcode.com/problems/rotting-oranges/  

In a given grid, each cell can have one of three values:

- the value 0 representing an empty cell;
- the value 1 representing a fresh orange;
- the value 2 representing a rotten orange. 

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return `-1` instead.  

**Example 1:**  

![oranges](https://assets.leetcode.com/uploads/2019/02/16/oranges.png)
```
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
```  

**Example 2:**
```
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
```

**Example 3:**
```
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
```

**Note:**
1. `1 <= grid.length <= 10`
2. `1 <= grid[0].length <= 10`
3. `grid[i][j]` is only `0`, `1`, or `2`.


  
My Idea & Solution
-------------
좌표를 나타내는 `Point` class를 만들고 `orangesRotting`을 구현하였다. 일종의 Brute-force로 
푸는 방법인 것 같고, 답안(`orangesRotting2`)은 Queue를 활용한 BFS 풀이법이다.  

답안에서 배울 수 있었던 점은 다음과 같다.
1. (r,c) 좌표를 의미하는 클래스를 따로 만들 필요 없이, 상하좌우를 뜻하는 길이 4 짜리 배열을 
2개 만드는 것이 편하다. 두 배열의 `i`번째 요소를 각 좌표에 더해주면, 상하좌우 이동하는 것으로 
간주할 수 있다. 탑코더에서도 종종 보였던 테크닉이다.
2. `code`라는 변수를 만들어서 사용하고 있는데, 풀어서 쓰면 `(0,0)`부터 오른쪽으로, 아래 방향으로 
2차원 배열을 순회한다고 했을 때 해당 요소가 몇번째인지를 의미하는 수다. queue에 `code`를 넣고, 
`code`로부터 (r,c) 좌표를 계산해서 구한다. **매번 (r,c) 좌표를 따로따로 저장해서 갖고다니는 것 보다 
다루기가 편하다.**
3. 전체 흐름은 이렇다. 맨 처음 `2`가 들어있는 곳의 `code`(좌표)들을 queue에 넣은 다음, 
queue가 빌 때까지 다음 절차를 계속 반복한다.  
Map인 `depth`의 key에는 해당 좌표, value에는 0을 넣는다. 
queue에서 하나씩 `code`를 빼고, 해당 좌표의 상하좌우에 `2`가 있는지 확인하고, 
있으면 그 좌표의 `code`를 queue에 넣는다(=`ncode`). Map에는 이전 좌표를 key로 가졌던 요소의 
value에 1을 더한 값을 넣고, 그 값을 `answer`에 계속 반영한다. 최종적으로 반영된 `answer`가 
리턴값이다.  
만약 전체 `grid[][]` 중에 1인 값이 있다면 문제 요구조건을 만족시킬 수 없는 것이므로 `-1`을 리턴한다.

두 방법의 성능차이는 거의 나지 않지만 코드의 간결함이나 가독성 측면에서는 BFS를 활용하는 것이 훨씬 
깔끔하고 실수할 가능성이 적어 보인다. 










