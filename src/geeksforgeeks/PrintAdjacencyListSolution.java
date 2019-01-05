package geeksforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://practice.geeksforgeeks.org/problems/print-adjacency-list/0
 */
public class PrintAdjacencyListSolution {

  static class Graph {

    ArrayList[] array; // array of ArrayList (LinkedList is also possible)
    int v;  // the number of vertices

    Graph(int v) {
      this.v = v;
      array = new ArrayList[v];

      // Add linkedList to array
      for (int i = 0; i < v; i++) {
        array[i] = new ArrayList<>();
      }
    }
  }

  private static void addEdge(Graph graph, int source, int target) {
    if (!graph.array[target].contains(source)) {
      graph.array[target].add(source);
    }
    if (!graph.array[source].contains(target)) {
      graph.array[source].add(target);
    }
  }

  private static void printGraph(Graph graph) {
    System.out.println();
    int length = graph.array.length;

    for (int i = 0; i < length; i++) {
      System.out.print(i + "-> ");
      ArrayList list = graph.array[i];
      int size = list.size();
      for (int j = 0; j < size - 1; j++) {
        System.out.print(list.get(j) + "-> ");
      }
      System.out.println(list.get(size - 1));
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().split(" ")[0]);

    for (int i = 0; i < t; i++) {
      String[] ves = br.readLine().split(" ");
      int v = Integer.parseInt(ves[0]);
      int e = Integer.parseInt(ves[1]);
      Graph graph = new Graph(v);

      for (int j = 0; j < e; j++) {
        String[] vertices = br.readLine().split(" ");
        int source = Integer.parseInt(vertices[0]);
        int target = Integer.parseInt(vertices[1]);
        addEdge(graph, source, target);
      }

      printGraph(graph);
    }
  }
}
