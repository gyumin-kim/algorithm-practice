package topcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CrazyBotSolution {

  static boolean[][] marked = new boolean[100][100];
  static int vx[] = {1, -1, 0, 0};
  static int vy[] = {0, 0, -1, 1};
  static double[] prob = new double[4];

  /**
   * n회 움직이므로, 높이가 n+1인 트리를 떠올린다. 한 노드는 동서남북 각 방향에 대한 4개의 자식 노드를 가진다. DFS 방식으로 계속 밑으로 내려가는데, 이미 방문한
   * 노드이거나 맨 밑까지 도달한 경우 멈춘다.
   */
  public static double getProbability(int n, int east, int west, int south, int north) {
    prob[0] = east / 100.0;
    prob[1] = west / 100.0;
    prob[2] = south / 100.0;
    prob[3] = north / 100.0;

    return dfs(50, 50, n);
  }

  public static double dfs(int x, int y, int n) {
    // base case
    if (marked[x][y]) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }

    marked[x][y] = true;  // 방문 체크
    double ret = 0;
    for (int i = 0; i < 4; i++) {
      ret += dfs(x + vx[i], y + vy[i], n - 1) * prob[i];
    }
    marked[x][y] = false; // 다시 방문하지 않은 것으로 하고 위로 되돌아 감

    return ret;
  }

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(getProbability(7, 50, 0, 0, 50));
  }
}
