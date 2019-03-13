package programmers.recruitment;

/**
 * @author Gyumin Kim
 * @since 2019-03-13
 */
public class Q1 {

  public int[] solution(int day, int k) {
    int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    int[] days = new int[12]; // 달별로 요일 저장
    int[] answer = new int[12]; // 정답

    for (int i = 0; i < 12; i++) {
      int dayCheck; // 무슨 요일인지
      if (i == 0) {
        dayCheck = (k - 1+day) % 7;
      } else {
        dayCheck = (month[i] + days[i - 1]) % 7;
      }

      days[i] = dayCheck;

      if (dayCheck == 6 || dayCheck == 5)
        answer[i] = 1;
      else
        answer[i] = 0;
    }
    return answer;
  }
}
