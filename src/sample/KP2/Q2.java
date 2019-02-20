package sample.KP2;

/**
 * @author Gyumin Kim
 * @since 2019-02-19
 */
public class Q2 {

  public static int solution(String line) {
    int totalLength = line.length();
    int index = 0;
    char prev = line.charAt(0);
    for (int i = 0; i < totalLength; i++) {
      if (line.charAt(i) != prev) {
        index = i;
        break;
      }
      prev = line.charAt(i);
    }
    int left = index;

    float answer = (float)left / (float)totalLength * 100;
    return (int)answer;
  }

  public static void main(String[] args) {
    System.out.println(solution("0....."));
  }
}
