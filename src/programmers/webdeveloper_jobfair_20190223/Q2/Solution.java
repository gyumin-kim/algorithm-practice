package programmers.webdeveloper_jobfair_20190223.Q2;

import java.util.Arrays;

/**
 * @author Gyumin Kim
 * @since 2019-02-23
 */
public class Solution {
  public int solution(int[] people, int[] tshirts) {
    int answer = 0;
    Arrays.sort(people);
    Arrays.sort(tshirts);

    for (int person : people) {
      for (int tshirt : tshirts) {
        if (person <= tshirt) {
          answer++;
          break;
        }
      }
    }

    return answer;
  }
}
