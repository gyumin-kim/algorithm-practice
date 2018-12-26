package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 */
public class TravelRoute {

  /**
   * [[ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]]
   */
  public static List<String[]> toList(String[][] tickets) {
    List<String[]> list = new ArrayList<>();
    int len = tickets.length;
    for (int i = 0; i < len; i++) {
      list.add(tickets[i]);
    }

    return list;
  }

  public static String[] find(List<String[]> list, String airport) {

    String[] forwardArr = list.get(0);
    String forward = forwardArr[1];

    if (list.size() > 1) {
      for (int i = 1; i < list.size(); i++) {
        // list.get(i)의 0번째 요소가 airport인 요소이면
        if (list.get(i)[0].equals(airport)) {
          // list.get(i)의 1번째 요소가 forward보다 앞선 위치에 있는지 체크
          // list.get(i)[1]이 forward보다 더 앞선 글자이면
          if (list.get(i)[1].compareTo(forward) < 0) {
            forward = list.get(i)[1];
            forwardArr = list.get(i);
          }
        }
      }
    }

    // 찾은 요소를 list에서 삭제
    int index = list.indexOf(forwardArr);
    list.remove(list.get(index));

    return forwardArr;
  }

  public static String[] solution(String[][] tickets) {
    String[] answer = new String[tickets.length + 1];

    List<String[]> list = toList(tickets);
    String[] first = find(list, "ICN");
    // first[0]을 answer에 push
    answer[0] = first[0];
    String tmp = first[1];

    int i = 1;
    // (tickets의 길이가 0이 될 때까지) 반복:
    while (list.size() > 1) {
      // tickets[][]에서 [0]번째 요소가 airport인 요소들을 모두 찾고, 찾은 요소들 중 [1]번째 요소의 순서가 더 앞서는 것을 찾는다.
      String[] arr = find(list, tmp);
      tmp = arr[1];
      answer[i++] = arr[0];
    }
    answer[i] = list.get(0)[0];

    return answer;
  }

  public static void main(String[] args) {
    String[][] strings = new String[][]{
        {"ICN", "SFO"},
        {"ICN", "ATL"},
        {"SFO", "ATL"},
        {"ATL", "ICN"},
        {"ATL", "SFO"},
    };

    String[] answer = solution(strings);
    for (String str : answer) {
      System.out.print(str + " ");
    }
  }
}
