package sample.ZI;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Gyumin Kim
 * @since 2019-02-18
 */
public class Q3 {

  public static int solution(String S) {
    Deque<Integer> stack = new ArrayDeque<>();

    String[] ops = S.split(" ");
    for (String op : ops) {
      if (isInteger(op)) {
        stack.push(Integer.parseInt(op));
      } else if (op.equals("POP")) {
        if (stack.size() < 1) return -1;
        stack.pop();
      } else if (op.equals("DUP")) {
        if (stack.size() < 1) return -1;
        stack.push(stack.peek());
      } else if (op.equals("+")) {
        if (stack.size() < 2) return -1;
        stack.push(stack.pop() + stack.pop());
      } else if (op.equals("-")) {
        if (stack.size() < 2) return -1;
        stack.push(stack.pop() - stack.pop());
      }
    }

    if (stack.size() < 1) return -1;
    return stack.pop();
  }

  public static boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
    } catch(NumberFormatException | NullPointerException e) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
//    int result = solution("13 DUP 4 POP 5 DUP + DUP + -");
//    int result = solution("5 6 + -");
    int result = solution("3 DUP 5 - -");
    System.out.println(result);
  }
}
