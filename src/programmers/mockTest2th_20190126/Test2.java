package programmers.mockTest2th_20190126;

import java.util.Arrays;

/**
 * 길이가 l인 도로에 가로등이 여러대 놓여 있습니다. 전체 도로를 밝히기 위해 좌/우 각각 d만큼을 밝히는 전구를 사려고합니다.
 * 이때 d 값이 충분히 크다면 전체 도로를 밝게 비출 수 있지만, d 값이 작다면 일부 도로는 빛이 닿지 않습니다.
 * 도로 길이 l과 가로등의 위치 v가 주어졌을 때, 도로를 모두 밝히는 d 값 중 최솟값을 구해주세요.
 *
 * <example 1>
 * l: 15
 * v[]: 15, 5, 3, 7, 9, 14, 0
 * output: 3
 *
 * <example 2>
 * l: 5
 * v[]: 2, 5
 * output: 2
 */
public class Test2 {

  /**
   * 최초 시도
   */
  public static int solution(int l, int[] v) {
    // 가로등이 있는 곳을 true로 둔다.
    boolean[] arr = new boolean[l+1];
    for (int index : v) {
      arr[index] = true;
    }

    // 각 가로등 사이의 거리 중 최대값을 구한다.
    int maxLength = 0;
    int prevLight = 0;
    for (int i = 0; i <= l; i++) {
      if (arr[i]) {
        if (i == 0) continue;
        int length = i - prevLight;
        prevLight = i;
        maxLength = Math.max(maxLength, length);
      }
    }

    return (maxLength + 1) / 2;
  }

  /**
   * Sorting & Greedy
   * sort 먼저 하고 시작하면 훨씬 편하다.
   * boolean 배열을 따로 둘 필요 없이, 그냥 v 요소들 끼리만 계산해서 가장 먼 거리를 구해도 된다.
   */
  public static int solution2(int l, int[] v) {
    Arrays.sort(v);
    int ans = Math.max(v[0], l - v[v.length-1]);
    for (int i = 1; i < v.length; i++) {
      ans = Math.max(ans, (v[i] - v[i-1] + 1) / 2);
    }

    return ans;
  }

  /**
   * Binary Search
   */
//  public static int solution3(int l, int[] v) {

    /*
    def solution(l, v):
      n = len(v)
      answer = l
      v.sort()

      left, right = 0, l
      while(left <= right) :
          mid = (left + right) // 2

          # 맨 앞 가로등과 맨 뒤 가로등이 도로의 양 끝을 밝히는지 확인
          if v[0] - mid > 0 or v[n-1] + mid < l :
              left = mid + 1
              continue

          # 나머지 가로등으로 이분 탐색
          flag = False
          for i in range(1, n) :
              if v[i-1] + mid < v[i] - mid :
                  flag = True
                  break
          if flag :
              left = mid + 1
          else :
              answer = mid
              right = mid - 1
      return answer
     */
//  }

  public static void main(String[] args) {
    int l = 5;
    int[] v = { 2, 5 };
    System.out.println(solution2(l, v));
  }
}
