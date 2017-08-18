package com.interviewcake.no23;

// Write a function containsCycle() that takes the first node
// in a singly-linked list and returns a boolean indicating whether
// the list contains a cycle.

public class MyLinkedList {

    private LinkedListNode first;

    public static class LinkedListNode {

        int value;
        LinkedListNode next;

        LinkedListNode(int value){
            this.value = value;
        }

        public void setNext(LinkedListNode next){
            this.next = next;
        }

        public LinkedListNode getNext() {
            return next;
        }
    }

    public MyLinkedList(LinkedListNode first){
        this.first = first;
    }

    public LinkedListNode getFirst() {
        return first;
    }

    public boolean containsCycle(){

        LinkedListNode fast = this.first;
        LinkedListNode slow = this.first;

        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        MyLinkedList.LinkedListNode first = new MyLinkedList.LinkedListNode(1);
        MyLinkedList.LinkedListNode second = new MyLinkedList.LinkedListNode(2);
        MyLinkedList.LinkedListNode third = new MyLinkedList.LinkedListNode(3);
        MyLinkedList.LinkedListNode fourth = new MyLinkedList.LinkedListNode(4);
        MyLinkedList.LinkedListNode fifth = new MyLinkedList.LinkedListNode(5);
        MyLinkedList.LinkedListNode sixth = new MyLinkedList.LinkedListNode(6);
        MyLinkedList.LinkedListNode seventh = new MyLinkedList.LinkedListNode(7);
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(sixth);
        sixth.setNext(seventh);
        seventh.setNext(fifth);  // here the loop is made

        MyLinkedList myList = new MyLinkedList(first);

        System.out.println(myList.containsCycle());
    }

}
