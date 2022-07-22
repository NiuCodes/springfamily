package com.nkx.springcloudorder.datactructure.Tree;



import java.util.Arrays;
import java.util.Scanner;

/**
 * 1.每个结点不是红色就是黑色
 * 2.不可能有连在一起的红色结点（黑色的就可以），每个叶子节点都是黑色的空节点（NIL），也就是说，叶子节点不存储数据(隐藏节点)
 * 3.根结点都是黑色 root
 * 4.每个节点，从该节点到达其可达叶子节点的所有路径，都包含相同数目的黑色节点；
 */
public class RedBlackTree {

    private final int R = 0;
    private final int B = 1;

    private class Node {

        int key = -1;
        int color = B; // 颜色
        Node left = nil; // nil表示的是叶子结点
        Node right = nil;
        Node p = nil;

        Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node [key=" + key + ", color=" + color + ", left=" + left.key + ", right=" + right.key + ", p="
                    + p.key + "]" + "\r\n";
        }

    }

    private final Node nil = new Node(-1);
    private Node root = nil;

    public void printTree(Node node) {
        if (node == nil) {
            return;
        }
        printTree(node.left);
        System.out.print(node.toString());
        printTree(node.right);
    }

    /**
     * 插入的时候旋转和颜色变换规则：
     * 1.变颜色的情况：当前结点的父亲是红色，且它的祖父结点的另一个子结点
     * 也是红色。（叔叔结点）：
     * （1）把父节点设为黑色
     * （2）把叔叔也设为黑色
     * （3）把祖父也就是父亲的父亲设为红色（爷爷）
     * （4）把指针定义到祖父结点(爷爷)设为当前要操作的.
     * 2.左旋：当前父结点是红色，叔叔是黑色的时候，且当前的结点是右子树。左旋
     * 以父结点作为左旋。指针变换到父亲结点
     * 3.右旋：当前父结点是红色，叔叔是黑色的时候，且当前的结点是左子树。右旋
     * （1）把父结点变为黑色
     * （2）把祖父结点变为红色 （爷爷）
     * （3）以祖父结点旋转（爷爷）
     */
    private void insert(Node node) {
        Node temp = root;
        if (root == nil) {
            root = node;
            node.color = B;
            node.p = nil;
        } else {
            node.color = R;
            while (true) {
                if (node.key < temp.key) {
                    if (temp.left == nil) {
                        temp.left = node;
                        node.p = temp;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (node.key >= temp.key) {
                    if (temp.right == nil) {
                        temp.right = node;
                        node.p = temp;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
            fixTree(node);
        }
    }

    private void fixTree(Node node) {
        while (node.p.color == R) {
            Node y = nil;
            if (node.p == node.p.p.left) {
                y = node.p.p.right;

                if (y != nil && y.color == R) {
                    node.p.color = B;
                    y.color = B;
                    node.p.p.color = R;
                    node = node.p.p;
                    continue;
                }
                if (node == node.p.right) {
                    node = node.p;
                    rotateLeft(node);
                }
                node.p.color = B;
                node.p.p.color = R;
                rotateRight(node.p.p);
            } else {
                y = node.p.p.left;
                if (y != nil && y.color == R) {
                    node.p.color = B;
                    y.color = B;
                    node.p.p.color = R;
                    node = node.p.p;
                    continue;
                }
                if (node == node.p.left) {
                    node = node.p;
                    rotateRight(node);
                }
                node.p.color = B;
                node.p.p.color = R;
                rotateLeft(node.p.p);
            }
        }
        root.color = B;
    }

    void rotateLeft(Node node) {
        if (node.p != nil) {
            if (node == node.p.left) {
                node.p.left = node.right;
            } else {
                node.p.right = node.right;
            }
            node.right.p = node.p;
            node.p = node.right;
            if (node.right.left != nil) {
                node.right.left.p = node;
            }
            node.right = node.right.left;
            node.p.left = node;
        } else {
            Node right = root.right;
            root.right = right.left;
            right.left.p = root;
            root.p = right;
            right.left = root;
            right.p = nil;
            root = right;
        }
    }

    void rotateRight(Node node) {
        if (node.p != nil) {
            if (node == node.p.left) {
                node.p.left = node.left;
            } else {
                node.p.right = node.left;
            }

            node.left.p = node.p;
            node.p = node.left;
            if (node.left.right != nil) {
                node.left.right.p = node;
            }
            node.left = node.left.right;
            node.p.right = node;
        } else {
            Node left = root.left;
            root.left = root.left.right;
            left.right.p = root;
            root.p = left;
            left.right = root;
            left.p = nil;
            root = left;
        }
    }

    public void creatTree() {
        int data[]= {23,32,15,221,3};
        Node node;
        System.out.println(Arrays.toString(data));
        for(int i = 0 ; i < data.length ; i++) {
            node = new Node(data[i]);
            insert(node);
        }
        printTree(root);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        RedBlackTree bst = new RedBlackTree();
        bst.creatTree();
    }
}

