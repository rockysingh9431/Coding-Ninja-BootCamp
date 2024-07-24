package src.Generics;

public class Main {
  public static void main(String[] args) {
    Pair<Pair<Integer, Integer>, String> p1 = new Pair<>(new Pair<>(3, 4), "Rocky Singh");
    System.out.println(p1.getFirst().getFirst());
    System.out.println(p1.getFirst().getSecond());
    System.out.println(p1.getSecond());
    p1.print();
  }
}