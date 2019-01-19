package CtCI.chapter01.Q1_01_IsUnique;

public class Tester {

  public static void main(String[] args) {
    String[] words = {"abcde", "hello", "apple", "kite", "padle"};

    System.out.println("solution1");
    for (String word : words) {
      System.out.println(word + ": " + Question.solution1(word));
    }
    System.out.println("\nsolution2");
    for (String word : words) {
      System.out.println(word + ": " + Question.solution2(word));
    }
    System.out.println("\nsolution3");
    for (String word : words) {
      System.out.println(word + ": " + Question.solution3(word));
    }
  }
}
