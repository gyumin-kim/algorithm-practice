package leetcode;

/**
 *
 */
public class ImplementStrStr_28 {

  public static int strStr(String haystack, String needle) {
    if (needle.length() == 0)
      return 0;
    if (haystack.length() < needle.length())
      return -1;

    int index = -1;

    int i = 0;
    while (i < haystack.length()) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        index = i;
        for (int j = 1; j < needle.length(); j++) {
          if (haystack.charAt(++i) != needle.charAt(j)) {
            i--;
            index = -1;
            break;
          }
        }
        if (index != -1)
          return index;
      }
      i++;
    }

    return index;
  }

  public static void main(String[] args) {
    String haystack = "helloworld";
    String needle = "lloe";
    System.out.println(strStr(haystack, needle));
  }
}
