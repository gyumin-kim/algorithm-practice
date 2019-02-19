package sample.ZI;

/**
 * @author Gyumin Kim
 * @since 2019-02-18
 */
public class Q1 {

  public static int solution(int[] A) {
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      if (!isDecreasing(A, i)) count++;
    }

    return count;
  }

  public static boolean isDecreasing(int[] A, int k) {
    if (A.length <= 1)  return true;

    int prev;
    if (k != 0)
      prev = A[0];
    else
      prev = A[1];

    for (int i = 1; i < A.length; i++) {
      if (i == k) continue;
      if (A[i] < prev)  return true;
      prev = A[i];
    }
    return false;
  }

  public static void main(String[] args) {
    int[] A = { 1, 2, 3, 3, 5, 6, 7 };
    System.out.println(solution(A));
  }
}
