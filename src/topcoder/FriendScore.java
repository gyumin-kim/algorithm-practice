package topcoder;

public class FriendScore {

  /**
   * 1번째 시도 : i번째 사람이 누군가와 친구이면 count 1 증가하고, 그 친구의 친구들 중 i가 아닌 사람들의 인원 수만큼 더 증가시킨다.
   */
  private static int highestScore(String[] friends) {
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
    System.out.println(highestScore(friends));
  }
}
