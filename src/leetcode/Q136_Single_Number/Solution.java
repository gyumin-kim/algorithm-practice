package leetcode.Q136_Single_Number;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Gyumin Kim
 * @since 2019-02-16
 */
public class Solution {

  /**
   * Map
   */
  public static int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      Integer tmp = map.get(num);
      if (tmp == null)
        map.put(num, 1);
      else
        map.put(num, tmp + 1);
    }

    for (int num : map.keySet()) {
      if (map.get(num) == 1) {
        return num;
      }
    }

    return -1;
  }

  /**
   * Set
   */
  public static int singleNumber2(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.contains(num))
        set.add(num);
      else
        set.remove(num);
    }
    return set.iterator().next();
  }

  /**
   * XOR
   */
  public static int singleNumber3(int[] nums) {
    int answer = 0;
    for (int num : nums) {
      answer ^= num;
    }
    return answer;
  }

    public static void main(String[] args) {
    int[] nums = { 1, 3, 2, 1, 3, 2, 3, 2, 1, 2, 3 };
    System.out.println(singleNumber3(nums));
  }
}
