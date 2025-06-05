package com.umg.edu.progra3_utilities.queue;

import com.umg.edu.progra3_model.entities.Ticket;
import com.umg.edu.progra3_utilities.list.MyNode;

public class MyQueue {
    private MyNode front;
    private MyNode rear;

    public void enqueue(Ticket ticket) {
        MyNode node = new MyNode(ticket);
        if (rear != null) rear.next = node;
        rear = node;
        if (front == null) front = node;
    }

    public Ticket dequeue() {
        if (front == null) return null;
        Ticket data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    public boolean removeById(Long id) {
        MyNode current = front, previous = null;
        while (current != null) {
            if (current.data.getId().equals(id)) {
                if (previous == null) {
                    front = current.next;
                    if (front == null) rear = null;
                } else {
                    previous.next = current.next;
                    if (current == rear) rear = previous;
                }
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        int count = 0;
        MyNode current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public MyNode getFront() {
        return front;
    }   

}
