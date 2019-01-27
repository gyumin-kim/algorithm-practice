package programmers.mockTest2th;

import java.util.HashMap;
import java.util.Map;

public class Test3 {

  /**
   * HashMap이 들어있는 2차원 배열을 만들면 될까?
   * @param board 빙고 게임 보드에 적힌 숫자가 담겨있는 배열
   * @param nums 게임 보드에서 순서대로 지운 숫자가 들어있는 배열
   * @return 몇 개의 빙고가 만들어지는지
   */
  public int solution(int[][] board, int[] nums) {
    int answer = 0;
    // key는 board에 담긴 각 숫자인 HashMap을 만든다.
    Map<Integer, Boolean> map = new HashMap<>();


    // nums에 담긴 수를 key로 갖는 요소는 value를 true로 바꾼다.


    // 이 HashMap을 board와 크기가 같은 2차원 배열에 담는다.
    Object[][] arr = new Object[5][5];


    // HashMap에서 value가 true인 요소의 배열 인덱스를 갖고 가로, 세로, 대각선을 판단해 몇 개의 빙고가 만들어지는지 판단한다.


    return answer;
  }
}
