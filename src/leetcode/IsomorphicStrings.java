package leetcode;

public class IsomorphicStrings {

  public static boolean isIsomorphic(String s, String t) {

    if (s.length() != t.length()) {
      return false;
    }

    int[] sarr = new int[256];
    int[] tarr = new int[256];

    for (int i = 0; i < s.length(); i++) {
      if (sarr[s.charAt(i)] != tarr[t.charAt(i)]) {
        return false;
      }
      sarr[s.charAt(i)] = i + 1;
      tarr[t.charAt(i)] = i + 1;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isIsomorphic("foo", "bar"));
  }
}
