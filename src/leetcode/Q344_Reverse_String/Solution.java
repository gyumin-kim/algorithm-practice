package leetcode.Q344_Reverse_String;

public class Solution {

  /**
   * 가장 먼저 생각한 방법. 결과에는 문제가 없으나 library(StringBuilder)로부터 유발되는 overhead로 인해 속도가 약간 느리다. 그냥
   * sb.reverse().toString()을 해도 된다.
   */
  public String reverseString(String s) {
    StringBuilder sb = new StringBuilder();
    int length = s.length();
    for (int i = length - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }

    return sb.toString();
  }

  /**
   * s의 맨 앞과 맨 뒤 인덱스의 문자를 맞바꾸면서 인덱스를 가운데 방향으로 이동해 나가는 방식.
   * 속도가 가장 빠르다.
   */
  public String reverseString2(String s) {
    char[] arr = s.toCharArray();
    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      char tmp = arr[j];
      arr[j] = arr[i];
      arr[i] = tmp;
      i++;
      j--;
    }

    return new String(arr);
  }

  /**
   * Divide and conquer (Recursive)
   */
  public String reverseString3(String s) {
    int length = s.length();
    if (length <= 1) {
      return s;
    }

    String leftStr = s.substring(0, length / 2);
    String rightStr = s.substring(length / 2, length);

    return reverseString3(rightStr).concat(reverseString3(leftStr));
  }
}
