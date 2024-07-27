package src.StackUsingLL;

public class Main {

  public static void main(String[] args) {
    StackLL<String> st = new StackLL<>();
    st.push("Hello");
    st.push("World");
    st.push("I am");
    st.push("Rocky");
    st.push("Singh");
    st.push("Future");
    st.push("IAS");
    System.out.println(st.peek()); // 2
    System.out.println(st.size());
    System.out.println(st.isEmpty()); // false
    // st.clear();
    // false
    while (!st.isEmpty()) {
      System.out.println(st.pop()); // 2, 1, 0, 3, 4, 5, 6
    }
    System.out.println(st.isEmpty()); // true
  }
  // push push an Element
  // peek gives last Element
  // pop pop last element and return it
  // isEmpty boolean if stack is empty
  // size size of the stack
  // clear clear stack;
}
