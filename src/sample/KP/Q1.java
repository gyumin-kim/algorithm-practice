package sample.KP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Gyumin Kim
 * @since 2019-02-12
 */
public class Q1 {

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nms = br.readLine().split(" ");
    int n = Integer.parseInt(nms[0]);
    int m = Integer.parseInt(nms[1]);

    String[] integers = br.readLine().split(" ");
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = Integer.parseInt(integers[i]);
    }

    for (int i = 0; i < m; i++) {
      int num = Integer.parseInt(br.readLine());
      System.out.println(num);
      boolean flag = false;
      for (int j = 0; j < n; j++) {
        if (array[j] == num) {
          flag = true;
          break;
        }
      }
      if (flag) {
        System.out.println("True");
      } else {
        System.out.println("False");
      }
    }

    br.close();
  }
}
