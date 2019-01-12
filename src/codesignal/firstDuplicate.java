package codesignal;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * https://app.codesignal.com/interview-practice/task/pMvymcahZ8dY4g75q
 */
public class firstDuplicate {

  int firstDuplicate(int[] a) {
    int length = a.length;
    Set<Integer> set = new LinkedHashSet<>();
    int answer = -1;
    for (int i = 0; i < length; i++) {
      if (set.contains(a[i])) {
        answer = a[i];
        break;
      } else {
        set.add(a[i]);
      }
    }

    return answer;
  }

  public static void main(String[] args) {

  }
}
