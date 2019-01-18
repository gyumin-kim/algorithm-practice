package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/15122
 */
public class ForbiddenZero_15122 {

  public static int solution(int num) {
    num++;
    while (hasZero(num)) {
      num++;
    }

    return num;
  }

  public static boolean hasZero(int num) {
    while (num > 0) {
      if (num % 10 == 0) {
        return true;
      }
      num /= 10;
    }
    return false;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    System.out.println(solution(num));
  }
}
