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
  private static int find1(String s) {
    StringBuilder sb = new StringBuilder(s);
    if (isPalindrome(sb)) {
      return sb.length();
    }

    int length = 0;
    int index = 0;
    StringBuilder tmp = new StringBuilder(sb);
    // 회문이 될 때까지 반복
    while (!isPalindrome(tmp)) {
      // index++번째부터 0번째까지의 순서로 글자를 tmp의 맨 뒤에 한 글자씩 붙인다
      tmp = new StringBuilder(sb);
      for (int i = index; i >= 0; i--) {
        // tmp의 i번째 글자를 tmp 맨 뒤에 붙임
        tmp.append(sb, i, i + 1);
      }
      index++;

      // 회문인지 확인
      if (isPalindrome(tmp)) {
        // 회문이면 tmp의 length를 return
        length = tmp.length();
      }
      // 회문이 아니면 증가된 index와 초기화된 tmp로 while문 다시 시작
    }

    return length;
  }

  /**
   * 기존 방법(find1)의 비효율성 : 단지 회문이 되는 최소길이만 구하면 되는데, 기존 방법은 회문 자체를 일일이 구하는 과정을 거친 뒤 그 회문의 길이를 리턴한다.
   * find2는 s의 마지막 index보다 1 큰 곳(=s.length)에서부터 i를 세기 시작하고, (i-1)번째 글자와 반대편에 있는 글자를 비교해 가면서 회문인지
   * 체크한다. (단 i-1은 s.length보다 작아야 함)
   */
  private static int find2(String s) {
    int len = s.length();
    for (int i = len; ; i++) {
      boolean flag = true;
      for (int j = 0; j < len; j++) {
        if ((i - 1 - j) < len && s.charAt(j) != s.charAt(i - 1 - j)) {
          flag = false;
          break;
        }
      }
      if (flag) {
        return i;
      }
    }
  }

  public static void main(String[] args) {
    String str = "abddgfhdyrbduoiasdfnuopavhgfdskljhklihlkbqulihsadg";
    long start1 = System.currentTimeMillis();
    System.out.println(find1(str));
    long end1 = System.currentTimeMillis();
    System.out.println("find1 실행시간: " + (end1 - start1) / 1000.0);

    long start2 = System.currentTimeMillis();
    System.out.println(find2(str));
    long end2 = System.currentTimeMillis();
    System.out.println("find2 실행시간: " + (end2 - start2) / 1000.0);
  }
}
