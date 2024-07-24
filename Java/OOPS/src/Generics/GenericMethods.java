package src.Generics;

public class GenericMethods {
  public static <T> void printArray(T arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Integer arr[] = new Integer[5];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i + 1;
    }
    printArray(arr);

    String arr2[] = new String[5];
    for (int i = 0; i < arr2.length; i++) {
      arr2[i] = "abc";
    }
    printArray(arr2);
  }
}
