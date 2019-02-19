//package sample.ZI;
//
///**
// * @author Gyumin Kim
// * @since 2019-02-18
// */
//public class Q4 {
//
//  private int[] dr = { -1, 0, 1, 0 };
//  private int[] dc = { 0, 1, 0, -1 };
//  private int max = 0;
//
//  public int solution(int[][] board) {
//    int N = board.length;
//    int M = board[0].length;
//
//    for (int i = 0; i < N; i++) {
//      for (int j = 0; j < M; j++) {
//        boolean[][] isMarked = new boolean[N][M];
//        findLargestPath(i, j, N, M, board, isMarked);
//      }
//    }
//    return max;
//  }
//
//  public void findLargestPath(int r, int c, int N, int M, int[][] board, boolean[][] isMarked) {
//    int sum = 0;
//    boolean possible = true;
//    while (possible && ) {
//      int dirMax = 0;
//      for (int k = 0; k < 4; k++) {
//        if (r + dr[k] >= 0 && r + dr[k] < N && c + dc[k] >= 0 && dc[k] < M
//            && !isMarked[r + dr[k]][c + dc[k]]) {
//          if (board[r + dr[k]][c + dc[k]] > dirMax)
//            dirMax = board[r + dr[k]][c + dc[k]];
//        }
//      }
//    }
//  }
//}