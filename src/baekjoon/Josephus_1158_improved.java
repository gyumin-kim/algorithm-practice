package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * https://www.acmicpc.net/problem/1158 LinkedList의 메소드를 활용하는 풀이 백준 제출 결과 시간 초과됨.
 */
public class Josephus_1158_improved {

  static void printAnswer(List<Integer> list, int m, int n) {

    System.out.print("<");
    int index = 0;
    for (int i = 0; i < m - 1; i++) {
      for (int j = 0; j < n - 1; j++) {
        try {
          index = list.indexOf(list.listIterator(++index).next());
        } catch (NoSuchElementException ex) {
          index = 0;
        }
      }
      System.out.print(list.get(index) + ", ");
      list.remove(index);
      if (index >= list.size()) {
        index = 0;
      }
    }
    System.out.print(list.get(list.size() - 1));
    System.out.println(">");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] input = bf.readLine().split(" ");
    int m = Integer.parseInt(input[0]);
    int n = Integer.parseInt(input[1]);
    List<Integer> list = new LinkedList<>();

    // 1부터 m까지의 정수를 list에 저장
    for (int i = 1; i <= m; i++) {
      list.add(i);
    }

    printAnswer(list, m, n);
  }
}
