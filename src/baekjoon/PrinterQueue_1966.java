package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.acmicpc.net/problem/1966
 */
public class PrinterQueue_1966 {

  /**
   * 각 test case에 대해 문서가 몇 번째로 인쇄되는지 출력한다. 실패.
   */
  public static void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // test case의 수를 입력 받는다 (=count)
    int count = Integer.parseInt(br.readLine());
    int[] answer = new int[count];
    // count번 반복
    for (int i = 0; i < count; i++) {
      // M과 N을 입력 받는다
      String[] mn = br.readLine().split(" ");
      int m = Integer.parseInt(mn[0]);
      int n = Integer.parseInt(mn[1]);
      // Map<Integer, Boolean>의 key에는 1부터 M까지, value에는 중요도를 입력 받아(M개) 넣는다.
      List<Map<Integer, Boolean>> list = new ArrayList<>();
      String[] elemStrings = br.readLine().split(" ");
      int[] elems = new int[m];
      for (int j = 0; j < m; j++) {
        elems[j] = Integer.parseInt(elemStrings[j]);
        Map<Integer, Boolean> map = new HashMap<>();
        if (j == n) {
          map.put(elems[j], true);
        } else {
          map.put(elems[j], false);
        }
        list.add(map);
      }

      boolean flag = false;
      for (int j = 0; j < m; j++) {
        if (flag) {
          // list를 순회하면서 요소의 value가 true인 요소는 몇번째인지 구한다
          for (int l = 0; l < m; l++) {
            if (list.get(l).containsValue(true)) {
              answer[i] = l + 1;
            }
          }
          break;
        }
        flag = true;
        // list의 0번째 요소보다 map의 key가 큰 요소가 있는 경우, 해당 요소를 list의 맨 뒤로 보낸다.
        int max = (Integer) list.get(0).keySet().toArray()[0];
        for (int k = 1; k < m; k++) {
          if ((Integer) list.get(k).keySet().toArray()[0] > max) {
            flag = false;
            break;
          }
        }

        if (!flag) {
          // list의 0번째 요소를 맨 뒤로 보낸다
          list.add(list.remove(0));
        }
      }
    }

    for (int i = 0; i < count; i++) {
      System.out.println(answer[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    solution();
  }
}
