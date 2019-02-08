package sample;

/**
 * @author Gyumin Kim
 * @since 2019-02-08
 *
 * 10진수 num을 입력 받아 n진수로 변환하는 함수를 구현 하시오.
 * (단 n은 16이하의 자연수입니다. 라이브러리 사용 불가)
 */
public class Q1 {

  public static String solution(int num, int n) {
    String t = "0123456789ABCDEF";

    int q = num / n;
    int r = num % n;
    if (q == 0)
      return String.valueOf(t.charAt(r));
    else
      return solution(q, n) + t.charAt(r);
  }

  public static void main(String[] args) {
    System.out.println(solution(233, 16));
  }
}
