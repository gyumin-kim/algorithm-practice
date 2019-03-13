package programmers.recruitment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Gyumin Kim
 * @since 2019-03-13
 */
public class Q3_3 {

  public int[] solution(int[][] customer, int K) {
    Map<Integer, Boolean> bookedCustomers = new HashMap<>(); //key : ID, value : 예약여부
    LinkedList<Integer> waitingCustomers = new LinkedList<>();

    for (int[] request : customer) {
      if (request[1] == 1) { //요청이 예약신청인 경우
        if (bookedCustomers.size() < K) { //빈방이 있는 경우
          bookedCustomers.put(request[0], true);
        } else { //빈방이 없는 경우
          waitingCustomers.add(request[0]);
        }
      } else { //요청이 예약취소인 경우
        //방 예약 명단에서 지운다.
        bookedCustomers.remove(request[0]);

        //대기 명단에서도 지운다.
        for (Integer waitingCustomerId : waitingCustomers) {
          if (waitingCustomerId == request[0]) {
            waitingCustomers.remove(waitingCustomerId);
            break;
          }
        }

        //만약 대기중인 손님이 있다면, 예약 해준다.
        if (bookedCustomers.size() < K && !waitingCustomers.isEmpty()) {
          Integer poll = waitingCustomers.poll();
          bookedCustomers.put(poll, true);
        }
      }
    }

    //배열로 변경
    int[] answer = new int[bookedCustomers.size()];
    Iterator<Integer> idIterator = bookedCustomers.keySet().iterator();

    for (int i = 0; idIterator.hasNext(); i++) {
      answer[i] = idIterator.next();
    }

    //ID의 오름차순으로 정렬한다.
    Arrays.sort(answer);

    return answer;
  }
}
