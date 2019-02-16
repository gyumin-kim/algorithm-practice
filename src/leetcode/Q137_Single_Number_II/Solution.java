package leetcode.Q137_Single_Number_II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gyumin Kim
 * @since 2019-02-16
 */
public class Solution {

  /**
   * Map
   */
  public int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (int num : map.keySet()) {
      if (map.get(num) == 1) {
        return num;
      }
    }

    return -1;
  }

  /**
   * 비트 연산 활용
   * Integer.parseInt()에서 java.lang.NumberFormatException 발생
   */
  public int singleNumber2(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      int binary = Integer.parseInt(Integer.toBinaryString(num));
      sum += binary;
    }

    int length = String.valueOf(sum).length();
    int mul = 1;
    int result = 0;

    for (int i = 0; i < length; i++) {
      int digit = sum % 10;
      result += ((digit % 3) * mul);
      mul *= 10;
      sum /= 10;
    }
    return Integer.parseInt(String.valueOf(result),2);
  }

  /**
   * 비트 연산 활용
   * 32-bit 정수
   */
  public int singleNumber3(int[] nums) {
    int[] count = new int[32];
    int result = 0;
    int n = nums.length;

    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < n; j++) {
        if (((nums[i] >> j) & 1) == 1)
          count[i]++;
      }
      result |= (count[i] % 3) << i;
    }

    return result;
  }
}
