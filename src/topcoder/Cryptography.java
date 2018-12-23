package topcoder;

import java.util.Arrays;

public class Cryptography {

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
