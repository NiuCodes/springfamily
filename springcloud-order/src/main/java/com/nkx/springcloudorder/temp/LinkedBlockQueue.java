package com.nkx.springcloudorder.temp;

import com.nkx.springcloudorder.datactructure.queue.LinkedQueue;

public class LinkedBlockQueue {

    private LinkedNode head;

    private LinkedNode tail;

    private int size;


    public void push(int item){
        LinkedNode newNode = new LinkedNode(item);
        if (tail == null){
            tail = newNode;
            head = tail;
        }else{
            //newNode.next = tail.next;
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }


    public int pop(){
        LinkedNode current = head;
        if (current != null){
            head = current.next;
            return current.data;
        }
        size--;
        return -1;
    }


    public static void main(String[] args) {
        LinkedBlockQueue linkedQueue = new LinkedBlockQueue();
        linkedQueue.push(1);
        linkedQueue.push(2);
        linkedQueue.push(3);
        for (int i = 1; i < 4; i++) {
            System.out.println(linkedQueue.pop());
        }
    }


}


 class LinkedNode {
    int data;
     LinkedNode next;

    public LinkedNode(int data){
        this.data = data;
        this.next = null;
    }
 }
