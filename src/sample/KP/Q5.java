package sample.KP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Gyumin Kim
 * @since 2019-02-12
 */
public class Q5 {

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr1 = new int[n];
    String[] numStr1 = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr1[i] = Integer.parseInt(numStr1[i]);
    }

    int m = Integer.parseInt(br.readLine());
    int[] arr2 = new int[m];
    String[] numStr2 = br.readLine().split(" ");
    for (int i = 0; i < m; i++) {
      arr2[i] = Integer.parseInt(numStr2[i]);
    }

    int[] merge = new int[n + m];

    int p = 0;
    int q = 0;
    int k = 0;
    while (p < n && q < m) {
      if (arr1[p] < arr2[q])
        merge[k++] = arr1[p++];
      else
        merge[k++] = arr2[q++];
    }
    while (p < n)
      merge[k++] = arr1[p++];
    while (q < m)
      merge[k++] = arr2[q++];

    for (int i = 0; i < k; i++) {
      System.out.print(merge[i] + " ");
    }
    System.out.println();
  }
}
