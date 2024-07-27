package src.QueueusingLL;

public class Main {

  public static void main(String[] args) {
    // Queue<Integer> que = new LinkedList<>();
    Queue que = new Queue();
    que.enqueue(24);
    que.enqueue(14);
    que.enqueue(34);
    que.enqueue(44);
    que.enqueue(54);
    que.enqueue(64);
    que.enqueue(74);
    System.out.println(que.getSize());
    System.out.println(que.isEmpty());
    while (!que.isEmpty()) {
      System.out.println(que.dequeue());
    }
    System.out.println(que.isEmpty());
  }

}