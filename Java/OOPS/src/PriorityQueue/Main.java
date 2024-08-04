package src.PriorityQueue;

import java.io.IOException;
import java.util.Scanner;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) throws NumberFormatException, IOException {
    // System.out.println("MIN PRIORITY QUEUE");
    // PQMin pqMin = new PQMin();
    // int choice = sc.nextInt();

    // while (choice != -1) {
    // switch (choice) {
    // case 1: // insert

    // int element = sc.nextInt();
    // pqMin.insert(element);
    // break;
    // case 2: // getMin
    // try {
    // System.out.println(pqMin.getMin());
    // } catch (PriorityQueueException e) {
    // System.out.println(Integer.MIN_VALUE);
    // return;
    // }
    // break;
    // case 3: // removeMin
    // try {
    // System.out.println(pqMin.removeMin());
    // } catch (PriorityQueueException e) {
    // System.out.println(Integer.MIN_VALUE);
    // return;
    // }
    // break;
    // case 4: // size
    // System.out.println(pqMin.size());
    // break;
    // case 5: // isEmpty
    // System.out.println(pqMin.isEmpty());
    // default:
    // return;
    // }
    // choice = sc.nextInt();
    // }

    System.out.println("MAX PRIORITY QUEUE");
    PQMax pqMax = new PQMax();
    int choice = sc.nextInt();
    while (choice != -1) {
      switch (choice) {
        case 1: // insert
          int element = sc.nextInt();
          pqMax.insert(element);
          pqMax.print();
          break;
        case 2: // getMax
          System.out.println(pqMax.getMax());
          break;
        case 3: // removeMax
          System.out.println(pqMax.removeMax());
          // pqMax.print();
          break;
        case 4: // size
          System.out.println(pqMax.getSize());
          break;
        case 5: // isEmpty
          System.out.println(pqMax.isEmpty());
        default:
          return;
      }
      // choice = Integer.parseInt(st.nextToken());
      choice = sc.nextInt();
    }
    pqMax.print();
  }

}