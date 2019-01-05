package geeksforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/print-adjacency-list/0
 */
public class PrintAdjacencyList {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().split(" ")[0]);

    for (int i = 0; i < t; i++) {
      String[] ves = br.readLine().split(" ");
      int v = Integer.parseInt(ves[0]); // 5
      int e = Integer.parseInt(ves[1]); // 7

      // array of ArrayLists
      List<List<Integer>> group = new ArrayList<>();
      for (int j = 0; j < v; j++) {
        group.add(new ArrayList<>());
      }
      for (int j = 0; j < e; j++) {
        String[] vertices = br.readLine().split(" ");
        int source = Integer.parseInt(vertices[0]);
        int target = Integer.parseInt(vertices[1]);

        // source[target]에 source가 없다면 포함
        if (group.size() >= target - 1 && !group.get(target).contains(source)) {
          group.get(target).add(source);
        }
        // group[source]에 target을 포함
        group.get(source).add(target);
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
