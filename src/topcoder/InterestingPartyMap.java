package topcoder;

import java.util.HashMap;
import java.util.Map;

public class InterestingPartyMap {

  private static int bestInvitation(String[] first, String[] second) {
    Map<String, Integer> dic = new HashMap<>();
    int length = first.length;

    // initialization
    for (int i = 0; i < length; i++) {
      dic.put(first[i], 0);
      dic.put(second[i], 0);
    }

    for (int i = 0; i < length; i++) {
      dic.put(first[i], dic.get(first[i]) + 1);
      dic.put(second[i], dic.get(second[i]) + 1);
    }

    int best = 0;
    for (int m : dic.values()) {
      if (m > best) {
        best = m;
      }
    }

    return best;
  }

  public static void main(String[] args) {
    String[] first = {"snakes", "programming", "cobra", "monty"};
    String[] second = {"python", "python", "anaconda", "python"};
    System.out.println(bestInvitation(first, second));
  }
}
