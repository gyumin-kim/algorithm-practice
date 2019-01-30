package leetcode.Q202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

/**
 * 이 문제에서 왜 HashSet을 쓰는가? 처음에는 위 질문에 대한 답을 찾지 못했다. 결론은, 각 자릿수의 제곱수를 더한 합이 1이 아니면 계속 반복되는데 이 반복을 끝낼
 * 방법이 무언가 있어야 한다. 그 방법은 계속 연산을 진행하다 보면 이전에 나왔던 수가 다시 나올 것이고, 그렇다면 더 이상의 반복은 의미가 없다. 따라서 이전에 나왔던 수를
 * Set에 담아 놓고, 반복문을 시작할 때마다 set.add()를 통해 존재 여부를 판단한 뒤 반복을 진행한다.
 */
public class Solution {

  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();

    // 이미 set에 있는 수가 나왔다면 무한 loop이므로 중단
    while (set.add(n)) {
      int sum = 0;
      int tmp;
      while (n > 0) {
        tmp = n % 10;
        sum += tmp * tmp;
        n /= 10;
      }

      if (sum == 1) {
        return true;
      }
      n = sum;
    }

    return false;
  }
}