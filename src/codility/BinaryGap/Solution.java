package codility.BinaryGap;

/**
 * @author Gyumin Kim
 * @since 2019-02-20
 */
public class Solution {

  public static int solution(int N) {
    int gap = 0;
    int oneCount = 0;
    int curr = 0;
    int prev = -1;

    while (N > 0) {
      int remain = N % 2;

      if (remain == 1) {
        oneCount++;
        curr = 0;
      }
      else {
        if (oneCount >= 1) {
          if (prev == 0)  curr++;
          else  curr = 1;

          if (curr > gap) gap = curr;
        }
      }
      prev = remain;
      N /= 2;
    }

    return gap;
  }

  public static void main(String[] args) {
    System.out.println(solution(9));
    System.out.println(solution(20));
    System.out.println(solution(529));
    System.out.println(solution(15));
    System.out.println(solution(32));
  }
}
