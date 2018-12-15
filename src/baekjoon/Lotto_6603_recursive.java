package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/6603 기존 Lotto_6603.java는 boolean 타입의 배열을 만들고 사용 여부를 매번 판단하는
 * 방식이었으나, 이번에는 재귀 함수를 사용하여 코드를 개선함. <프로그래밍 대회에서 배우는 알고리즘 문제 해결 전략> 06 무식하게 풀기 - 코드 6.2(149p)를 응용함.
 */
public class Lotto_6603_recursive {

  private static final int LOTTO_BALL_COUNT = 6;
  private static int n;

  public static void pick(int[] inputNums, List<Integer> pickedList, int start) {
    // base case
    if (pickedList.size() == LOTTO_BALL_COUNT) {
      printList(pickedList);
      return;
    }

    for (int i = start; i < n; i++) {
      pickedList.add(inputNums[i]);
      pick(inputNums, pickedList, (start++) + 1);
      pickedList.remove(pickedList.size() - 1);
    }
  }

  public static void printList(List<Integer> list) {
    for (int num : list) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    List<Integer> pickedList = new ArrayList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String[] inputIntegers = br.readLine().split(" ");
      n = Integer.parseInt(inputIntegers[0]);
      if (n == 0) {
        break;
      }

      int[] inputNums = new int[n];
      // n개의 수를 inputNums에 담는다.
      for (int i = 0; i < n; i++) {
        inputNums[i] = Integer.parseInt(inputIntegers[i + 1]);
      }

      pick(inputNums, pickedList, 0);
      System.out.println();
    }
    br.close();
  }
}
