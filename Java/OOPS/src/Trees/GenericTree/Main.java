package src.Trees.GenericTree;

import java.util.*;

public class Main {

  public static TreeNode<Integer> takeInputRecursive(Scanner scan) {
    System.out.println("Enter Root Node");
    int rootval = scan.nextInt();
    TreeNode<Integer> root = new TreeNode<>(rootval);

    System.out.println("Enter Number of Children for Node " + root.data);

    int n = scan.nextInt();
    for (int i = 0; i < n; i++) {
      System.out.println("Enter Node value for child " + i + 1 + " node" + root.data);
      TreeNode<Integer> child = takeInputRecursive(scan);
      root.children.add(child);
    }
    return root;
  }

  public static int getHeight(TreeNode<Integer> root) {
    int height = 0;
    for (TreeNode<Integer> child : root.children) {
      height = Math.max(height, getHeight(child));
    }
    return height + 1;
  }

  public static void printTree(TreeNode<Integer> root) {
    System.out.print(root.data + ": ");

    for (int i = 0; i < root.children.size(); i++) {
      System.out.print(root.children.get(i).data + " ");
    }
    System.out.println();

    for (int i = 0; i < root.children.size(); i++) {
      printTree(root.children.get(i));
    }
  }

  public static void printLevelWise(TreeNode<Integer> root) {
    Queue<TreeNode<Integer>> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    while (!queue.isEmpty()) {
      TreeNode<Integer> front = queue.poll();

      if (front == null) {
        System.out.println();
        if (!queue.isEmpty()) {
          queue.add(null);
        }
      } else {
        System.out.print(front.data + " ");
        for (TreeNode<Integer> child : front.children) {
          queue.add(child);
        }
      }

    }
  }

  public static TreeNode<Integer> takeInputLevelWise(Scanner scan) {
    System.out.println("Enter the Root Node");
    TreeNode<Integer> root = new TreeNode<>(scan.nextInt());
    Queue<TreeNode<Integer>> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode<Integer> currentNode = queue.poll();
      System.out.println("Enter number of children for " + currentNode.data);
      int n = scan.nextInt();
      if (n > 0) {
        System.out.println("Enter childrens of " + currentNode.data);
      }
      for (int i = 0; i < n; i++) {
        TreeNode<Integer> child = new TreeNode<>(scan.nextInt());
        currentNode.children.add(child);
        queue.add(child);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    // TreeNode<Integer> root = new TreeNode<>(10);
    // TreeNode<Integer> root2 = new TreeNode<>(20);
    // TreeNode<Integer> root3 = new TreeNode<>(30);
    // root.children.add(root2);
    // root.children.add(root3);
    // System.out.println(root.data);
    // System.out.println(root.children.get(0).data);
    // System.out.println(root.children.get(1).data);
    TreeNode<Integer> root;
    // root = takeInputRecursive(new Scanner(System.in));
    root = takeInputLevelWise(new Scanner(System.in));
    printTree(root);
    printLevelWise(root);
    System.out.println(getHeight(root));
  }
}
