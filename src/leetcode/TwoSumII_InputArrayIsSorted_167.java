package leetcode;

import java.util.Arrays;
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

  /**
   * 위 풀이처럼 똑같이 Hash Table을 사용해도 되지만, hash는 추가적인 O(n) 공간이 필요하다는 단점이 있다.
   * 이 경우는 numbers[]가 이미 정렬되어 있으므로, 이진 탐색(binary search)을 사용할 수 있다.
   */
  public int[] twoSum2(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      int result = bSearch(numbers, target-numbers[i], i+1);
      if (result != -1) {
        return new int[] { i + 1, result + 1 };
      }
    }

    throw new IllegalArgumentException("No two sum solution");
  }

  private int bSearch(int[] A, int key, int start) {
    int L = start, R = A.length - 1;
    while (L < R) {
      int M = (L + R) / 2;
      if (A[M] < key) {
        L = M + 1;
      } else {
        R = M; }
    }
    return (L == R && A[L] == key) ? L : -1;
  }

  /**
   * 역시 배열이 정렬되어 있는 경우에 사용할 수 있는 방법이다.
   * 맨 앞과 맨 뒤의 인덱스부터 시작해 두 요소의 합을 구한 뒤,
   * 합이 target보다 작으면 앞의 인덱스를 증가, target보다 크면 뒤의 인덱스를 감소시키고 다시 합을 계산한다.
   * 합이 target과 같을 때까지 반복한다.
   * 성능이 가장 좋다.
   */
  public int[] twoSum3(int[] numbers, int target) {
    int start = 0;
    int end = numbers.length - 1;
    while (start < end) {
      int sum = numbers[start] + numbers[end];
      if (sum < target) {
        start++;
      } else if (sum > target) {
        end--;
      } else {
        return new int[] { start + 1, end + 1 };
      }
    }

    throw new IllegalArgumentException("No two sum solution");
  }
}
