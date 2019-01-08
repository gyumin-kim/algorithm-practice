package custom;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstPaths {

  private boolean[] marked; // 특정 vertex 방문 여부
  private int[] edgeTo;
  private final int s;

  public DepthFirstPaths(Graph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    dfsPrint(G, s);
  }

  private void dfsPrint(Graph G, int v) {
    marked[v] = true;
    System.out.print(v + " ");

    Iterator<Integer> i = G.adj(v).iterator();
    while (i.hasNext()) {
      int n = i.next();
      if (!marked[n]) {
        dfsPrint(G, n);
      }
    }
  }

  private void dfs(Graph G, int v) {
    marked[v] = true; // 방문할 곳을 mark
    for (int w : G.adj(v)) // 인접해있으면서 아직 방문하지 않은 vertex이면 방문
    {
      if (!marked[w]) {
        edgeTo[w] = v; // v에서 출발해 w를 처음 방문했다는 뜻
        dfs(G, w);
      }
    }
  }

  public Stack<Integer> pathTo(int v) {
    if (!marked[v]) {
      return null;
    }
    Stack<Integer> path = new Stack<>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(s);

    return path;
  }

  public static void main(String[] args) {
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);

    // 2에서 출발해 모든 vertex를 방문하는 path 구하기
    DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, 2);

//    Stack<Integer> stack = depthFirstPaths.pathTo(3);
//    while(!stack.empty()) {
//      System.out.print(stack.pop() + " ");
//    }
  }
}