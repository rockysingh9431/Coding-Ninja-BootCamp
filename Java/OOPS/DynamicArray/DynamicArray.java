package DynamicArray;

public class DynamicArray {
  private int arr[];
  private int lastIndex;
  DynamicArray(int size){
    arr = new int[size];
  }
  DynamicArray(){
    arr = new int[5];
  }
  public int size(){
    return lastIndex;
  }

  public boolean isEmpty(){
    return lastIndex==0;
  }

  public int get(int index){
    return arr[index];
  }
  
  public void set(int index,int element){
    arr[index]=element;
  }

  public void add(int element){
    if(lastIndex>=arr.length){
      doubleArraysize();
    }
    arr[lastIndex]=element;
    lastIndex++;
  }

  private void doubleArraysize(){
    int newSize=arr.length*2;
    int newArr[]=arr;
    arr=new int[newSize];

    for(int i=0;i<newArr.length;i++){
      arr[i]=newArr[i];
    }
  }

  public void removeLast(){
    if(lastIndex>0){
      arr[lastIndex-1]=0;
      lastIndex--;
    }else{
      throw new IndexOutOfBoundsException("Array is already empty");
    }
  }
  public void remove(int index){
    if(lastIndex>=index){
      for(int i=index;i<lastIndex;i++){
        arr[i]=arr[i+1];
      }
      arr[lastIndex]=0;
      lastIndex--;
    }else{
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
  }

  public void addAtIndex(int index,int element){
    if(index>lastIndex){
      throw new Error("Cannot insert element at index greater than the ArraySize");
    }else if(index==lastIndex){
      add(element);
    }else{
      if(lastIndex==arr.length){
        doubleArraysize();
      }
      for(int i=lastIndex;i>index;i--){
        arr[i]=arr[i-1];
      }
      arr[index]=element;

      lastIndex++;
    }
  }

  public void printArray(){
    for(int i=0;i<lastIndex;i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }
}
