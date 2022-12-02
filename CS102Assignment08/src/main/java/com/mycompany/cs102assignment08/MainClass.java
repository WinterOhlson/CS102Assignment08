/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.cs102assignment08;

/**
 *
 * @author jehuv
 */
public class MainClass {

    public static void main(String[] args) {
        Node soleNode = new Node(5);
        
        Node rootNode = new Node(5);
        rootNode.setLeft(new Node(3));
        rootNode.setRight(new Node(6));
        rootNode.getLeft().setLeft(new Node(2));
        rootNode.getLeft().setRight(new Node(4));
        rootNode.getRight().setRight(new Node(7));
        
        System.out.println("Deleting a tree with only one node returns " + DeleteNode.deleteNode(soleNode, 5));
        Node newRoot = DeleteNode.deleteNode(rootNode, 3);
        Node newNode = rootNode.getLeft();
        int newKey = newNode.getKey();
        System.out.println("Making the same deletion as the example on canvas returns " + newRoot + " and the node in it's place is now " + newNode + " with a key of " + newKey);
    }
}
