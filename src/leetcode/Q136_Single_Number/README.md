Problem
-------------
https://leetcode.com/problems/single-number/

Given a **non-empty** array of integers, every element appears twice except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Example 1:**

```
Input: [2,2,1]
Output: 1
```

**Example 2:**

```
Input: [4,1,2,1,2]
Output: 4
```


My Idea & Solution
-------------
크게 3가지 방법이 가능하다. 아이디어가 원초적이고 성능이 좋지 않은 것부터 정리하면 다음과 같다.  

1. Map  
배열 각 요소를 key로 하고, 배열에서 등장하는 횟수를 value로 갖는 HashMap을 만든다. 배열 모든 요소에 대해 순회를 마치고, 
value가 1인 map 요소(배열에서 1번 등장한 요소)의 key를 리턴한다.
2. Set  
Map과 거의 유사한 방법이지만, 한 요소가 최대 2번까지만 나타난다는 이 문제의 특성을 고려하면 map은 다소 비효율적이다.  
Set을 만들고, 없는 요소라면 set에 담고 이미 있다면 set에서 제거한다. 어차피 3번 이상 등장하는 요소는 없기 때문이다. 
이렇게 하면 딱 1개만 있는 요소만 결과적으로 set에 남게 되고, 그 수를 리턴하면 된다.
3. XOR 연산  
Set을 활용하는 것은 꽤 괜찮은 방법이지만, 추가적인 메모리가 필요하다. 비트 연산을 활용하면 시간 복잡도 측면에서도 우수하고 
메모리 소모도 적은 알고리즘을 구현할 수 있다.  
코드에 나타난 비트 연산이 가능한 이유는, 비트 연산은 **교환 법칙**과 **결합 법칙**이 성립하기 때문이다.  
```
a⊕0 = a
a⊕a = 0
a⊕b⊕a = (a⊕a)⊕b = 0⊕b=b
```
위의 식이 성립한다. 즉 배열에서 2번 등장한 요소를 XOR하면 그 수는 0이 되고, 어떤 수와 0을 XOR 연산하면 그대로 자기 자신이므로, 
결과는 곧 배열에 1개만 있는 요소가 된다. 연산의 순서는 상관이 없다.

**Further Thoughts:**
"모든 요소가 **짝수 번** 나타나고, 딱 하나의 요소만 **홀수 번** 나타난다고 했을 때, 그 하나의 요소를 찾아라" 라는 문제로 바꾼다면, 
XOR 연산이 제대로 작동할까? 이유는 무엇일까?  
=> 가능할 것 같다. 짝수 번 나타나는 수는 결국 0이 될 것이고, 홀수 번이 만약 3번 이상을 뜻한다면, 직전 짝수 번째까지는 0이 되었다가 
마지막 번째에서 결국 자기 자신이 될 것이다. 물론 1번 나타나는 경우에도 해당될 것이다. 
