/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs102assignment08;

/**
 *
 * @author jehuv
 */
public class Node {
    private Node left;
    private Node right;
    private int key;

    public Node(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    public int getKey()
    {
        return this.key;
    }
    
    public Node search(int key)
    {
        if(this.getKey() == key)
        {
            return this;
        }
        else if(this.getKey() < key)
        {
            return this.getRight().search(key);
        }
        else
        {
            return this.getLeft().search(key);
        }
    }
    
    public Node searchParent(int key, Node previousNode)
    {
        if(this.getKey() == key)
        {
            return previousNode;
        }
        else if(this.getKey() < key)
        {
            return this.getRight().searchParent(key, this);
        }
        else
        {
            return this.getLeft().searchParent(key, this);
        }
    }
}
