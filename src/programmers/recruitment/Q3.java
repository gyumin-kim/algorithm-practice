package programmers.recruitment;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Gyumin Kim
 * @since 2019-03-13
 */
public class Q3 {

  public static int[] solution(int[][] customer, int K) {
    List<Integer> reserved = new LinkedList<>();
    List<Integer> waiting = new LinkedList<>();

    int remain = K;
    for (int[] ints : customer) {
      // 예약 취소
      if (ints[1] == 0) {
        if (waiting.contains(ints[0])) { // 대기자 명단에 있었을 경우
          waiting.remove(waiting.get(waiting.indexOf(ints[0])));
        } else {                         // 예약자 명단에 있었을 경우
          reserved.remove(reserved.get(reserved.indexOf(ints[0])));
          remain++;
          if (!waiting.isEmpty()) {
            reserved.add(waiting.get(0));
            waiting.remove(0);
            remain--;
          }
        }
      }
      // 예약 신청
      else {
        if (remain > 0) {
          reserved.add(ints[0]);
          remain--;
        } else {
          waiting.add(ints[0]);
        }
      }
    }

    Collections.sort(reserved);
    return reserved.stream().mapToInt(i->i).toArray();
  }

  public static void main(String[] args) {
    int[][] customer = {
        {1, 1},
        {2, 1},
        {3, 1},
        {2, 0},
        {2, 1}
    };
    int K = 2;

    int[] answer = solution(customer, K);
    for (int num : answer) {
      System.out.println(num);
    }
  }
}
