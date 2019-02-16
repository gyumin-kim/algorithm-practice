Problem
-------------
https://leetcode.com/problems/single-number-ii/

Given a **non-empty** array of integers, every element appears three times except for one, 
which appears exactly once. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Example 1:**

```
Input: [2,2,3,2]
Output: 3
```

**Example 2:**

```
Input: [0,1,0,1,0,1,99]
Output: 99
```


My Idea & Solution
-------------
- Map  
'Single number' 문제에서와 같이 이 문제에서도 Map을 사용하면 문제가 쉽게 풀리기는 한다. 단 '추가적인 메모리를 사용하지 않고 
구현하라'는 문제의 조건은 만족하지 못한다. 결국은 비트 조작을 이용하는 것이 문제의 의도라고 판단된다.  
- Bit manipulation(1)  
`singleNumber2`의 경우, `Integer.parseInt()`에서 에러가 발생한다. 만약 `Integer.parseInt()`에 
"11111111111111111111111111111001"(32자리)이 매개변수로 들어간다면, 이 수가 signed인지 unsigned인지 결정되어 있어야 할 것이다. 
즉 맨 앞자리 1을 sign bit으로 처리해 음수로 인식할 것인지, 아니면 전체를 양수로 볼 것인지 결정해야 한다는 것이다.  
Java 문법상으로는 앞에 '-'를 써주지 않으면 양수인 것으로 판단하되, 단 32-bit signed integer의 최대값까지만 매개변수로 가능한 것으로 추측된다. 
"11111111111111111111111111111001"의 경우는 그 범위를 초과하므로, `java.lang.NumberFormatException` 에러가 발생한다.  
- Bit manipulation(2)  
오로지 비트 연산만 사용하는 방법이다. 정수는 32비트라고 가정한다. `singleNumber3`에 구현하였다.  
`nums[]`에 들어있는 모든 수들의 이진수에 대해, `i`번째 수들을 모두 더한 뒤 3으로 나눈 나머지를 그 자릿수로 대체한다. 예를 들면,
```
[6, 3, 3, 3, 2, 2, 2]

  110
   11
   11
   11
   10
   10
 + 10
------
  173
```
위와 같을 때, 각 자리수를 3으로 나눈 나머지로 바꾸면, `110`이 된다.   
그런데 이 나머지는 무조건 0 아니면 1 밖에 없을 것이다. 왜냐하면 문제에서 각 수는 1번 혹은 3번만 등장하며 1번 등장하는 수가 딱 1개 
있다고 했으므로, 각 자리수의 합(binary)은 3의 배수이거나 3의 배수보다 1이 큰 수다. 그렇다면 결국은 3번 등장한 수는 나머지 연산을 
거치면 최종적으로는 없는 것과 마찬가지가 될 것이고, 딱 1번 등장한 수에 해당하는 이진수가 결과로 나타난다.
- Bit manipulation(3)  
마지막으로 위의 풀이를 조금 더 개선한 Optimal solution이 있는데, 코드를 봐도 이해가 가지 않아 일단 여기까지만. 

