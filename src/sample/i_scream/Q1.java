package sample.i_scream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 김규민
 * @since 2019-04-03
 */
public class Q1 {

  public static void solution(int[] vals) {
    int id = vals[0];
    boolean afterId = false;
    boolean afterSize = false;

    // {ID, 수들의 배열}을 key-value로 갖는 map
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int val : vals) {
      if (val == id) {            // id인 경우
        map.put(id, new ArrayList<>());
        afterId = true;
      } else if (afterId) {       // size
        afterId = false;
        afterSize = true;
      } else if (afterSize) {     // 각 id의 수들 시작
        map.get(id).add(val); // 해당 id의 map에 숫자를 추가
      } else if (val == id + 1) { // 다음 id인 경우
        id = val;
        afterSize = false;
      }
    }

    // 각 ID의 합과 평균 출력
    for (Integer key : map.keySet()) {
      ArrayList<Integer> numbers = map.get(key);
      int sum = numbers.stream().mapToInt(value -> value).sum();
      System.out.print(key + "번 값 : [");
      for (int i = 0; i < numbers.size() - 1; i++) {
        System.out.print(numbers.get(i));
        System.out.print(", ");
      }
      System.out.print(numbers.get(numbers.size() - 1));
      System.out.print(" -> 합 " + sum + ", 평균 " + (sum / numbers.size()));
    }
  }

  public static void main(String[] args) {
    int[] vals = {101, 2, 3, 4, 102, 3, 1, 2, 3, 101, 1, 5};
    solution(vals);
  }
}
