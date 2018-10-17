package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 문제 해결의 아이디어 자체는 LIFO의 특성을 지니는 stack 개념을 적용하였으나,
 * Deque interface를 구현한 LinkedList를 Stack 대신 사용하였으며, 그 객체의 이름을 간단히 stack이라고 붙임.
 * 구현하는 과정에서는 Stack에서의 push, pop, peek 대신 LinkedList의 addLast, removeLast, peekLast를 사용함.
 */
public class parentheses_2504 {
    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();
        Scanner in = new Scanner(System.in);
//        String parenthesesString = in.next();

        String parenthesesString1 = "(()[[]])([])";
        String parenthesesString2 = "[[()[]]([])]";
        String parenthesesString3 = "([()[]])";
        String parenthesesString4 = "()";
        String parenthesesString5 = ")(";
        String parenthesesString6 = "3([])";

//        int result = getValue(stack, parenthesesString);
//        System.out.println(result);

        System.out.println(getValue(stack, parenthesesString1));
        System.out.println(getValue(stack, parenthesesString2));
        System.out.println(getValue(stack, parenthesesString3));
        System.out.println(getValue(stack, parenthesesString4));
        System.out.println(getValue(stack, parenthesesString5));
        System.out.println(getValue(stack, parenthesesString6));
    }

    public static int getValue(LinkedList<String> stack, String parenthesesString) {
        int stringLen = parenthesesString.length();
        int value = 0;

        // 0번째 문자가 숫자이거나 닫는 괄호일 경우 -> 올바른 괄호열이 아님 -> 예외처리
        char firstChar = parenthesesString.charAt(0);
        if (Character.isDigit(firstChar) || firstChar == ')' || firstChar == ']')
            return -1;

        // parenthesesString의 0번째부터 마지막 글자까지 반복한다
        for (int i = 0; i < stringLen; i++) {
            switch (parenthesesString.charAt(i)) {
                case '(':
                    stack.addLast("("); // push
                    break;
                case '[':
                    stack.addLast("["); // push
                    break;
                case ')':
                    // peek()한 결과가 "["
                    if (stack.peekLast().equals("["))
                        return -1;  // 올바른 괄호열이 아님 -> 예외처리
                    // peek()한 결과가 "("
                    else if (stack.peekLast().equals("(")) {
                        stack.removeLast();    // pop
                        stack.addLast("2"); // push
                    }
                    // peek()한 결과가 숫자
                    else if (Character.isDigit(stack.peekLast().charAt(0))) {
                        // ')' 다음에 숫자가 있고, 맨 밑까지 '('가 없는 경우 -> 올바른 괄호열이 아님 -> 예외처리
                        if (stack.size() < 2)
                            return -1;
                        else {
                            boolean isPaired = false;
                            for (int j = stack.size()-1; j >= 0; j--) {
                                if (stack.get(j).charAt(0) == '(') {
                                    isPaired = true;
                                    break;
                                }
                            }
                            if (!isPaired)  return -1;
                        }
                        int tmp = Integer.parseInt(stack.removeLast());
                        stack.removeLast();            // pop
                        stack.addLast(2*tmp + "");  // push
                    }
                    break;
                case ']':
                    // peek()한 결과가 "("
                    if (stack.peekLast().equals("("))
                        return -1;  // 올바른 괄호열이 아님 -> 예외처리
                    // peek()한 결과가 "["
                    else if (stack.peekLast().equals("[")) {
                        stack.removeLast();    // pop
                        stack.addLast("3"); // push
                    }
                    // peek()한 결과가 숫자
                    else if (Character.isDigit(stack.peekLast().charAt(0))) {
                        // ')' 다음에 숫자가 있고, 맨 밑까지 '('가 없는 경우 -> 올바른 괄호열이 아님 -> 예외처리
                        if (stack.size() < 2)
                            return -1;
                        else {
                            boolean isPaired = false;
                            for (int j = stack.size()-1; j >= 0; j--) {
                                if (stack.get(j).charAt(0) == '[') {
                                    isPaired = true;
                                    break;
                                }
                            }
                            if (!isPaired)  return -1;
                        }
                        int tmp = Integer.parseInt(stack.removeLast());
                        stack.removeLast();            // pop
                        stack.addLast(3*tmp + "");  // push
                    }
                    break;
            }

            // parenthesesString의 마지막까지 도달했는데 stack에 괄호가 남아있는 경우 -> 올바른 괄호열이 아님 -> 예외처리
            if (i == stringLen-1) {
                value = 0;
                while (stack.size() > 0) {
                    String last = stack.removeLast();
                    value += Integer.parseInt(last);
                    if (last.equals("[") || last.equals("]") || last.equals("(") || last.equals(")"))
                        return -1;
                }
            }

            int stackSize = stack.size();
            // stack size가 1보다 크고 && stack top과 그 앞의 수가 모두 숫자이면 -> 그 두 수를 더한 값을 push한다.
            if (stack.size() > 1 && Character.isDigit(stack.get(stackSize-1).charAt(0))  && Character.isDigit(stack.get(stackSize-2).charAt(0))) {
                int num = Integer.parseInt(stack.removeLast());
                num += Integer.parseInt(stack.removeLast());
                stack.addLast(num + "");
            }
        }

        // stack의 처음부터 끝까지 반복한다
        while (!stack.isEmpty())
            value += Integer.parseInt(stack.removeLast());

        return value;
    }
}
