package leetcode.Q189_Rotate_Array;

/**
 * https://leetcode.com/problems/rotate-array
 */
public class Solution {

  /**
   * brute-force스러운 방법
   * 한 칸씩 뒤로 이동하고 맨 뒤 요소를 맨 앞으로 놓는 작업을 k번 수행
   */
  public void rotate(int[] nums, int k) {
    int i = 0;
    while (i < k) {
      int tmp = nums[nums.length - 1];
      System.arraycopy(nums, 0, nums, 1, nums.length - 1);
      nums[0] = tmp;
      i++;
    }
  }

  /**
   * k번 이동한다면, 전체 nums를 거꾸로 뒤집은 뒤
   * ("0 ~ k-1 / k ~ 마지막" 두 개의 그룹으로 나뉜다고 보면, 이제 각 그룹 내에서의 순서만 맞춰주면 정답이 된다.)
   * 앞에서부터 k개 요소들끼리 다시 뒤집고, 그 뒤의 모든 요소들끼리 다시 뒤집으면 된다.
   */
  public static void rotate2(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length-1);
    reverse(nums, 0, k - 1);
    reverse(nums, k , nums.length-1);
  }

  public static void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int tmp = arr[end];
      arr[end] = arr[start];
      arr[start] = tmp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1 };
    int k = 1;
    rotate2(nums, k);
  }
}
