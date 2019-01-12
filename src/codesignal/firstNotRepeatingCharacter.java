package codesignal;

import java.util.ArrayList;
import java.util.List;

public class firstNotRepeatingCharacter {

  /**
   * My code (fail)
   */
  static char firstNotRepeatingCharacter(String s) {
    char answer = '_';
    String sorted = s.chars()
        .sorted()
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    System.out.println("sorted: " + sorted);

    int len = sorted.length();
    if (len == 1) {
      return s.toCharArray()[0];
    }
    List<String> list = new ArrayList<>();

    int start = 0;
    for (int i = 0; i < len - 1; i++) {
      if (sorted.charAt(i) != sorted.charAt(i + 1)) {
        String subString = sorted.substring(start, i + 1);
        list.add(subString);
        start = i + 1;
      }
    }
    list.add(sorted.substring(start, len));

    int listSize = list.size();
    for (int i = 0; i < listSize; i++) {
      if (list.get(i).length() == 1) {
        answer = list.get(i).toCharArray()[0];
        break;
      }
    }

    return answer;
  }

  /**
   * Solution by kishan_madhwani
   */
  static char firstNotRepeatingCharacter2(String s) {
    for (int i = 0; i < s.length(); i++) {
      // 해당 i번째 문자가 처음으로 나타나는 인덱스와 마지막 인덱스가 같은 경우, 그 문자는 s에서 하나밖에 없는 것!
      // indexOf: 매개변수로 들어온 char가 String에서 처음으로 나타나는 위치를 리턴한다
      if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
        return s.charAt(i);
      }
    }
    return '_';
  }

  public static void main(String[] args) {
    char c = firstNotRepeatingCharacter2("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof");
    System.out.println(c);
  }
}
