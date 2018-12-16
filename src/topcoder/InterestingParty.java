package topcoder;

import java.util.Stack;

public class InterestingParty {

  static int bestInvitation(String[] first, String[] second) {
    Stack<String> stack = new Stack<>();
    int best = 1;
    int length = first.length;

    for (int i = 0; i < length; i++) {
      String firstInterest = first[i];
      // 이미 체크했던 요소는 스킵, 처음 체크하는 요소는 스택에 푸시하고 체크
      if (!stack.contains(firstInterest)) {
        stack.push(firstInterest);
        int tmp = 0;

        for (int j = 0; j < length; j++) {
          if (firstInterest.equals(first[j]) || firstInterest.equals(second[j])) {
            tmp++;
          }
        }
        if (tmp > best) {
          best = tmp;
        }
      }

      String secondInterest = second[i];
      if (!stack.contains(secondInterest)) {
        stack.push(secondInterest);
        int tmp = 0;

        for (int j = 0; j < length; j++) {
          if (secondInterest.equals(first[j]) || secondInterest.equals(second[j])) {
            tmp++;
          }
        }
        if (tmp > best) {
          best = tmp;
        }
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
