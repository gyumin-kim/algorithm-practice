package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NotFinishedPlayer_42576 {

  /**
   * 두 배열을 정렬한 뒤 앞에서부터 순회하면서 다른 부분을 찾기
   *
   * 정확성  테스트 테스트 1 〉	통과 (0.99ms, 48MB) 테스트 2 〉	통과 (1.10ms, 48.2MB) 테스트 3 〉	통과 (4.01ms, 47.9MB) 테스트
   * 4 〉	통과 (7.72ms, 50.1MB) 테스트 5 〉	통과 (11.46ms, 45.8MB)
   *
   * 효율성  테스트 테스트 1 〉	통과 (117.57ms, 83.2MB) 테스트 2 〉	통과 (216.75ms, 93MB) 테스트 3 〉	통과 (230.34ms, 93MB)
   * 테스트 4 〉	통과 (270.34ms, 106MB) 테스트 5 〉	통과 (254.00ms, 106MB)
   */
  public static String solution(String[] participant, String[] completion) {

    Arrays.sort(participant);
    Arrays.sort(completion);
    String answer = participant[participant.length - 1];

    int length = completion.length;
    for (int i = 0; i < length; i++) {
      if (!participant[i].equals(completion[i])) {
        answer = participant[i];
        break;
      }
    }

    return answer;
  }

  /**
   * HashMap에 각 배열의 요소를 넣는다. participant의 요소인 경우 value는 +1하고, completion의 요소인 경우 -1한다. value가 0이 아닌
   * player가 answer다.
   *
   * HashMap을 사용하니 속도가 훨씬 빨라진다.
   *
   * 정확성  테스트 테스트 1 〉	통과 (1.17ms, 47.6MB) 테스트 2 〉	통과 (1.14ms, 45.2MB) 테스트 3 〉	통과 (1.81ms, 47.9MB)
   * 테스트 4 〉	통과 (8.18ms, 46.3MB) 테스트 5 〉	통과 (2.53ms, 50.8MB)
   *
   * 효율성  테스트 테스트 1 〉	통과 (56.98ms, 83.4MB) 테스트 2 〉	통과 (76.16ms, 92.8MB) 테스트 3 〉	통과 (77.03ms, 95.6MB)
   * 테스트 4 〉	통과 (117.15ms, 110MB) 테스트 5 〉	통과 (87.24ms, 110MB)
   */
  public static String solution2(String[] participant, String[] completion) {
    String answer = "";
    Map<String, Integer> map = new HashMap<>();

    for (String player : participant) {
      map.put(player, map.getOrDefault(player, 0) + 1);
    }
    for (String player : completion) {
      map.put(player, map.get(player) - 1);
    }

    for (String player : map.keySet()) {
      if (map.get(player) != 0) {
        answer = player;
      }
    }

    return answer;
  }
}
