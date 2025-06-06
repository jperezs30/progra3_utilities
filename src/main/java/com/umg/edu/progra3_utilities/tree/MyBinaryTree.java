package com.umg.edu.progra3_utilities.tree;

import java.time.LocalDateTime;

import com.umg.edu.progra3_model.entities.History;
import com.umg.edu.progra3_model.entities.Ticket;
import com.umg.edu.progra3_model.enums.TicketStatus;
import com.umg.edu.progra3_utilities.list.MyNode;

import jakarta.persistence.EntityManager;

public class MyBinaryTree {

    private TreeNode root;

    public void insertTicket(Ticket ticket) {
        TreeNode node = insertOrGetNode(ticket.getService().getName());
        node.queue.enqueue(ticket);
    }

    public boolean deleteTicketById(Long id) {
        return deleteRecursive(root, id);
    }

    private boolean deleteRecursive(TreeNode node, Long id) {
        if (node == null) return false;

        MyNode current = node.queue.getFront();
        while (current != null) {
            Ticket t = (Ticket) current.data;
            if (t.getId().equals(id)) {                
                node.queue.removeById(id);
                return true;
            }
            current = current.next;
        }

        // Continuar en subárboles izquierdo y derecho
        return deleteRecursive(node.left, id) || deleteRecursive(node.right, id);
    }


    public Ticket attendNext(String serviceName) {
        System.out.println("root" + root);
        System.out.println("serviceName: " + serviceName);
        TreeNode node = findNode(root, serviceName);
        if (node != null && !node.queue.isEmpty()) {
            return node.queue.dequeue();
        }
        return null;
    }

    private TreeNode insertOrGetNode(String name) {
        if (root == null) {
            root = new TreeNode(name);
            return root;
        }
        return insertRec(root, name);
    }

    private TreeNode insertRec(TreeNode node, String name) {
        if (name.equals(node.serviceName)) {
            return node;
        } else if (name.compareTo(node.serviceName) < 0) {
            if (node.left == null) node.left = new TreeNode(name);
            return insertRec(node.left, name);
        } else {
            if (node.right == null) node.right = new TreeNode(name);
            return insertRec(node.right, name);
        }
    }

    private TreeNode findNode(TreeNode node, String name) {
        if (node == null) return null;
        System.out.println("Searching for: " + name + " in node: " + node.serviceName);
        if (name != null && name.trim().equalsIgnoreCase(node.serviceName.trim())) return node;
        if (name.compareTo(node.serviceName) < 0) return findNode(node.left, name);
        return findNode(node.right, name);
    }
    
    public TreeNode getRoot() {
        return root;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Árbol de Servicios:\n");
        traverseTree(root, sb);
        return sb.toString();
    }

    private void traverseTree(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        traverseTree(node.left, sb);

        sb.append("Servicio: ").append(node.serviceName).append("\n");
        sb.append("  Tickets:\n");

        MyNode current = node.queue.getFront();
        while (current != null) {
            Ticket t = (Ticket) current.data;
            sb.append("    - Ticket ID: ").append(t.getId())
            .append(", Cliente: ").append(t.getCustomer().getName())
            .append(", Estado: ").append(t.getStatus()).append("\n");
            current = current.next;
        }

        traverseTree(node.right, sb);
    }

    
}
