package sample.KP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Gyumin Kim
 * @since 2019-02-12
 */
public class Q6 {

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] nums = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(nums[i]);
    }

    boolean flag = true;
    for (int i = 0; i < n-1; i++) {
      if (Math.abs(arr[i] - arr[i+1]) > 1) {
        flag = false;
        break;
      }
    }

    if (flag) System.out.println("YES");
    else System.out.println("NO");
  }
}
