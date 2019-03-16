package programmers.woowabros;

/**
 * @author Gyumin Kim
 * @since 2019-03-16
 */
public class Q1 {

  public static int[] solution(int money) {
    int[] answer = new int[9];

    while (money >= 50000) {
      answer[0]++;
      money -= 50000;
    }
    while (money >= 10000) {
      answer[1]++;
      money -= 10000;
    }
    while (money >= 5000) {
      answer[2]++;
      money -= 5000;
    }
    while (money >= 1000) {
      answer[3]++;
      money -= 1000;
    }
    while (money >= 500) {
      answer[4]++;
      money -= 500;
    }
    while (money >= 100) {
      answer[5]++;
      money -= 100;
    }
    while (money >= 50) {
      answer[6]++;
      money -= 50;
    }
    while (money >= 10) {
      answer[7]++;
      money -= 10;
    }
    answer[8] = money;

    return answer;
  }

  public static void main(String[] args) {
    int[] answer = solution(15000);
    for (int num : answer) {
      System.out.println(num);
    }
  }
}
