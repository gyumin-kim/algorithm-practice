package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {

  ArrayList[] table;
  final int MODULAR = 97;

  /**
   * Initialize your data structure here.
   */
  public MyHashSet() {
    int length = MODULAR;
    table = new ArrayList[length];

    for (int i = 0; i < length; i++) {
      table[i] = new ArrayList<>();
    }
  }

  public void add(int key) {
    int index = key % MODULAR;
    table[index].add(key);
    List<>
  }

  public void remove(int key) {
    int index = key % MODULAR;
    table[index].remove(key);
  }

  /**
   * Returns true if this set contains the specified element
   */
  public boolean contains(int key) {
    int index = key % MODULAR;
    return table[index].contains(key);
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj = new MyHashSet();
 * obj.add(key); obj.remove(key); boolean param_3 = obj.contains(key);
 */
