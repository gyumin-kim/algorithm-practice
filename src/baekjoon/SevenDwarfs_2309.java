package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/2309 Lotto_6603_recursive의 아이디어를 활용하되, 모든 과정을 출력하는 것이 아니라 6개의 합이
 * 100일 때 출력하고 전체 프로그램을 중단한다. 보완할 점: base case일 때 print하고 바로 중단해야 한다(현재는 그 뒷부분도 모두 수행함).
 */
public class SevenDwarfs_2309 {

  private static final int TOTAL_DWARFS_COUNT = 9;
  private static final int ANSWER_DWARFS_COUNT = 7;

  public static void pick(int[] inputIntArr, List<Integer> pickedList, int leftCount, int start) {
    // base case
    if (leftCount == 0 && checkSum(pickedList)) {
      printList(pickedList);
      return;
    }

    for (int i = start; i < TOTAL_DWARFS_COUNT; i++) {
      pickedList.add(inputIntArr[i]);
      pick(inputIntArr, pickedList, leftCount - 1, (start++) + 1);
      pickedList.remove(pickedList.size() - 1);
    }
  }

  public static boolean checkSum(List<Integer> list) {
    int sum = 0;
    for (int num : list) {
      sum += num;
    }
    return sum == 100;
  }

  public static void printList(List<Integer> list) {
    for (int num : list) {
      System.out.println(num + " ");
    }
  }

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] inputIntArr = new int[TOTAL_DWARFS_COUNT];
    List<Integer> pickedlist = new ArrayList<>();

    // 아홉 난쟁이의 키를 입력 받는다.
    try {
      for (int i = 0; i < TOTAL_DWARFS_COUNT; i++) {
        inputIntArr[i] = Integer.parseInt(br.readLine());
      }
    } catch (IOException ie) {
      ie.printStackTrace();
    }

    Arrays.sort(inputIntArr);
    pick(inputIntArr, pickedlist, ANSWER_DWARFS_COUNT, 0);
  }
}