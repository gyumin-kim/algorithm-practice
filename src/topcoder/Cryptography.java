package topcoder;

import java.util.Arrays;

public class Cryptography {

  /**
   * 이중 for문을 사용하여 일일이 구한다(전체 탐색).
   */
  private static long encrypt(int[] numbers) {
    int length = numbers.length;
    long answer = 0;
    for (int i = 0; i < length; i++) {
      long num = 1;
      for (int j = 0; j < length; j++) {
        if (j == i) {
          num *= numbers[i] + 1;
        } else {
          num *= numbers[j];
        }
      }
//      if (num > answer)
//        answer = num;
      answer = Math.max(num, answer);
    }

    return answer;
  }

  /**
   * numbers에서 원래 수들을 모두 곱한 것과, 임의의 하나의 수를 +1하고 모든 수를 곱한 것의 증가율은 (n+1) / n이다. 따라서 n이 작을수록 곱한 값이
   * 커지므로, numbers에서 가장 작은 수를 +1한 뒤 모든 수를 곱한 것이 가장 큰 값이 된다.
   */
  private static long encrypt2(int[] numbers) {
    Arrays.sort(numbers);
    numbers[0] += 1;
    long answer = 1;
    for (long number : numbers) {
      answer *= number;
    }
    return answer;
  }

  public static void main(String[] args) {
    int[] numbers = {1000, 999, 998, 997, 996, 995};
    System.out.println(encrypt2(numbers));
  }
}
