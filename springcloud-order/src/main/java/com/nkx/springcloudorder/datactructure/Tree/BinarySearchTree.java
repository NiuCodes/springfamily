package com.nkx.springcloudorder.datactructure.Tree;

public class BinarySearchTree {

  public void removeNode(TreeNode root, char data) {
    TreeNode roor1 = root;
    if (root.data < data) {
      removeNode(roor1.right, data);
    } else if (roor1.data > data) {
      removeNode(roor1.left, data);
    }else{
      if (roor1.right == null && roor1.left == null) {  // if find child Node
        roor1 = null;
        return;
      }
      if (roor1.right == null) {
        roor1 = roor1.right;
        roor1.right = null;
        return;
      }
      if (roor1.left == null) {
        roor1 = roor1.right;
        root.right = roor1;
        System.out.println(root.toString());
        //root.left = null;
        return;
      }
      if (roor1.right != null && roor1.left != null) {
        TreeNode lastNode = findlastNode(roor1);
        roor1 = lastNode;
      }
    }


  }

  public TreeNode findlastNode(TreeNode treeNode) {    //查找后继节点
    if (treeNode.right.left == null) {
      return treeNode.right;
    } else {
      findlastNode(treeNode.right.right);
    }
    return null;
  }

  public TreeNode search(TreeNode root, char data) {

    if (root.data < data) {
      search(root.right, data);
    } else if (root.data > data) {
      search(root.left, data);
    }else{
      return root;
    }
    return root;
  }
  public void search1(TreeNode root, char data) {

    if (root.data < data) {
      search1(root.right, data);
    } else if (root.data > data) {
      search1(root.left, data);
    }else{
      System.out.println("==========" + root.data);
      return;
    }

  }



  private void insert(TreeNode root, char data) {
    if (root.data > data) {
      if (root.left == null) {
        root.left = new TreeNode(data, null, null);
      } else {
        insert(root.left, data);
      }
    } else {
      if (root.right == null) {
        root.right = new TreeNode(data, null, null);
      } else {
        insert(root.right, data);
      }
    }

  }

  static class TreeNode {

    private char data;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(char data, TreeNode left, TreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }

    public int getData() {
      return data;
    }

    public void setData(char data) {
      this.data = data;
    }

    public TreeNode getLeft() {
      return left;
    }

    public void setLeft(TreeNode left) {
      this.left = left;
    }

    public TreeNode getRight() {
      return right;
    }

    public void setRight(TreeNode right) {
      this.right = right;
    }

    @Override
    public String toString() {
      return "TreeNode{" + "data=" + data + ", left=" + left + ", right=" + right + '}';
    }

  }

  public static void main(String[] args) {
    TreeNode D = new TreeNode('D', null, null);
    TreeNode H = new TreeNode('H', null, null);
    TreeNode K = new TreeNode('K', null, null);
    TreeNode C = new TreeNode('C', D, null);
    TreeNode G = new TreeNode('G', H, K);
    TreeNode B = new TreeNode('B', null, C);
    TreeNode F = new TreeNode('F', G, null);
    TreeNode E = new TreeNode('E', null, F);
    TreeNode A = new TreeNode('A', B, E);
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.removeNode(A, 'E');
    System.out.println(A.toString());
  }
}
