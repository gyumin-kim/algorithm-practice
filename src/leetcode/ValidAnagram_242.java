package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram
 */
public class ValidAnagram_242 {

  public boolean isAnagramHashMap(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), 0);
      map.put(t.charAt(i), 0);
    }

    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
    }

    for (Character ch : map.keySet()) {
      if (map.get(ch) != 0) {
        return false;
      }
    }

    return true;
  }

  public boolean isAnagramSort(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    char[] schar = s.toCharArray();
    char[] tchar = t.toCharArray();
    Arrays.sort(schar);
    Arrays.sort(tchar);
    return Arrays.equals(schar, tchar);
  }

  public boolean isAnagramHashTable(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] counter = new int[26];

    // s와 t의 전체 문자를 반복하는 방법
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
      if (count != 0) {
        return false;
      }
    } //

//    // s를 먼저 돌고, t를 돌 때 0보다 작아지면 anagram이 아닌 것이 확실하므로 중단한다.
//    for (int i = 0; i < s.length(); i++) {
//      counter[s.charAt(i) - 'a']++;
//    }
//    for (int i = 0; i < t.length(); i++) {
//      counter[t.charAt(i) - 'a']--;
//      if (counter[t.charAt(i) - 'a'] < 0)
//        return false;
//    }

    return true;
  }

  public static void main(String[] args) {
    String s = "anagram";
    System.out.println(s.charAt(1) - 'a');
  }
}