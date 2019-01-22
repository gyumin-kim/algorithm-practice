package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    for (int i = 1; i <= 15; i++) { // 초기화
      answerList.add(i);
    }

    for (int i = 0; i < 4; i++) {  // 4번 반복 (카드 4개)
      if (answer.charAt(i) == 'N') {
        for (int j = 0; j < 8; j++) {
          answerList.remove(new Integer(cards[i][j]));
        }
      }
    }

    for (int num : answerList) {  // 5, 6, 7, 8, 13, 14, 15 중에 'Y'인 카드들에 공통인 수 찾기
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

  public static void main(String[] args) {
    System.out.println(theNumber("YNNN"));
  }
}
