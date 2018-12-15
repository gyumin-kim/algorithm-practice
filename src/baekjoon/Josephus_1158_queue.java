package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/1158 queue의 개념을 활용한 풀이 앞에서 (n-1)개만큼 빼서 queue의 뒤에 붙인 뒤, 맨 앞의 요소를
 * 출력 요소가 전부 삭제될 때까지 반복 Josephus 문제 3개 풀이 중 가장 성능이 좋음
 */
public class Josephus_1158_queue {

  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] input = bf.readLine().split(" ");
    int m = Integer.parseInt(input[0]);
    int n = Integer.parseInt(input[1]);
    LinkedList<Integer> list = new LinkedList<>();

    // 1부터 m까지의 정수를 list에 저장
    for (int i = 1; i <= m; i++) {
      list.add(i);
    }

    System.out.print("<");
    // 요소를 삭제하면서 요소가 1개 남을 때까지 반복
    while (list.size() > 1) {
      // 맨 앞의 (n-1)개의 요소를 뒤로 붙임
      for (int i = 0; i < n - 1; i++) {
        list.addLast(list.removeFirst());
      }
      // 맨 앞의 요소를 출력하고 제거
      System.out.print(list.removeFirst() + ", ");
    }
    System.out.print(list.get(list.size() - 1));
    System.out.println(">");
  }
}
