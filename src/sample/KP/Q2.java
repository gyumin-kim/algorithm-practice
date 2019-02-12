package sample.KP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Gyumin Kim
 * @since 2019-02-12
 */
public class Q2 {

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] answer = new int[n];

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      for (int j = 1; j <= 60; j++) {
        int tmpfib = fib(j);
        if (tmpfib > num) {
          answer[i] = tmpfib;
          break;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.println(answer[i]);
    }
  }

  public static int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
  }
}
