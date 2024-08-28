package src.HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.*;
public class Main {
  public static void main(String[] args) {
    Map<Integer, Integer> map = new Map<>();
    List<Integer> list = new LinkedList<>();
    HashSet<Integer> set = new HashSet<>();
    
    map.insert(4, 6);
    map.insert(5, 10);
    map.insert(6, 12);
    map.insert(9, 70);
    map.insert(12, 59);

    try {
      System.out.println(map.get(4)); // Output: 6
      System.out.println(map.get(5)); // Output: 10
      System.out.println(map.get(6)); // Output: 12
      System.out.println(map.get(9)); // Output: 70
      System.out.println(map.get(12)); // Output: 59

      System.out.println(map.remove(4));
      System.out.println(map.get(4)); // Output: null
      System.out.println(map.remove(5));
      System.out.println(map.remove(9));
      System.out.println(map.remove(9));
      System.out.println(map.remove(9));

    } catch (HashMapIsEmptyException e) {
      // TODO: handle exception
    }
  }
}
