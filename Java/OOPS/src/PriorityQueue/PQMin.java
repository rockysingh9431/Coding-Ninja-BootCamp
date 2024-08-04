package src.PriorityQueue;

import java.util.ArrayList;

public class PQMin {

  private ArrayList<Integer> heap;

  public PQMin() {
    heap = new ArrayList<>();
  }

  boolean isEmpty() {
    return heap.size() == 0;
  }

  int size() {
    return heap.size();
  }

  int getMin() throws PriorityQueueException {
    if (isEmpty()) {
      // Throw an exception
      throw new PriorityQueueException();
    }
    return heap.get(0);
  }

  void insert(int element) {
    heap.add(element);
    int childIndex = heap.size() - 1;
    int parentIndex = (childIndex - 1) / 2;

    while (childIndex > 0) {
      if (heap.get(childIndex) < heap.get(parentIndex)) {
        int temp = heap.get(childIndex);
        heap.set(childIndex, heap.get(parentIndex));
        heap.set(parentIndex, temp);
        childIndex = parentIndex;
        parentIndex = (childIndex - 1) / 2;
      } else {
        return;
      }
    }
  }

  int removeMin() throws PriorityQueueException {
    // Complete this function
    // Throw the exception PriorityQueueException if queue is empty
    if (isEmpty()) {
      throw new PriorityQueueException();

    }

    int ans = heap.get(0);
    heap.set(0, heap.get(heap.size() - 1));
    heap.remove(heap.size() - 1);
    int PI = 0;
    int LCI = 2 * PI + 1;
    int RCI = LCI + 1; // or 2*PI+2;

    while (LCI < heap.size()) {
      int MI = PI;
      if (heap.get(LCI) < heap.get(MI)) {
        MI = LCI;
      }
      if (RCI < heap.size() && heap.get(RCI) < heap.get(MI)) {
        MI = RCI;
      }
      if (MI == PI)
        break;
      int ele = heap.get(MI);
      heap.set(MI, heap.get(PI));
      heap.set(PI, ele);
      PI = MI;
      LCI = 2 * PI + 1;
      RCI = LCI + 1;
    }
    return ans;
  }
}

class PriorityQueueException extends Exception {

}