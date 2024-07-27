package src.Trees.BinaryTree;

import java.util.*;

public class Main {

  public static BinaryTreeNode<Integer> takeInputRecursive(boolean isRoot) {
    if (isRoot) {
      System.out.println("Enter Root Node");
    }
    @SuppressWarnings("resource")
    Scanner scan = new Scanner(System.in);
    int rootData = scan.nextInt();
    if (rootData == -1)
      return null;
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
    if (rootData != -1) {
      System.out.println("Enter left Node of: " + rootData);
      root.left = takeInputRecursive(false);
      System.out.println("Enter right Node of: " + rootData);
      root.right = takeInputRecursive(false);
    }
    return root;
  }

  public static BinaryTreeNode<Integer> takeInputLevelWise() {
    System.out.println("Enter root data");

    @SuppressWarnings("resource")
    Scanner scan = new Scanner(System.in);

    int rootData = scan.nextInt();

    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

    Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      BinaryTreeNode<Integer> current = queue.poll();

      System.out.println("Enter left child of: " + current.data);
      int leftChildData = scan.nextInt();
      if (leftChildData != -1) {
        current.left = new BinaryTreeNode<>(leftChildData);
        queue.add(current.left);
      }
      System.out.println("Enter right child of: " + current.data);
      int rightChildData = scan.nextInt();
      if (rightChildData != -1) {
        current.right = new BinaryTreeNode<>(rightChildData);
        queue.add(current.right);
      }
    }
    return root;
  }

  public static void printTreeLevelWise(BinaryTreeNode<Integer> root) {
    Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    while (!queue.isEmpty()) {
      BinaryTreeNode<Integer> curr = queue.poll();

      if (curr == null) {
        System.out.println();
        if (!queue.isEmpty()) {
          queue.add(null);
        }
      } else {
        System.out.print(curr.data + " ");
        if (curr.left != null) {
          queue.add(curr.left);
        }
        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
    }
  }

  public static void printTree(BinaryTreeNode<Integer> root) {
    if (root == null)
      return;
    System.out.print(root.data + " : ");
    if (root.left != null) {
      System.out.print(root.left.data + " ");
    }
    if (root.right != null) {
      System.out.print(root.right.data);
    }
    System.out.println();
    printTree(root.left);
    printTree(root.right);
  }

  public static void main(String[] args) {
    BinaryTreeNode<Integer> root;
    // root = takeInputRecursive(true);
    root = takeInputLevelWise();
    printTree(root);
    printTreeLevelWise(root);
  }
}
