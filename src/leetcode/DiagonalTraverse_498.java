package leetcode;

/**
 * https://leetcode.com/problems/diagonal-traverse/
 */
public class DiagonalTraverse_498 {

  /**
   * 규칙성을 발견하기 위해 고민하다가, 'diagonal traverse'로 구글링했더니 youtube에 기본적인 idea가 잘 설명된 영상이 많았다.
   * 방향이 일정하게 우상향인 문제가 일반적인데, 이 문제는 우상향과 좌하향을 번갈아가면서 진행한다.
   * 그 부분은 각 case에 맞게 x, y 인덱스의 증감을 나눠주면 된다.
   */
  public static int[] findDiagonalOrder(int[][] matrix) {
    int m = matrix.length;
    if (m == 0) // 빈 배열이 들어오면 빈 배열을 return
      return new int[0];
    int n = matrix[0].length;
    int[] answer = new int[m*n];

    int x = 0;
    int y = 0;
    int index = 0;

    // (m + n - 1)번의 diagonal(대각선)을 반복한다
    for (int i = 0; i < m + n - 1; i++) {
      // i가 짝수일 때: 우상향
      if (i % 2 == 0) {
        answer[index++] = matrix[x][y];
        while (x > 0 && y < matrix[0].length-1) {
          x--;
          y++;
          answer[index++] = matrix[x][y];
        }
        // 우상향으로 끝까지 간 다음, 다음 loop의 좌하향을 시작하는 점을 한칸 오른쪽 / 한칸 아래쪽 중 어디로 할 것인지
        if (y != matrix[0].length-1)  y++;
        else x++;
      }
      // i가 홀수일 때: 좌하향
      else {
        answer[index++] = matrix[x][y];
        while (y > 0 && x < matrix.length-1) {
          x++;
          y--;
          answer[index++] = matrix[x][y];
        }
        // 좌하향으로 끝까지 간 다음, 다음 loop의 우상향을 시작하는 점을 한칸 아래쪽 / 한칸 오른쪽 중 어디로 할 것인지
        if (x != matrix.length-1)  x++;
        else y++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 2, 3, 4, 5 },
        { 6, 7, 8, 9, 10 },
        { 11, 12, 13, 14, 15 },
        { 16, 17, 18, 19, 20 },
        { 21, 22, 23, 24, 25 }
    };
    int[] answer = findDiagonalOrder(matrix);
    for (int num : answer) {
      System.out.print(num + " ");
    }
  }
}
