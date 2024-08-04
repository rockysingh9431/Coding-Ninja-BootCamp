package src.HashMap;

import java.util.ArrayList;

class HashMapIsEmptyException extends Exception {
}

public class Map<K, V> {
  ArrayList<MapNode<K, V>> buckets;
  int numBuckets;
  int size;

  public Map() {
    buckets = new ArrayList<>();
    this.numBuckets = 10;
    for (int i = 0; i < numBuckets; i++) {
      buckets.add(null);
    }
  }

  public int getSize() {
    return buckets.size();
  }

  public double loadFactor() {
    return numBuckets / size;
  }

  public boolean isEmpty() {
    return buckets.size() == 0;
  }

  private int getBuckets(K key) {
    return key.hashCode() % numBuckets;
  }

  private void reHash() {
    ArrayList<MapNode<K, V>> tempBucket = buckets;
    numBuckets *= 2;
    for (int i = 0; i < numBuckets; i++) {
      buckets.add(null);
    }

    for (int i = 0; i < tempBucket.size(); i++) {
      MapNode<K, V> tempNode = tempBucket.get(i);
      while (tempNode != null) {
        insert(tempNode.key, tempNode.value);
        tempNode = tempNode.next;
      }
    }
  }

  public void insert(K key, V value) {
    int index = getBuckets(key);
    MapNode<K, V> head = buckets.get(index);

    while (head != null) {
      if (head.key == key) {
        head.value = value;
        return;
      }
      head = head.next;
    }
    head = buckets.get(index);
    MapNode<K, V> newNode = new MapNode<>(key, value);
    newNode.next = head;
    head = newNode;
    buckets.set(index, head);
    size++;
    if (numBuckets / size > 0.7) {
      reHash();
    }
  }

  public V remove(K key) throws HashMapIsEmptyException {
    if (isEmpty()) {
      throw new HashMapIsEmptyException();
    }
    int index = getBuckets(key);
    MapNode<K, V> head = buckets.get(index);
    MapNode<K, V> prev = null;
    V ans = null;
    while (head != null) {
      if (head.key.equals(key)) {
        if (prev == null) {
          buckets.set(index, head.next);
        } else {
          prev.next = head.next;
        }
        ans = head.value;
      }
      prev = head;
      head = head.next;
    }
    return ans;
  }

  public V get(K key) throws HashMapIsEmptyException {
    if (isEmpty()) {
      throw new HashMapIsEmptyException();
    }
    int index = getBuckets(key);
    MapNode<K, V> head = buckets.get(index);

    while (head != null) {
      if (head.key.equals(key)) {
        return head.value;
      }
      head = head.next;
    }
    return null;
  }
}

// getSize
// isEmpty
// insert
// remove
// get