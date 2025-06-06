
package com.umg.edu.progra3_utilities.stack;

import com.umg.edu.progra3_model.entities.Ticket;

public class MyStack {
    private Node top;

    public void push(Ticket ticket) {
        Node node = new Node(ticket);
        node.next = top;
        top = node;
    }

    public Ticket pop() {
        if (top == null) return null;
        Ticket data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class Node {
        Ticket data;
        Node next;
        Node(Ticket data) { this.data = data; }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MyStack:\n");
        Node current = top;
        while (current != null) {
            sb.append("  ").append(current.data).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}
