package leetcode.Q747_Largest_Number_At_Least_Twice_of_Others;

import java.util.Arrays;

public class Solution {

  /**
   * 내장 메소드를 사용하여 배열을 copy하고 정렬한 다음, 가장 큰 두 개의 수를 판별하여 조건에 맞게 검사한다.
   * time complexity: O(n log(n))
   * Leetcode runtime: 12ms
   */
  public int dominantIndex(int[] nums) {
    int length = nums.length;
    if (length < 2) return 0;

    int[] tmp = Arrays.copyOf(nums, length);
    Arrays.sort(tmp);
    if (tmp[length-1] < 2*tmp[length-2])  return -1;

    for (int i = 0; i < length; i++) {
      if (nums[i] == tmp[length-1]) return i;
    }

    return -1;
  }

  /**
   * 라이브러리를 사용하지 않고 해결.
   * time complexity: O(n), nums의 길이
   * Leetcode runtime: 7ms
   */
  public int dominantIndex2(int[] nums) {
    int length = nums.length;
    if (length < 2) return 0;

    int largest = -1;
    int prev = largest;
    int index = -1;

    for (int i = 0; i < length; i++) {
      if (nums[i] > largest) {
        prev = largest;
        largest = nums[i];
        index = i;
      }
      if (nums[i] > prev && nums[i] < largest) {
        prev = nums[i];
      }
    }

    if (largest < 2*prev)   return -1;
    return index;
  }

  /**
   * 두번째 풀이와 큰 틀에서는 비슷한 풀이이다. 성능은 거의 같다.
   * time complexity: O(n), nums의 길이
   * Space Complexity: O(1), the space used by our int variables.
   * Leetcode runtime: 7ms
   */
  public int dominantIndexSolution(int[] nums) {
    int maxIndex = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] > nums[maxIndex])
        maxIndex = i;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
        return -1;
    }
    return maxIndex;
  }
}
