package src.DynamicArray;

public class DynamicArrayClassUse {
   public static void main(String[] args) {
    DynamicArray arr=new DynamicArray(5);
    System.out.println(arr.isEmpty());
    for(int i=0;i<5;i++){
      arr.add(i+1);
    }
    System.out.println(arr.size());
    System.out.println(arr.get(2));
    arr.printArray();
    arr.set(2,7);
    arr.printArray();
    arr.addAtIndex(3, 10);
    arr.printArray();
    arr.remove(3);
    arr.printArray();
    arr.removeLast();
    arr.printArray();
    System.out.println(arr.isEmpty());
  } 
}
