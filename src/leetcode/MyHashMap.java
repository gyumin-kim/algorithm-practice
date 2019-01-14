package leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MyHashMap {

  class Item {

    int key;
    int value;
    int hash;

    Item() {
    }

    Item(int key, int value, int hash) {
      this.key = key;
      this.value = value;
      this.hash = hash;
    }

    int getKey() {
      return this.key;
    }

    int getValue() {
      return this.value;
    }

    int gethash() {
      return this.hash;
    }

    void setKey(int key) {
      this.key = key;
    }

    void setvalue(int value) {
      this.value = value;
    }

    void sethash(int hash) {
      this.hash = hash;
    }
  }

  class Bucket {

    Item[] array = new Item[1000];

    Item getItem(int key) {
      int index = key / 1000;
      return array[index];
    }

    void setItem(int key, Item item) {
      int index = key / 1000;
      array[index] = item;
    }
  }

  private Bucket[] buckets;

  /**
   * Initialize your data structure here.
   */
  public MyHashMap() {
    buckets = new Bucket[1000];  // Array of buckets
  }

  /**
   * value will always be non-negative.
   */
  public void put(int key, int value) {
    int hash = key % 1000;
    Item item = new Item(key, value, hash);
    buckets[hash].setItem(key, item);
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    int hash = key % 1000;
    return buckets[hash].getItem(key).getValue();
  }

  /**
   * Removes the mapping of the specified value key if this map contains a mapping for the key
   */
  public void remove(int key) {
    int hash = key % 1000;
    buckets[hash].setItem(key, null);
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */