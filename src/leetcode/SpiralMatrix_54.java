package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix_54 {

  /**
   * 가로, 세로를 각각 따로 보면, 한 변을 지날 때마다 다음 변에서는 길이가 1씩 줄어든다.
   * 각 loop마다 변의 길이(width 혹은 height)에 도달할 때까지 한 점씩 나아간다.
   * 방문한 모든 점의 개수가 배열의 모든 요소의 합과 같아지면 종료한다.
   * 종료하는 조건 부분이 좀 조잡한 것 같다.
   * 애초에 totalCount를 정확하게 계산할 수 있으면, 각 case마다 sum을 증가시키고 매번 검사하는 작업이 필요 없을 것이다.
   *
   * Leetcode runtime: 1ms
   * time complexity: O(m*n), m과 n은 2차원 배열(matrix)의 각 length
   */
  public static List<Integer> spiralOrder(int[][] matrix) {
    if (matrix.length == 0)
      return new ArrayList<>();

    List<Integer> list = new ArrayList<>();
    int width = matrix[0].length;
    int height = matrix.length - 1;
    int totalCount = width * (height + 1);
    int sum = 0;  // 지나가는 숫자들의 개수의 합(누적치)

    // 시작점. 각 case마다 y(혹은 x)값을 변경하면서 시작하므로, y를 -1로 두고 시작한다.
    int x = 0;
    int y = -1;

    for (int i = 0; i < totalCount; i++) {
      if (sum >= totalCount)  // 모든 점을 다 방문했을 경우 멈춘다.
        break;

      switch (i % 4) {
        case 0: // rightward
          y++;
          int length = 0;
          while (length++ < width) {
            list.add(matrix[x][y++]);
            sum++;
          }
          y--;
          width--;
          break;
        case 1: // downward
          x++;
          length = 0;
          while (length++ < height) {
            list.add(matrix[x++][y]);
            sum++;
          }
          x--;
          height--;
          break;
        case 2: // leftward
          y--;
          length = 0;
          while (length++ < width) {
            list.add(matrix[x][y--]);
            sum++;
          }
          y++;
          width--;
          break;
        case 3: // upward
          x--;
          length = 0;
          while (length++ < height) {
            list.add(matrix[x--][y]);
            sum++;
          }
          x++;
          height--;
          break;
      }
    }

    return list;
  }

  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 }
    };
    System.out.println(spiralOrder(matrix));
  }
}
