package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/fizz-buzz/
 */
public class FizzBuzz_412 {

  /**
   * 가장 직관적인 방법
   */
  public List<String> fizzBuzz1(int n) {
    List<String> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0) {
        if (i % 5 == 0) {
          list.add("FizzBuzz");
        } else {
          list.add("Fizz");
        }
      } else {
        if (i % 5 == 0) {
          list.add("Buzz");
        } else {
          list.add(String.valueOf(i));
        }
      }
    }

    return list;
  }

  /**
   * String concatenation
   */
  public List<String> fizzBuzz2(int n) {
    List<String> list = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      String str = "";
      boolean divisibleBy3 = (i % 3 == 0);
      boolean divisibleBy5 = (i % 5 == 0);

      if (divisibleBy3)
        str += "Fizz";
      if (divisibleBy5)
        str += "Buzz";
      if (str.equals(""))
        str += Integer.toString(i);

      list.add(str);
    }

    return list;
  }

  /**
   * Hashing
   */
  public List<String> fizzBuzz3(int n) {
    List<String> list = new ArrayList<>();
    Map<Integer, String> map = new HashMap<>();
    map.put(3, "Fizz");
    map.put(5, "Buzz");

    for (int i = 1; i <= n; i++) {
      String str = "";
      for (int key : map.keySet()) {
        if (i % key == 0) {
          str += map.get(key);
        }
      }
      if (str.equals(""))
        str += Integer.toString(i);

      list.add(str);
    }

    return list;
  }
}
