package leetcode;

public class ImplementStrStr_28 {

  /**
   * 풀다가 테스트케이스 통과에 실패해 결국 포기.
   * @param haystack string to be scanned
   * @param needle   substring
   */
  public static int strStr(String haystack, String needle) {
    if (haystack.length() == 0 && needle.length() == 0) return 0;
    if (haystack.length() == 0 && needle.length() != 0) return -1;
    if (haystack.length() != 0 && needle.length() == 0) return 0;
    if (haystack.length() < needle.length())            return -1;
    if (haystack.length() == needle.length() && haystack.equals(needle))  return 0;

    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        int answer = i;
        int itmp = ++i;
        if (itmp >= haystack.length()) return -1;
        for (int j = 1; j < needle.length(); j++) {
          if (haystack.charAt(itmp) != needle.charAt(j)) {
            answer = -1;
            break;
          }
          itmp++;
          if (itmp >= haystack.length()) return -1;
        }
        if (answer != -1) return answer;
      }
    }

    return -1;
  }

  /**
   * 'Leetcode 50 COMMON INTERVIEW QUESTIONS'에서 제공한 solution
   */
  public static int strStr2(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        // 틀린 글자라면 이미 이전 loop에서 -1 리턴으로 끝났거나 다음 i로 넘어갔을 것.
        // j가 needle의 length와 같다는 것은 i를 리턴하면 된다는 뜻.
        if (j == needle.length()) return i;

        // needle의 모든 글자를 비교하기도 전에 haystack의 끝부분에 도달해버렸으므로 실패
        if (i + j >= haystack.length()) return -1;

        // haystack과 needle를 앞에서부터 한글자 씩 비교하는 부분. 다른 글자면 다음 i부터 새로 시작.
        if (haystack.charAt(i + j) != needle.charAt(j)) break;
      }
    }
  }

  public static void main(String[] args) {
    String haystack = "bbaa";
    String needle   = "aab";
    System.out.println(strStr2(haystack, needle));
  }
}