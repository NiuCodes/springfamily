package com.nkx.springcloudorder.datactructure.queue;

public class LinkedQueue<E> {

  private Node<Integer> head;

  private Node<Integer> tail;

  private int size = 0;

  public void push(Integer element) {
    if (tail == null) {
      tail = new Node<Integer>(element);
      head = tail;
    } else {
      Node<Integer> newNode = new Node<>(element);
      newNode.next = tail.next;
      tail.next = newNode;
      tail = tail.next;
    }
    ++size;
  }

  public Integer pop() {
    Integer value = head.item;
    if (size == 0) {
      throw new RuntimeException("Queue is empty");
    }
    head = head.next;
    --size;
    return value;
  }

  private static class Node<E> {
    E item;

    Node<E> next;

    public Node(E item) {
      this.item = item;
      this.next = null;
    }

  }

  public static void main(String[] args) {
    LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
    linkedQueue.push(1);
    linkedQueue.push(2);
    linkedQueue.push(3);
    for (int i = 1; i < 4; i++) {
      System.out.println(linkedQueue.pop());
    }
  }
}
