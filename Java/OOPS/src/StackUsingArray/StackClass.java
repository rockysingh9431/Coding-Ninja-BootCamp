package src.StackUsingArray;

public class StackClass<T> {
  private T arr[];
  private int lastIndex;
  private int capacity;

  @SuppressWarnings("unchecked")
  StackClass() {
    arr = (T[]) new Object[10];
    capacity = 10;
  }

  @SuppressWarnings("unchecked")
  StackClass(int size) {
    arr = (T[]) new Object[size];
    capacity = size;
  }

  public void push(T element) {
    if (lastIndex >= capacity) {
      doubleArraySize();
    }
    arr[lastIndex] = element;
    lastIndex++;
  }

  private void doubleArraySize() {
    @SuppressWarnings("unchecked")
    T[] newArr = (T[]) new Object[capacity * 2];
    System.arraycopy(arr, 0, newArr, 0, capacity);
    arr = newArr;
    capacity *= 2;
  }

  public T peek() {
    if (lastIndex < 0) {
      throw new IllegalStateException("Stack is empty");
    }
    return arr[lastIndex - 1];
  }

  public T pop() {
    if (lastIndex < 0) {
      throw new IllegalStateException("Stack is empty");
    }
    T ret = arr[lastIndex - 1];
    lastIndex--;
    return ret;
  }

  public boolean isEmpty() {
    return lastIndex == 0;
  }

  public int size() {
    return lastIndex;
  }

  public void clear() {
    lastIndex = 0;
  }
}
// push push an Element
// peek gives last Element
// pop pop last element and return it
// isEmpty boolean if stack is empty
// size size of the stack
// clear clear stack;