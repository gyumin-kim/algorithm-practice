package leetcode.Q066_Plus_One;

import java.util.Arrays;

public class Solution {

  /**
   * 처음에는 배열 각 요소를 int로 변환하려고 했으나, 변환된 정수가 매우 큰 경우 int, long 범위 내에서 처리가 불가능하다.
   * 배열 마지막 요소(1의 자리)부터 탐색하면서 9이면 0으로 바꾼다.
   */
  public static int[] plusOne(int[] digits) {
    int length = digits.length;
    int i = length-1;

    if (digits[i] != 9)
      digits[i] = digits[i] + 1;
    else {
      while (i >= 0 && digits[i] == 9) {
        digits[i] = 0;
        i--;
      }
      if (i >= 0)
        digits[i]++;
      else {  // 자릿수가 늘어나는 경우 (i가 0보다 작은 상태)
        int[] longer = new int[length+1];
        longer[0] = 1;
        System.arraycopy(digits, 0, longer, 1, length);
        return longer;
      }
    }

    return digits;
  }

  public static void main(String[] args) {
    int[] digits = { 9,8,7,6,5,4,3,2,1,0 };
    System.out.println(Arrays.toString(plusOne(digits)));
  }
}
