package sample.KP2;

/**
 * @author Gyumin Kim
 * @since 2019-02-19
 */
public class Q3 {

  public static int solution(int m, int[] marr, int n, int[] narr, int k) {
    int i = 0;
    int j = 0;

    while (i < m && j < n && i+j < k-1) {
      if (marr[i] < narr[j])
        i++;
      else
        j++;
    }

    if (i+j != k-1) {
      if (i == marr.length) {
        return narr[k-i-j];
      }
      else if (j == narr.length) {
        return marr[k-j-i];
      }
    }

    if (marr[i] < narr[j])  return marr[i];
    else return narr[j];
  }

  public static void main(String[] args) {
    int m = 5;
    int[] marr = { 19, 21, 31, 41, 43 };
    int n = 12;
    int[] narr = { 42, 44, 45, 46, 48, 56, 67, 68, 69, 70, 71, 72 };
    int k = 8;

    System.out.println(solution(m, marr, n, narr, k));
  }
}
