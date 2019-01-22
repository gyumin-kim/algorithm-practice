package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://arena.topcoder.com/#/u/practiceCode/14394/14001/11129/2/306062
 */
public class NumberMagicEasy {

  private static final int[] card1 = {1, 2, 3, 4, 5, 6, 7, 8};
  private static final int[] card2 = {1, 2, 3, 4, 9, 10, 11, 12};
  private static final int[] card3 = {1, 2, 5, 6, 9, 10, 13, 14};
  private static final int[] card4 = {1, 3, 5, 7, 9, 11, 13, 15};

  /**
   * 가장 먼저 떠오른 단순한 방법.
   * System test는 pass했지만 너무 비효율적이고 어렵게 돌아가는 방법인 것 같다.
   */
  public static int theNumber(String answer) {
    int number = 16;

    int[][] cards = new int[4][8];
    cards[0] = card1;
    cards[1] = card2;
    cards[2] = card3;
    cards[3] = card4;

    List<Integer> answerList = new ArrayList<>(16);
    for (int i = 1; i <= 15; i++) { // 초기화 (1부터 15까지 전부 넣음)
      answerList.add(i);
    }

    for (int i = 0; i < 4; i++) {  // 4번 반복 (카드 4개)
      if (answer.charAt(i) == 'N') {  // 'N'이면 answerList에서 삭제함
        for (int j = 0; j < 8; j++) {
          answerList.remove(new Integer(cards[i][j]));
        }
      }
    }

    for (int num : answerList) {  // answerList에 남아 있는 수 중에, 'Y'인 카드들에 공통으로 존재하는 수 찾기
      boolean find = true;
      for (int i = 0; i < 4; i++) {
        if (answer.charAt(i) == 'Y') {
          for (int j = 0; j < 8; j++) {
            if (Arrays.binarySearch(cards[i], num) < 0) {
              find = false;
              break;
            }
          }
        }
      }
      if (find) {
        number = num;
      }
    }

    return number;
  }

  /**
   * 탑코더 책 첫번째 풀이.
   * 1부터 16까지의 수(i)를 순회하면서,
   * i가 card j에 포함되어 있는지의 여부를 판단하고, 그것이 answer.charAt(j)와 일치하는지 체크
   */
  public static int theNumber_solution1(String answer) {
    for (int i = 1; i <= 16; i++) {
      if (check(card1, i) != answer.charAt(0))  continue;
      if (check(card2, i) != answer.charAt(1))  continue;
      if (check(card3, i) != answer.charAt(2))  continue;
      if (check(card4, i) != answer.charAt(3))  continue;
      return i;
    }
    return 0;
  }

  /**
   * 배열에 number가 포함되어 있으면 'Y'를, 없으면 'N'을 리턴
   */
  public static char check(int[] arr, int number) {
    for (int num : arr) {
      if (num == number)
        return 'Y';
    }
    return 'N';
  }

  /**
   * card 정보를 길이가 4인 문자열 배열에 미리 저장해 놓고,
   * 각 요소의 i번째 character 조합이 answer와 동일한 경우 i+1을 리턴
   */
  public static int theNumber_solution2(String answer) {
    String[] c = {
        "YYYYYYYYNNNNNNNN",
        "YYYYNNNNYYYYNNNN",
        "YYNNYYNNYYNNYYNN",
        "YNYNYNYNYNYNYNYN"
    };

    for (int i = 0; i < 15; i++) {
      StringBuffer sb = new StringBuffer();
      for (int j = 0; j < 4; j++) {
        sb.append(c[j].charAt(i));
        if (answer.contentEquals(sb))
          return i + 1;
      }
    }
    return 0;
  }

  /**
   * solution2에서처럼 문자열 배열을 만들되, 수직방향으로 잘라 만든다. 길이는 16이 된다.
   * 문자열 배열 c의 i번째 요소와 answer가 같으면 i+1을 리턴
   * solution2와 거의 유사하지만 정답을 도출하는 아이디어가 좀 더 간단하다.
   */
  public static int theNumber_solution3(String answer) {
    String[] c = {
        "YYYY",
        "YYYN",
        "YYNY",
        "YYNN",
        "YNYY",
        "YNYN",
        "YNNY",
        "YNNN",
        "NYYY",
        "NYYN",
        "NYNY",
        "NYNN",
        "NNYY",
        "NNYN",
        "NNNY",
        "NNNN"
    };
    for (int i = 0; i < 16; i++) {
      if (c[i].equals(answer))
        return i+1;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(theNumber_solution3("YNNN"));
  }
}
