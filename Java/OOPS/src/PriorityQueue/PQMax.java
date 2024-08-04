package src.PriorityQueue;

import java.util.*;

public class PQMax {
  // Complete this class
  ArrayList<Integer> heap;

  public PQMax() {
    heap = new ArrayList<>();
  }

  boolean isEmpty() {
    // Implement the isEmpty() function here
    return heap.size() == 0;
  }

  int getSize() {
    // Implement the getSize() function here
    return heap.size();
  }

  int getMax() {
    // Implement the getMax() function here
    if (isEmpty())
      return (int) Double.POSITIVE_INFINITY;
    return heap.get(0);
  }

  void insert(int element) {
    // Implement the insert() function here
    heap.add(element);

    int CI = heap.size() - 1;
    int PI = (CI - 1) / 2;

    while (CI > 0) {
      if (heap.get(CI) > heap.get(PI)) {
        int temp = heap.get(CI);
        heap.set(CI, heap.get(PI));
        heap.set(PI, temp);
        CI = PI;
        PI = (CI - 1) / 2;
      } else {
        return;
      }
    }
  }

  int removeMax() {
    // Implement the removeMax() function here
    if (isEmpty())
      return (int) Double.POSITIVE_INFINITY;
    int ans = heap.get(0);

    heap.set(0, heap.get(heap.size() - 1));
    heap.remove(heap.size() - 1);

    int PI = 0;
    int LCI = 2 * PI + 1;
    int RCI = LCI + 1;

    while (LCI < heap.size()) {
      int maxInd = PI;
      if (heap.get(LCI) > heap.get(maxInd)) {
        maxInd = LCI;
      }
      if (RCI < heap.size() && heap.get(RCI) > heap.get(maxInd)) {
        maxInd = RCI;
      }
      if (maxInd == PI)
        break;
      int temp = heap.get(maxInd);
      heap.set(maxInd, heap.get(PI));
      heap.set(PI, temp);
      PI = maxInd;
      LCI = 2 * PI + 1;
      RCI = 2 * PI + 2;
    }
    return ans;
  }

  public void print() {
    for (int i : heap) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
