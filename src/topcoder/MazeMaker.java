package topcoder;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 출발점에서 출발점을 제외한 모든 점 각각을 도착지로 하는 반복: bfs()로 최단경로 구함 pathTo()로 경로 길이를 구함 구한 경로 길이가 최대값인지 체크 후 교체
 */
public class MazeMaker {

  private static boolean[][] marked;
  private static String[][] edgeTo;

  public static int longestPath(String[] maze, int startRow, int startCol,
      int[] moveRow, int[] moveCol) {

    int moveLen = moveRow.length;
    // marked[][], edgeTo[][] 초기화
    int mazeRowLen = maze.length;
    int mazeColLen = maze[0].length();
    marked = new boolean[mazeRowLen][mazeColLen];
    edgeTo = new String[mazeRowLen][mazeColLen];

    // quque 2개(queueX, queueY)를 만든다.
    Queue<Integer> queueX = new PriorityQueue<>();
    Queue<Integer> queueY = new PriorityQueue<>();

    // 점 (startRow, startCol)를 방문한 것으로 표시 (출발점)
    if (maze[startRow].charAt(startCol) == '.') {
      marked[startRow][startCol] = true;
    }

    // queueX에 점 x, queueY에 점 y를 넣는다. (maze[x].charAt(y))
    queueX.add(startRow);
    queueY.add(startCol);

    // queue 2개가 모두 비워질 때까지 반복:
    while (!queueX.isEmpty() && !queueY.isEmpty()) {
      // dequeue해서 점 (m, n) 를 꺼낸다.
      int m = queueX.poll();
      int n = queueY.poll();

      // 꺼낸 점 (m, n) (maze[m].charAt(n))와 인접한 점들에 대해 반복:
      // 인접여부 판단: maze[m].charAt(n)에서 이동한 maze[m+moveRow[i]].charAt(n+moveRow[i])이 '.'인지 체크
      for (int i = 0; i < moveLen; i++) {
        // if (인접한 점(w)이 아직 방문되지 않았으면)
        if (m + moveRow[i] >= 0 && m + moveRow[i] < moveLen
            && n + moveRow[i] >= 0 && n + moveRow[i] < moveLen
            && maze[m + moveRow[i]].charAt(n + moveRow[i]) == '.'
            && !marked[m + moveRow[i]][n + moveRow[i]]) {

          edgeTo[m + moveRow[i]][n + moveRow[i]] = "m,n";
          marked[m + moveRow[i]][n + moveRow[i]] = true;

          // w를 queue에 넣는다.
          queueX.add(moveRow[i]);
          queueY.add(moveCol[i]);
        }
      }
    }

    String[] longestPoint = longestPoint(mazeRowLen, mazeColLen, startRow, startCol).split(",");
    int longestPointX = Integer.parseInt(longestPoint[0]);
    int longestPointY = Integer.parseInt(longestPoint[1]);

    // 가장 먼 곳에 도달할 수 없는 경우
    if (!marked[longestPointX][longestPointY]) {
      return -1;
    }
    // 가장 먼 곳으로 가는 최단 경로의 길이를 리턴
    else {
      int pathLength = 0;
      int tmpX = longestPointX;
      int tmpY = longestPointY;
      while (tmpX != startRow && tmpY != startCol) {
        String[] nextPoint = edgeTo[tmpX][tmpY].split(",");
        tmpX = Integer.parseInt(nextPoint[0]);
        tmpY = Integer.parseInt(nextPoint[1]);
        pathLength++;
      }
      return pathLength;
    }
  }

  // (x, y)에서 가장 먼 점을 구하는 메소드
  private static String longestPoint(int mazeRowLen, int mazeColLen, int x, int y) {
    int tmpX = (x <= mazeRowLen / 2) ? mazeRowLen - 1 : 0;
    int tmpY = (y <= mazeColLen / 2) ? mazeColLen - 1 : 0;

    return tmpX + "," + tmpY;
  }

//  private static void bfs(int x, int y) {
//
//  }

//  // v로 가는 최단경로의 길이를 구함
//  private static int pathLengthTo(int x, int y) {
//    if (!marked[x][y])  return -1;
//    Deque<Integer> stack = new ArrayDeque<>();
//    // TODO: 2차원 좌표 각각에 대한 변수를 2개로 따로 만들어야 할 듯?
//    for ()
//  }

  public static void main(String[] args) {
    String[] maze = {".......",
        "X.X.X..",
        "XXX...X",
        "....X..",
        "X....X.",
        "......."};
    int[] moveRow = {1, 0, -1, 0, -2, 1};
    int[] moveCol = {0, -1, 0, 1, 3, 0};

    System.out.println(longestPath(maze, 5, 0, moveRow, moveCol));
  }
}
