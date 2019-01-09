package topcoder;

public class CrazyBot {

  private static boolean[][] marked;
  private static final int[] dirX = {1, -1, 0, 0};
  private static final int[] dirY = {0, 0, -1, 1};
  private static double failProbability = 0.0;
  private static double[] prob;
//  private static int count = 0;

  public static double[] getProbability(int n, int east, int west, int south, int north) {
    double eastProb = east / 100.0;
    double westProb = west / 100.0;
    double southProb = south / 100.0;
    double northProb = north / 100.0;
    double[] prob = {eastProb, westProb, southProb, northProb};

    // n번을 계속 같은 방향으로 갈 수도 있으므로, 배열의 길이를 (2*n + 1)로 두고 로봇이 배열의 정가운데 위치한다고 가정
    marked = new boolean[2 * n + 1][2 * n + 1];

//    marked[n][n] = true;  // 정가운데에서부터 시작하므로, marked[n][n]에 방문한 것으로 해놓고 시작

    return prob;
////    double failProbability = 0.0;
//
////    for (int i = 0; i < n; i++) {
////      marked[dirX[?]][dirY[?]]
////    }
//
//
//    return 100.0 - failProbability;
  }

  public static void dfs(int x, int y, double p, int count) {
    if (count >= 5) {
      return;
    }
    marked[x][y] = true;
    // i => 0:동, 1:서, 2:남, 3:북
    for (int i = 0; i < 4; i++) {
//      int newX = x + dirX[i];
//      int newY = x + dirY[i];
//      if (newX < 10 && newX >= 0 && newY < 10 && newY >= 0 && !marked[newX][newY]) {
      if (!marked[x + dirX[i]][y + dirY[i]]) {
        dfs(x + dirX[i], y + dirY[i], p * prob[i], count++);
      } else {
        failProbability += (p * prob[i]);
      }
    }
  }

  public static void main(String[] args) {
    prob = getProbability(5, 18, 36, 25, 21);
    dfs(5, 5, 1.0, 0);

    System.out.println("성공율: " + (100.0 - failProbability));
  }
}
