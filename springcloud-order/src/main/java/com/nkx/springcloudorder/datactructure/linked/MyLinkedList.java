package com.nkx.springcloudorder.datactructure.linked;

import java.util.LinkedList;

public class MyLinkedList<E> {

  private Node head;

  private int size = 0;

  public void insertHead(E element) {   //插入链表的头部		element就是插入的数据
    Node<E> newNode = new Node<E>(element, null);
    //如果原来就有数据呢？
    if (head != null){
      newNode.next = head;
    }
    head = newNode;
  }

  public void insertNth(E element, int index) {
    if (index == 0) {
      insertHead(element);
    } else {
      Node current = head;
      for (int i = 1; i < index; i++) {
        current = current.next;
      }
      Node newNode = new Node(element, null);
      newNode.next = current.next;
      current.next = newNode;
      head = current;
    }
  }


  public void deleteNth(int index) {
    if (index == 0){
      this.head = head.next;
      return;
    }
    Node cur = head;
    for (int i = 1; i < index; i++) {
      cur = cur.next;
    }
    cur.next = cur.next.next;
  }

  public void find(E element) {//O(n)
    Node cur = head;
    while (cur != null) {
      if (cur.item == element)
        break;
      cur = cur.next;
    }

  }

  public void print() {
    Node cur = head;
    while (cur != null) {
      System.out.print(cur.item + " ");
      cur = cur.next;
    }
    System.out.println();
  }

  public void deleteHead() {
    head = head.next;
  }

  private static class Node<E> {
    E item;

    Node<E> next;

    Node(E element, MyLinkedList.Node<E> next) {
      this.item = element;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    MyLinkedList<Integer> myList = new MyLinkedList();
    myList.insertHead(5);
    myList.insertHead(7);
    myList.insertHead(10);
    myList.print(); // 10 -> 7 -> 5
    myList.deleteNth(0);
    myList.print(); // 7 -> 5
    myList.deleteHead();
    myList.print(); // 5
    myList.insertNth(11, 1);
    myList.print(); // 5 -> 11
    myList.deleteNth(1);
    myList.print(); // 5
  }
}
