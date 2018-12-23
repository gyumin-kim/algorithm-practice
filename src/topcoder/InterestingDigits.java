package topcoder;

import java.util.Stack;

public class InterestingDigits {

  /**
   * n: 2 ~ (base-1) n, n*1, n*2, ..., 마지막 수(max; (base-1) * 10^2 + (base-1) * 10^1 + (base-1))보다 작은
   * n의 배수 => 위의 각 수를 base진수로 변환 --> 변환된 수의 각 자릿수의 합을 구함 --> 그 합이 n의 배수인지 판별 => n진수가 아니면 break하고 다음
   * n으로 진행
   */
  private static int[] digits(int base) {
    Stack<Integer> stack = new Stack<>();
    int max = (int) Math.pow(10, 2) * (base - 1) + (int) Math.pow(10, 1) * (base - 1) + (base - 1);
    for (int n = 2; n < base; n++) {
      int m = n;
      int mul = 1;
      boolean flag = true;
      while (m < max) {
        // m을 base진수로 변환
        String str = Integer.toString(m, base);
        // 변환된 수의 각 자릿수 합을 구함
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
          sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        // 구한 합이 n의 배수인지 판별, false면 flag를 false로, break
        if (sum % n != 0) {
          flag = false;
          break;
        }
        m = n * ++mul;
      }
      if (flag) {
        stack.push(n);
      }
    }

    int length = stack.size();
    int[] answer = new int[length];
    for (int i = 0; i < length; i++) {
      answer[i] = stack.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] answer = digits(26);
    for (int num : answer) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
