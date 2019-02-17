package leetcode.contests.Weekly_Contest_124.Q994_Rotting_Oranges;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Gyumin Kim
 * @since 2019-02-17
 */
public class Solution {

  class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int orangesRotting(int[][] grid) {
    int minute = 0;

    // 모든 'O', 'X' 개수 파악, 변수에 저장
    int o = 0;
    int x = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2)  x++;
        else if (grid[i][j] == 1) o++;
      }
    }
    int total = o + x;
    int prev = x;
    int xLength = grid.length;
    int yLength = grid[0].length;

    // 모두 'X'일 때(모든 오렌지 썩음)까지 반복
    while (total != x) {
      List<Point> points = new ArrayList<>();
      // 현재 존재하는 모든 'X'에 대해
      for (int i = 0; i < xLength; i++) {
        for (int j = 0; j < yLength; j++) {
          // 상하좌우에 'O'가 있으면, 'X'로 바꾸고 'X' 증가
          if (grid[i][j] == 2) {
            Point point = new Point(i, j);
            points.add(point);
          }
        }
      }

      for (Point point : points) {
        if (point.x-1 >= 0 && point.x-1 < xLength && point.y < yLength && grid[point.x-1][point.y] == 1) {
          grid[point.x-1][point.y] = 2;
          x++;
        }
        if (point.x+1 < xLength && grid[point.x+1][point.y] == 1) {
          grid[point.x+1][point.y] = 2;
          x++;
        }
        if (point.y-1 >= 0 && point.y-1 < yLength && grid[point.x][point.y-1] == 1) {
          grid[point.x][point.y-1] = 2;
          x++;
        }
        if (point.y+1 < yLength && grid[point.x][point.y+1] == 1) {
          grid[point.x][point.y+1] = 2;
          x++;
        }
      }

      // 전후 'X' 개수가 똑같아지면(인접한 오렌지 없음)
      if (prev == x) {
        return -1;
      }
      prev = x;
      // minute 1 증가
      minute++;
    }

    return minute;
  }

  public int orangesRotting2(int[][] grid) {
    int[] dr = { 1, 0, -1, 0 };
    int[] dc = { 0, 1, 0, -1 };
    int R = grid.length;
    int C = grid[0].length;
    Queue<Integer> queue = new ArrayDeque<>();
    Map<Integer, Integer> depth = new HashMap<>();

    for (int r = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if (grid[r][c] == 2) {
          int code = r * C + c;
          queue.add(code);
          depth.put(code, 0);
        }
      }
    }

    int answer = 0;
    while (!queue.isEmpty()) {
      int code = queue.poll();
      int r = code / C;
      int c = code % C;
      for (int i = 0; i < 4; i++) {
        int nr = r + dr[i];
        int nc = c + dc[i];
        if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 1) {
          grid[nr][nc] = 2;
          int ncode = nr * C + nc;
          queue.add(ncode);
          depth.put(ncode, depth.get(code) + 1);
          answer = depth.get(ncode);
        }
      }
    }

    return answer;
  }
}
