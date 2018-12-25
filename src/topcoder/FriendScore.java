package topcoder;

public class FriendScore {

  /**
   * 1번째 시도 : i번째 사람이 누군가와 친구이면 count 1 증가하고, 그 친구의 친구들 중 i가 아닌 사람들의 인원 수만큼 더 증가시킨다.
   */
  private static int highestScore1(String[] friends) {
    int highest = 0;
    int head = friends[0].length();
    for (int i = 0; i < head; i++) {
      int count = 0;

      for (int j = 0; j < head; j++) {
        if (friends[i].charAt(j) == 'Y') {
          count++;
          for (int k = 0; k < head; k++) {
            if (k != i && friends[j].charAt(k) == 'Y') {
              count++;
            }
          }
        }
      }

      highest = Math.max(count, highest);
    }

    return highest;
  }

  /**
   * 2번째 시도 : 'Y'가 아닐 경우 else절에서 따로 진행되는데, 자기 자신은 항상 'N'이므로, 2nd loop을 시작할 때 자기 자신인지 검사해야 한다. 1번은 3중
   * for문을 끝까지 진행하지만, 2번은 3번째 for문 내에서 break하는 조건이 있으므로 성능이 약간 더 좋다.
   */
  private static int highestScore2(String[] friends) {
    int highest = 0;
    int head = friends[0].length();
    for (int i = 0; i < head; i++) {
      int count = 0;

      for (int j = 0; j < head; j++) {
        if (i == j) {
          continue;
        }
        if (friends[i].charAt(j) == 'Y') {
          count++;
        }
        // j와는 친구가 아니다. 하지만, j의 친구 중에 i와 친구인 사람을 찾으면 count++
        else {
          for (int k = 0; k < head; k++) {
            if (friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y') {
              count++;
              break;
            }
          }
        }
      }

      highest = Math.max(count, highest);
    }

    return highest;
  }

  public static void main(String[] args) {
    String[] friends = {"NNNNYNNNNN",
        "NNNNYNYYNN",
        "NNNYYYNNNN",
        "NNYNNNNNNN",
        "YYYNNNNNNY",
        "NNYNNNNNYN",
        "NYNNNNNYNN",
        "NYNNNNYNNN",
        "NNNNNYNNNN",
        "NNNNYNNNNN"};

    long start1 = System.currentTimeMillis();
    System.out.println(highestScore1(friends));
    long end1 = System.currentTimeMillis();
    System.out.println("highestScore1 실행시간: " + (end1 - start1) / 100000.0);

    long start2 = System.currentTimeMillis();
    System.out.println(highestScore2(friends));
    long end2 = System.currentTimeMillis();
    System.out.println("highestScore2 실행시간: " + (end2 - start2) / 100000.0);
  }
}
