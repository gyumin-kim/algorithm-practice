package sample.KP2;

/**
 * @author Gyumin Kim
 * @since 2019-02-19
 */
public class Q5 {

  public static boolean solution(String str, String pattern) {
    int s = 0;
    int p = 0;
    int sPrev = 0;
    int pLength = pattern.length();
    int asterisk = -1;

    while (s < str.length()) {
      // str과 pattern이 동일한 문자이거나, pattern이 '?'면, 둘 다 1 증가
      if (p < pLength &&
          (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '?')) {
        s++;
        p++;
      }
      // '*'가 나오면 일단 pattern만 1 증가
      else if (p < pLength && pattern.charAt(p) == '*') {
        asterisk = p;  // 현재 pattern 위치를 저장
        sPrev = s;
        p++;
      }
      // 전에 '*'가 나왔으면 str을 증가
      else if (asterisk != -1) {
        s = ++sPrev;
        p = asterisk + 1;  // '*' 다음 위치로 세팅
      }
      // 현재 혹은 직전 모두 '*' 아님
      else return false;
    }

    // pattern에 남아있는 문자들
    while (p < pLength && pattern.charAt(p) == '*')
      p++;

    return p == pLength;
  }

  public static void main(String[] args) {
    System.out.println(solution("coding", "*ing"));
    System.out.println(solution("interview", "in*"));
    System.out.println(solution("apple", "app?e"));
    System.out.println(solution("vanilla", "vani?a"));
    System.out.println(solution("banana", "ba*na"));
    System.out.println(solution("fruits", "fru*its"));
    System.out.println(solution("Love", "Love*"));
    System.out.println(solution("Landvibe", "L*d?i*e"));
    System.out.println(solution("Landvibe", "Lan*?"));
  }
}
