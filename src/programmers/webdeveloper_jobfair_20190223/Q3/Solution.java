package programmers.webdeveloper_jobfair_20190223.Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Gyumin Kim
 * @since 2019-02-23
 */
public class Solution {
  public int[] solution(int[] healths, int[][] items) {

    int[][] attackHighToLow = items.clone();

    // items 각 요소의 공격력(0번째 요소)의 내림차순으로 정렬
    Arrays.sort(attackHighToLow, (o1, o2) -> Integer.compare(o2[0], o1[0]));
//    Arrays.sort(attackHighToLow, new Comparator<int[]>() {
//      @Override
//      public int compare(int[] o1, int[] o2) {
//        return Integer.compare(o2[0], o1[0]);
//      }
//    });

    Arrays.sort(healths);
    List<Integer> list = new ArrayList<>();
    boolean[] isUsed = new boolean[items[0].length];

    for (int[] ints : attackHighToLow) {
      for (int j = 0; j < healths.length; j++) {
        // ints[1]: 각 item을 썼을 때 소모되는 체력
        if (healths[j] - ints[1] >= 100 && !isUsed[j]) {
          isUsed[j] = true;
          list.add(ints[0]);  // 공격력 증가
          break;
        }
      }
    }

    int[] answer = new int[list.size()];
    int index = 0;
    for (int i = 0; i < items.length; i++) {
      if (list.contains(items[i][0]))
        answer[index++] = i + 1;
      if (index == list.size())
        return answer;
    }

    return answer;
  }
}
