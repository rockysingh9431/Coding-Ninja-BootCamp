package src.StackUsingLL;

class Node<T> {
  Node<T> next;
  T data;

  Node(T data) {
    this.data = data;
    this.next = null;
  }
}

public class StackLL<T> {
  Node<T> head;
  Node<T> tail;
  int size;

  StackLL() {
    this.head = null;
    this.tail = null;
    size = 0;
  }

  public void push(T data) {
    Node<T> newNode = new Node<>(data);
    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return tail.data;
  }

  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    int len = 0;

    Node<T> temp = head;
    while (len < size - 2) {
      temp = temp.next;
      len++;
    }
    T ans = tail.data;
    temp.next = null;
    tail = temp;
    size--;
    return ans;
  }

  public int size() {
    return size;
  }

  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }
}
// push push an Element
// peek gives last Element
// pop pop last element and return it
// isEmpty boolean if stack is empty
// size size of the stack
// clear clear stack;