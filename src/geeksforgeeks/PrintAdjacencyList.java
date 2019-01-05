package geeksforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/print-adjacency-list/0
 * Input:
 * 8 14
 *
 * 0 3
 * 0 1
 * 1 2
 * 1 4
 * 1 5
 * 1 3
 * 2 6
 * 2 4
 * 4 7
 * 5 6
 * 5 2
 * 5 3
 * 5 7
 * 7 1
 *
 * Its Correct output is:
 * 0-> 3-> 1
 * 1-> 0-> 2-> 4-> 5-> 3-> 7
 * 2-> 1-> 6-> 4-> 5
 * 3-> 0-> 1-> 5
 * 4-> 1-> 2-> 7
 * 5-> 1-> 6-> 2-> 3-> 7
 * 6-> 2-> 5
 * 7-> 4-> 5-> 1
 */
public class PrintAdjacencyList {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().split(" ")[0]);

    for (int i = 0; i < t; i++) {
      String[] ves = br.readLine().split(" ");
      int v = Integer.parseInt(ves[0]); // 8
      int e = Integer.parseInt(ves[1]); // 14

      // array of ArrayLists
      List<List<Integer>> group = new ArrayList<>(v);
      for (int j = 0; j < v; j++)
        group.add(new ArrayList<>());

      for (int j = 0; j < e; j++) {
        String[] vertices = br.readLine().split(" ");
        int source = Integer.parseInt(vertices[0]);
        int target = Integer.parseInt(vertices[1]);

        // source[target]에 source가 없다면 포함
        if (group.size() >= target - 1 && !group.get(target).contains(source))
          group.get(target).add(source);
        // group[source]에 target을 포함
        if (!group.get(source).contains(target)) {
          group.get(source).add(target);
        }
      }

      System.out.println();
      for (int j = 0; j < v; j++) {
        List<Integer> list = group.get(j);
        int size = list.size();
        if (size > 0) {
          System.out.print(j + "-> ");
          for (int k = 0; k < size - 1; k++) {
            System.out.print(list.get(k) + "-> ");
          }
          System.out.println(list.get(size - 1));
        }
      }
      System.out.println();
    }
  }
}
