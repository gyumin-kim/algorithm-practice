package leetcode.Q001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class Solution {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    // nums: 3, 2, 4
    // target: 6
    for (int i = 0; i < nums.length; i++) {
      int number = nums[i];
      if (map.containsKey(target - number)) {
        return new int[] { map.get(target-number), i };
      }
      map.put(number, i);
      // 처음부터 nums의 모든 요소를 map에 넣으면, 위의 if문에서 자기 자신을 찾는 경우가 생긴다.
    }

    throw new IllegalArgumentException("No two sum solution");
  }
}
