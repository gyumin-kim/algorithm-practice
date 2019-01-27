package programmers.mockTest2th_20190126;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 빙고 게임 보드에 적힌 숫자가 담겨있는 배열 board, 게임 보드에서 순서대로 지운 숫자가 들어있는 배열 nums가 매개변수로 주어질 때,
 * board에서 nums에 들어있는 숫자를 모두 지우면 몇 개의 빙고가 만들어지는지 return하도록 solution 함수를 완성해주세요.
 */
public class Test3 {

  /**
   * 일정상 실제 풀지는 못하고 대략적인 아이디어만 적어 놓았다.
   * HashMap이 들어있는 2차원 배열을 만들면 될까?
   */
  public static int solution(int[][] board, int[] nums) {
    int answer = 0;
    // key가 board에 담긴 각 숫자인 HashMap을 만든다.
    Map<Integer, Boolean> map = new HashMap<>();

    // nums에 담긴 수를 key로 갖는 요소는 value를 true로 바꾼다.

    // 이 HashMap을 board와 크기가 같은 2차원 배열에 담는다.
    Object[][] arr = new Object[5][5];

    // HashMap에서 value가 true인 요소의 배열 인덱스를 갖고 가로, 세로, 대각선을 판단해 몇 개의 빙고가 만들어지는지 판단한다.

    return answer;
  }

  /**
   * 가로선, 세로선, 대각선(\방향, /방향; 2개)을 의미하는 정수 배열과 각 정수를 선언해 놓고,
   * nums에 근거하여 마크한 뒤 board의 한 변의 길이와 같은지를 비교하여 빙고의 개수를 계산한다.
   * 만약 board가 4x4 배열이라면, 가로선 하나 당 길이가 4이므로 horizontal 배열의 길이도 4가 되며,
   * board에서 0번째 행의 요소들 중 nums에 포함된 요소의 개수가 n개라면, horizontal[0]이 n이 된다.
   */
  public static int solution2(int[][] board, int[] nums) {
    int n = board.length;
    int[] horizontal = new int[n];
    int[] vertical = new int[n];
    int left_upward_diag = 0;
    int right_upward_diag = 0;

    // 탐색을 위해 HashSet 사용 (Hash: 탐색에 O(1) 소요)
    // board가 아니라 nums를 HashSet에 넣는다.
    Set<Integer> set = new HashSet<>();
    for (Integer t : nums)
      set.add(t);

    // board에 있는 nums의 원소 찾아 마크
    for (int p = 0; p < n; p++) {
      for (int q = 0; q < n; q++) {
        if (set.contains(board[p][q])) {
          horizontal[p] += 1;       // 가로선
          vertical[q] += 1;         // 세로선
          if (p == q)               // '\' 모양의 대각선
            left_upward_diag += 1;
          if (p + q == n - 1)       // '/' 모양의 대각선
            right_upward_diag += 1;
        }
      }
    }

    // board에 가로 / 세로 / 대각선을 확인해 빙고 체크
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (horizontal[i] == n) cnt++;
      if (vertical[i] == n)   cnt++;
    }
    if (left_upward_diag == n)  cnt += 1;
    if (right_upward_diag == n) cnt += 1;

    return cnt;
  }

  public static void main(String[] args) {
    int[][] board = {
        { 11, 13, 15, 16 },
        { 12, 1, 4, 3 },
        { 10, 2, 7, 8 },
        { 5, 14, 6, 9 },
    };
    int[] nums = { 14, 3, 2, 4, 13, 1, 16, 11, 15, 5 };
    System.out.println(solution2(board, nums));

    int[][] board2 = {
        { 6, 5, 17, 14, 23 },
        { 5, 12, 16, 13, 25 },
        { 21, 4, 2, 1, 22 },
        { 10, 20, 3, 18, 8 },
        { 11, 9, 19, 24, 7 },
    };
    int[] nums2 = { 15, 7, 2, 25, 9, 16, 12, 18, 5, 4, 10, 13, 20 };
    System.out.println(solution2(board2, nums2));
  }
}
