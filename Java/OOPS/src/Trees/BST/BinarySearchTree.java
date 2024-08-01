
// Binary Tree Node class

class BinaryTreeNode<T> {
  T data;
  BinaryTreeNode<T> left;
  BinaryTreeNode<T> right;

  public BinaryTreeNode(T data) {
    this.data = data;
  }
}

public class BinarySearchTree {
  BinaryTreeNode<Integer> root;

  private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
    if (root == null) {
      root = new BinaryTreeNode<>(data);
      return root;
    }

    if (root.data >= data) {
      root.left = insert(root.left, data);
    } else {
      root.right = insert(root.right, data);
    }
    return root;
  }

  public void insert(int data) {
    // Implement the insert() function
    root = insert(root, data);
  }

  private int findMin(BinaryTreeNode<Integer> root) {
    while (root.left != null) {
      root = root.left;
    }
    return root.data;
  }

  private BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root, int data) {
    if (root == null)
      return null;
    if (root.data == data) {
      if (root.right == null) {
        return root.left;
      } else if (root.left == null)
        return root.right;
      else {
        int minNodeValue = findMin(root.right);
        root.data = minNodeValue;
        root.right = remove(root.right, minNodeValue);
      }
    } else if (root.data > data) {
      root.left = remove(root.left, data);
    } else
      root.right = remove(root.right, data);
    return root;
  }

  public void remove(int data) {
    // Implement the remove() function
    root = remove(root, data);

  }

  private void printTree(BinaryTreeNode<Integer> root) {
    if (root == null)
      return;

    System.out.print(root.data + ":");
    if (root.left != null) {
      System.out.print("L:" + root.left.data + ",");
    }
    if (root.right != null) {
      System.out.print("R:" + root.right.data);
    }
    System.out.println();
    printTree(root.left);
    printTree(root.right);
  }

  public void printTree() {
    // Implement the printTree() function
    printTree(root);
  }

  private boolean search(BinaryTreeNode<Integer> root, int data) {
    if (root == null)
      return false;

    boolean leftAns = false, rightAns = false;
    if (root.data == data)
      return true;
    else if (root.data > data) {
      return search(root.left, data);
    } else {
      return search(root.right, data);
    }
  }

  public boolean search(int data) {
    // Implement the search() function
    return search(root, data);

  }

}