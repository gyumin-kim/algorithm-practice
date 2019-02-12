package sample.KP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Gyumin Kim
 * @since 2019-02-12
 */
public class Q4 {

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] array = new String[n];

    for (int i = 0; i < n; i++) {
      array[i] = br.readLine();
      String[] tmp = array[i].split(" ");
      Arrays.sort(tmp, Collections.reverseOrder());

      array[i] = "";
      int length = tmp.length;
      for (int j = 0; j < length; j++) {
        array[i] += (tmp[j] + " ");
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.println(array[i]);
    }
  }
}
