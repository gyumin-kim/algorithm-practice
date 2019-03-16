package programmers.woowabros;

/**
 * @author Gyumin Kim
 * @since 2019-03-16
 */
public class Q3 {

  public static String solution(String word) {
    StringBuilder sb = new StringBuilder();
    char[] upper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    char[] lower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    for (int i = 0; i < word.length(); i++) {
      int num = (int) word.charAt(i);
      if (num < 97) { // uppercase
        sb.append(lower[25 - (num - 65)]);
      } else {        // lowercase
        sb.append(upper[25 - (num - 97)]);
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String word = "AaZzYy";
    String rev = solution(word);
    System.out.println(rev);
  }
}
