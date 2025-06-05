package com.umg.edu.progra3_utilities.list;

import com.umg.edu.progra3_model.entities.Ticket;

public class MyLinkedList {

    private MyNode head;

    public void add(Ticket data) {
        MyNode newNode = new MyNode(data);
        if (head == null) {
            head = newNode;
        } else {
            MyNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int size() {
        int count = 0;
        MyNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public Ticket get(int index) {
        int count = 0;
        MyNode current = head;
        while (current != null) {
            if (count == index) return current.data;
            count++;
            current = current.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printAll() {
        MyNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
