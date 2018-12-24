package topcoder;

public class ThePalindrome {

  private static boolean isPalindrome(StringBuilder s) {
    boolean isPalindrome = true;
    int len = s.length();
    for (int i = 0; i < len / 2; i++) {
      if (s.charAt(i) != s.charAt(len - 1 - i)) {
        isPalindrome = false;
        break;
      }
    }

    return isPalindrome;
  }

  /**
   * 맨 첫글자를 맨 뒤에 붙이고 회문인지 검사하고, 회문이 아니면 앞에서 두번째 글자부터 순서대로 맨 뒤에 붙이고 다시 회문인지 검사 위의 과정을 회문이 될 때까지 반복 후,
   * 회문이 되었을 때 length를 return
   */
  private static int find(String s) {
    StringBuilder sb = new StringBuilder(s);
    if (isPalindrome(sb)) {
      return sb.length();
    }

    int length = 0;
    int index = 0;
    StringBuilder tmp = new StringBuilder(sb);
    // 회문이 될 때까지 반복
    while (!isPalindrome(tmp)) {
      // index++번째부터 0번째까지의 순서로 글자를 tmp의 맨 뒤에 한 글자씩 붙여서 tmp2에 넣는다
      tmp = new StringBuilder(sb);
      for (int i = index; i >= 0; i--) {
        // tmp의 i번째 글자를 tmp 맨 뒤에 붙임
        tmp.append(sb, i, i + 1);
      }
      index++;

      // 회문인지 확인
      if (isPalindrome(tmp)) {
        // 회문이면 tmp2의 length를 return
        length = tmp.length();
      }
      // 회문이 아니면 증가된 index와 초기화된 tmp2로 while문 다시 시작
    }

    return length;
  }

  public static void main(String[] args) {
    String str = "abdfhdyrbdbsdfghjkllkjhgfds";
    System.out.println(find(str));
  }
}
