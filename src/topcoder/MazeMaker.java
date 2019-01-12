package topcoder;

import java.util.PriorityQueue;
import java.util.Queue;

public class MazeMaker {

  public static int longestPath(String[] maze, int startRow, int startCol,
      int[] moveRow, int[] moveCol) {

    int moveLen = moveRow.length;
    int mazeRowLen = maze.length;
    int mazeColLen = maze[0].length();
    boolean[][] marked = new boolean[mazeRowLen][mazeColLen];
    int[][] sum = new int[mazeRowLen][mazeColLen];

    int max = 0;

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

    // sum[][]의 모든 값을 -1로 초기화하고, 출발점은 0으로 한다.
    for (int i = 0; i < mazeRowLen; i++) {
      for (int j = 0; j < mazeColLen; j++) {
        sum[i][j] = -1;
      }
    }
    sum[startRow][startCol] = 0;

    // queue 2개가 모두 비워질 때까지 반복:
    while (!queueX.isEmpty() && !queueY.isEmpty()) {
      // dequeue해서 점 (m, n) 를 꺼낸다.
      int m = queueX.poll();
      int n = queueY.poll();

      // 꺼낸 점 (m, n) (maze[m].charAt(n))와 인접한 점들에 대해 반복:
      // 인접여부 판단: maze[m].charAt(n)에서 이동한 maze[m+moveRow[i]].charAt(n+moveRow[i])이 '.'인지 체크
      for (int i = 0; i < moveLen; i++) {
        int nextRow = m + moveRow[i];
        int nextCol = n + moveCol[i];
        // 인접한 점이 아직 방문되지 않았으면
        // 인접한 점: 이동한 곳이 미로를 벗어나지 않는 곳이면서, 방문 가능한 곳('.')이며, 아직 방문하지 않은 곳
        if (nextRow >= 0 && nextRow < mazeRowLen
            && nextCol >= 0 && nextCol < mazeColLen
            && maze[nextRow].charAt(nextCol) == '.'
            && !marked[nextRow][nextCol]) {

          marked[nextRow][nextCol] = true;
          sum[nextRow][nextCol] = sum[m][n] + 1;

          // 인접한 점을 queue에 넣는다.
          queueX.add(nextRow);
          queueY.add(nextCol);
        }
      }
    }

    // 정답 계산
    for (int i = 0; i < mazeRowLen; i++) {
      for (int j = 0; j < mazeColLen; j++) {
        // 지나갈 수 있는 점('.')이지만 가지 못한 경우
        if (maze[i].charAt(j) == '.' && sum[i][j] == -1) {
          return -1;
        }
        max = Math.max(max, sum[i][j]);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    String[] maze = {
        ".......",
        "X.X.X..",
        "XXX...X",
        "....X..",
        "X....X.",
        "......."
    };
    String[] maze2 = {
        "......."
    };
    String[] maze3 = {
        "..X.X.X.X.X.X."
    };
    int[] moveRow = {1, 0, 1, 0, 1, 0};
    int[] moveCol = {0, 1, 0, 1, 0, 1};

    System.out.println(longestPath(maze2, 0, 0, moveRow, moveCol));
  }
}
