package interviewcake.ch01_Array_and_string_manipulation.ReverseStringInPlace;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * @author Gyumin Kim
 * @since 2019-04-01
 *
 * Write a method that takes an array of characters and reverses the letters in place.
 */
public class Solution {

  public static void reverse(char[] arrayOfChars) {

    int length = arrayOfChars.length;

    // reverse input array of characters in place
    for (int i = 0; i < length/2; i++) {
      char tmp = arrayOfChars[i];
      arrayOfChars[i] = arrayOfChars[length-i-1];
      arrayOfChars[length-i-1] = tmp;
    }
  }


















  // tests

  @Test
  public void emptyStringTest() {
    final char[] actual = "".toCharArray();
    reverse(actual);
    final char[] expected = "".toCharArray();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void singleCharacterStringTest() {
    final char[] actual = "A".toCharArray();
    reverse(actual);
    final char[] expected = "A".toCharArray();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void longerStringTest() {
    final char[] actual = "ABCDE".toCharArray();
    reverse(actual);
    final char[] expected = "EDCBA".toCharArray();
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