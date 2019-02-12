package sample.KP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Gyumin Kim
 * @since 2019-02-12
 */
public class Q3 {

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] inputs = new String[n];

    for (int i = 0; i < n; i++) {
      inputs[i] = br.readLine();
    }

    for (int i = 0; i < n; i++) {
      StringBuffer sb = new StringBuffer();
      for (int j = 0; j < inputs[i].length(); j++) {
        char ch = inputs[i].charAt(j);
        if (!((ch >= 48 && ch <= 57) || (ch >= 65 && ch <= 90) || (ch >= 97) && ch <= 122)) {
          if (sb.charAt(sb.length()-1) != ' ')
            sb.append(' ');
        } else {
          sb.append(ch);
        }
      }

      System.out.println(sb.toString());
    }
  }
}
