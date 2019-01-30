package leetcode.Q724_Find_Pivot_Index;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
 */
public class Solution {

  /**
   * 가운데 index부터 시작해서 좌우 합에 따라 어느 방향으로 가야할지 매번 검사하는 방식을 처음에 시도했으나,
   * 정답이 되는 곳의 요소가 0이고 그 부근에 0이 또 있을 경우 가장 앞선 위치에 있는 0을 리턴해야 하는데
   * 그러한 경우 통과할 수 없었다.
   *
   * 결국 맨 앞에서부터 index 하나씩 증가시키면서 매번 좌우 합을 구하고 검사하는 방식으로 다음과 같이 구현하였다.
   * 한 index마다 좌우 합을 매번 반복하면 성능이 좋지 않지만,
   * index를 늘릴 때마다 좌측 합에서는 그 다음 요소를 더해주고, 우측 합에서는 그 합을 이루는 맨 앞 요소를 빼주면
   * 연산 횟수를 줄일 수 있다.
   */
  public int pivotIndex(int[] nums) {
    int length = nums.length;
    if (length < 3) {
      return -1;
    }

    int leftSum = 0;
    int rightSum = 0;
    for (int i = 1; i < length; i++) {
      rightSum += nums[i];
    }
    if (leftSum == rightSum) {
      return 0;
    }

    for (int i = 1; i < length; i++) {
      leftSum += nums[i - 1];
      rightSum -= nums[i];

      if (leftSum == rightSum) {
        return i;
      }
    }

    return -1;
  }

  /**
   * 전체를 다 더한 뒤, 왼쪽에서부터 합을 쌓아가면서 기존 합에서 왼쪽 합을 빼서 비교하는 방식.
   * leetcode 제출 결과 runtime은 위의 풀이와 거의 차이 없다.
   */
  public int pivotIndexSolution(int[] nums) {
    int sum = 0;
    int leftsum = 0;

    for (int x : nums)
      sum += x;

    for (int i = 0; i < nums.length; ++i) {
      if (leftsum == sum - leftsum - nums[i]) return i;
      leftsum += nums[i];
    }

    return -1;
  }
}
