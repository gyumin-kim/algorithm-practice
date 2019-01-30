package leetcode.Q705_Design_HashSet;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {

  boolean[][] table;

  /**
   * Initialize your data structure here.
   */
  public MyHashSet() {
    table = new boolean[1000][1000];
  }

  public void add(int key) {
    int index = key % 1000;
    table[index][key/1000] = true;
  }

  public void remove(int key) {
    int index = key % 1000;
    table[index][key/1000] = false;
  }

  /**
   * Returns true if this set contains the specified element
   */
  public boolean contains(int key) {
    int index = key % 1000;
    return table[index][key/1000];
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj = new MyHashSet();
 * obj.add(key); obj.remove(key); boolean param_3 = obj.contains(key);
 */