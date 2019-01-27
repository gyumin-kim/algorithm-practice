package programmers.mockTest2th_20190126;

import java.util.Arrays;

public class Test1 {

  /**
   * 배열의 회전이란 모든 원소를 오른쪽으로 한 칸씩 이동시키고, 마지막 원소는 배열의 맨 앞에 넣는 것을 말합니다.
   * 두 배열 arrA와 arrB가 매개변수로 주어질 때,
   * arrA를 회전해 arrB로 만들 수 있으면 true를, 그렇지 않으면 false를 return 하는 solution 함수를 작성해주세요.
   *
   * [7, 8, 10] / [10, 7, 8]      -->  true
   * [4, 3, 2, 1] / [5, 4, 1, 2]  -->  false
   */
  public static boolean solution(int[] arrA, int[] arrB) {
    int aLength = arrA.length;
    int bLength = arrB.length;
    if (aLength != bLength)
      return false;

    for (int i = 0; i < aLength; i++) {
      if (Arrays.equals(arrA, arrB))
        return true;
      rotate(arrA);
    }

    return false;
  }

  /**
   * 맨 마지막 요소 1개를 맨 앞으로 옮기고, 나머지 요소는 오른쪽으로 한 칸씩 움직이는 메소드
   */
  public static int[] rotate(int[] arr) {
    int tmp = arr[arr.length-1];  // 맨 마지막 요소
    if (arr.length - 1 >= 0)
      // System.arraycopy 메소드 잘 활용하자!
      System.arraycopy(arr, 0, arr, 1, arr.length - 1);
    arr[0] = tmp;
    return arr;
  }

  public static void main(String[] args) {
    int[] arrA = { 4, 3, 2, 1 };
    int[] arrB = { 5, 4, 1, 2 };
    System.out.println(solution(arrA, arrB));
  }
}
