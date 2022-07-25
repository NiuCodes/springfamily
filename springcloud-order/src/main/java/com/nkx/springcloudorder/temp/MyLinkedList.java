package com.nkx.springcloudorder.temp;


public class MyLinkedList {

    private Node head;
    private int size = 0;

    public void insertHead(int data){
        Node newNode = new Node(data);
        if (head != null){
            newNode.next = head;
        }
        head = newNode;
    }

    public void insertNth(int data,int index){
        if (index == 0){
            insertHead(data);
            return;
        }
        Node curr = head;
        for (int i = 1; i < index; i++) {
           curr = curr.next;
        }
        Node newNode = new Node(data);
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void deleteHead(){
        head = head.next;
    }

    public void find(int data){
        Node newNode =  head.next;
        while (head.next != null){
            if (newNode.value == data){
               break;
            }else{
                newNode = newNode.next;
            }
        }
    }

    public void deleteNth(int position){
        if (position == 0){
            deleteHead();
            return;
        }
        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current;
        }
        current.next = current.next.next;

    }


    public void print(){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        com.nkx.springcloudorder.temp.MyLinkedList myList = new com.nkx.springcloudorder.temp.MyLinkedList();
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

class Node {
    int value;
    Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }
}