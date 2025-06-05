/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.edu.progra3_utilities.list;

import com.umg.edu.progra3_model.entities.Ticket;

/**
 *
 * @author Fernando
 */
public class MyNode {
    public Ticket data;
    public MyNode next;

    public MyNode(Ticket data) {
        this.data = data;
    }
}
