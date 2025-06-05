package com.umg.edu.progra3_utilities.tree;

import com.umg.edu.progra3_model.entities.Ticket;
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
        boolean deleted = node.queue.removeById(id);
        return deleted || deleteRecursive(node.left, id) || deleteRecursive(node.right, id);
    }

    public Ticket attendNext(String serviceName) {
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
        if (name.equals(node.serviceName)) return node;
        if (name.compareTo(node.serviceName) < 0) return findNode(node.left, name);
        return findNode(node.right, name);
    }
    
    public TreeNode getRoot() {
        return root;
    }

    
}
