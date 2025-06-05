/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.edu.progra3_utilities.tree;

import com.umg.edu.progra3_utilities.queue.MyQueue;

/**
 *
 * @author Fernando
 */
public class TreeNode {
    public String serviceName;
    public MyQueue queue = new MyQueue();
    public TreeNode left, right;

    public TreeNode(String name) {
        this.serviceName = name;
    }
}
