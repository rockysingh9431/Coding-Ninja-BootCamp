package src.HashMap;

public class MapNode<K, V> {
  K key;
  V value;
  MapNode<K, V> next;

  public MapNode() {
    key = null;
    value = null;
    next = null;
  }

  public MapNode(K key, V value) {
    this.key = key;
    this.value = value;
    next = null;
  }
}
