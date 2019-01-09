package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class SixDegreesOfKevinBacon_1389 {

  private static boolean[] marked;
  private static int[] edgeTo;
//  private static int s;

//  private static void dfs(Graph g, int v, int target) {
//    marked[v] = true; // 방문할 곳을 mark
//    if (v == target) {
//      return;
//    }
//    for (int w : g.adj(v)) { // 인접해있으면서 아직 방문하지 않은 vertex이면 방문
//      if (!marked[w]) {
//        edgeTo[w] = v; // v에서 출발해 w를 처음 방문했다는 뜻
//        dfs(g, w, target);
//      }
//    }
//  }

  private static void bfs(Graph g, int s) {
    Queue<Integer> queue = new PriorityQueue<>();
    marked[s] = true;
    queue.add(s);
    while (!queue.isEmpty()) {
      int v = queue.poll();     // queue의 맨 앞에서 하나 빼기
      for (int w : g.adj(v)) {
        if (!marked[w]) {       // 뺀 v와 인접하면서 아직 방문하지 않은 vertex w
          edgeTo[w] = v;
          marked[w] = true;
          queue.add(w);
        }
      }
    }
  }

  public static int pathSize(int s, int v) {
    if (!marked[v]) {
      return -1;
    }

    Stack<Integer> path = new Stack<>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(s);

    return path.size();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nmStr = br.readLine().split(" ");
    int n = Integer.parseInt(nmStr[0]); // vertex 수 (유저 수)
    int m = Integer.parseInt(nmStr[1]); // edge 수 (관계의 수)
    Graph graph = new Graph(n);
    marked = new boolean[n];
    edgeTo = new int[n];

    // m개의 친구관계를 입력 받아 edge를 추가한다.
    for (int i = 0; i < m; i++) {
      String[] relStr = br.readLine().split(" ");
      int a = Integer.parseInt(relStr[0]) - 1;
      int b = Integer.parseInt(relStr[1]) - 1;
      graph.addEdge(a, b);
    }

    int shortestPath = m;
    int answer = 1;
    // 각 vertex들의 케빈 베이컨의 수 구하고,
    // 가장 작은 값이면 shortestPath와 그 사람의 번호를 각각 update
    for (int i = 0; i < n; i++) {
      int pathSum = 0;
      for (int j = 0; j < n; j++) {
        // 본인은 제외
        if (i != j) {
          bfs(graph, i);
          pathSum += pathSize(i, j);
          // marked, edgeTo 초기화
          marked = new boolean[n];
          edgeTo = new int[n];
        }
      }

      if (pathSum < shortestPath) {
        shortestPath = pathSum;
        answer = i + 1;
      }
    }

    System.out.println(answer);
  }
}

class Graph {

  private final int V;      // 유저의 수
  //  private final int totalE; // 전체 edge(친구관계)의 수
//  private int currentE;            // 현재 edge(친구관계)의 수
  private LinkedList<Integer>[] adj;

  public Graph(int v) {
    this.V = v;
//    this.totalE = e;
//    this.currentE = 0;

    adj = new LinkedList[V];
    for (int i = 0; i < V; i++) {
      // 유저의 수 V만큼의 배열이 있고, 각 배열에는 각 유저가 가진 친구가 연결리스트가 담겨 있다.
      adj[i] = new LinkedList<>();
    }
  }

  // v, w 각각에 친구 관계를 추가하고, edge의 개수를 증가시킨다.
  public void addEdge(int v, int w) {
    this.adj[v].add(w);
    this.adj[w].add(v);
  }

  public Iterable<Integer> adj(int v) {
    return this.adj[v];
  }
}