package programmers.woowabros;

/**
 * @author Gyumin Kim
 * @since 2019-03-16
 */
public class Q5 {

  public static int solution(int number) {
    int answer = 0;

    for (int i = 1; i <= number; i++) {
      int tmp = i;
      while (tmp > 0) {
        if ((tmp % 10 != 0) && (tmp % 10) % 3 == 0) {
          answer++;
        }

        tmp /= 10;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(13));
    System.out.println(solution(33));
  }
}
