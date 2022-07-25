package com.nkx.springcloudorder.temp;

public class MyDoubleLinedList {

    private DNode head;
    private DNode tail;
    private int size = 0;


    public MyDoubleLinedList(){
        this.head = null;
        this.tail = null;
    }
    public void insertHead(int data) {
        DNode newNode = new DNode(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }else{
            tail = newNode;
        }
        head = newNode;
    }

    public void deleteHead(){
        if (head == null){
            return;
        }
        if (head.next == null){
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void deleteKey(int data){
        DNode current = head;
        while (current.data != data){
            if (current.next == null){
                System.out.println("data not found");
                break;
            }else{
                current = current.next;
            }
        }
        if (current == head){
            deleteHead();
            return;
        }else {
            if (current != tail){
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }else{
                tail = current.prev;
                tail.next = null;
            }
        }
    }


    public void print(){
        DNode current = head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyDoubleLinedList mylist = new MyDoubleLinedList();
        mylist.insertHead(10);
        mylist.insertHead(7);
        mylist.insertHead(5);
        mylist.insertHead(2);
        mylist.print(); // 2->5->7->10
        mylist.deleteHead();
        mylist.print();//5->7->10
        mylist.deleteKey(10);
        mylist.print();//5->10
    }


}

class DNode {
    DNode next;
    DNode prev;
    int data;

    public DNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}