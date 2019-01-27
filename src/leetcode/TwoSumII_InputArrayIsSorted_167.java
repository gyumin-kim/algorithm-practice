package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 */
public class TwoSumII_InputArrayIsSorted_167 {

  /**
   * TwoSum(https://leetcode.com/problems/two-sum/) 문제에서 풀었던 것처럼,
   * numbers의 모든 요소를 map에 다 넣고 시작하지 않고,
   * (target - i번째 수)에 해당하는 key가 map에 있으면 해당 두 수의 배열 인덱스들로 배열을 만들어 바로 리턴하고,
   * 해당 key가 map에 없으면 그 때 map에 추가한다.
   */
  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < numbers.length; i++) {
      int number = numbers[i];
      if (map.containsKey(target - number)) {
        return new int[] { map.get(target - number) + 1, i + 1 };
      }
      map.put(number, i);
    }

    throw new IllegalArgumentException("No such sums");
  }
}
