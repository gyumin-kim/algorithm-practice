package CtCI.chapter01.Q1_01_IsUnique;

import java.util.HashMap;
import java.util.Map;

/**
 * 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘을 작성하라.
 * 자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 또한 고민하라.
 */
class Question {

  /**
   * HashMap 활용. 책에는 나오지 않음(직접 구현)
   * 시간 복잡도: O(n) (HashMap의 탐색 시간은 O(1))
   */
  static boolean solution1(String s) {
    Map<Character, Character> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (map.get(c) != null)
        return false;
      map.put(c, c);
    }

    return true;
  }

  /**
   * i번째 문자가 존재하는지 여부를 뜻하는 boolean 배열을 활용하는 방법
   */
  static boolean solution2(String s) {
    int maxLength = 256;
    if (s.length() > maxLength) // unique하면서 길이가 256보다 긴 문자열을 만들 수는 없을 것이다.
      return false;

    boolean[] arr = new boolean[maxLength];
    int length = s.length();
    for (int i = 0; i < length; i++) {
      if (arr[s.charAt(i)]) return false;
      arr[s.charAt(i)] = true;
    }

    return true;
  }

  /**
   * 비트 벡터를 사용하는 방법.
   * s가 'a'부터 'z'까지만 존재한다고 가정
   * checker는 결국 1의 자리는 'a', 10의 자리는 'b'... 를 의미하는 것이다.
   * 해당 자리가 이미 1이라면 그 문자는 unique하지 않다고 판단한다.
   */
  static boolean solution3(String s) {
    int checker = 0;
    int length = s.length();
    for (int i = 0; i < length; i++) {
      int val = s.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0)
        return false;
      checker |= (1 << val);
    }

    return true;
  }
}

/*
 * < 힌트 >
 * 해시테이블을 사용해 보라
 * 비트 벡터가 유용한가?
 * O(NlogN) 시간에 풀 수 있겠는가? 그 해법은 어떤 것인가?
 */