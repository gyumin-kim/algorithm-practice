package interviewcake.ch01_Array_and_string_manipulation.ReverseWords;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * @author Gyumin Kim
 * @since 2019-04-01
 */
public class Solution {

  public static void reverseWords(char[] message) {

    int left = 0;
    int right = message.length - 1;

    // decode the message by reversing the words
    while (left < right) {
      StringBuilder leftSb = new StringBuilder();
      StringBuilder rightSb = new StringBuilder();

      while (message[left] != ' ') {
        leftSb.append(message[left]);
        left++;
      }
      while (message[right] != ' ') {
        rightSb.append(message[right]);
        right--;
      }
      for (char c : leftSb.toString().toCharArray()) {

      }
    }

  }


















  // tests

  @Test
  public void oneWordTest() {
    final char[] expected = "vault".toCharArray();
    final char[] actual = "vault".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void twoWordsTest() {
    final char[] expected = "cake thief".toCharArray();
    final char[] actual = "thief cake".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void threeWordsTest() {
    final char[] expected = "get another one".toCharArray();
    final char[] actual = "one another get".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void multipleWordsSameLengthTest() {
    final char[] expected = "the cat ate the rat".toCharArray();
    final char[] actual = "rat the ate cat the".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void multipleWordsDifferentLengthsTest() {
    final char[] expected = "chocolate bundt cake is yummy".toCharArray();
    final char[] actual = "yummy is cake bundt chocolate".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void emptyStringTest() {
    final char[] expected = "".toCharArray();
    final char[] actual = "".toCharArray();
    reverseWords(actual);
    assertArrayEquals(expected, actual);
  }

  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(Solution.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
    if (result.wasSuccessful()) {
      System.out.println("All tests passed.");
    }
  }
}