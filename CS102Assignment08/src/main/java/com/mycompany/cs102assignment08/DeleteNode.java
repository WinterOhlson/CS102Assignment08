/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs102assignment08;

/**
 *
 * @author jehuv
 */
public class DeleteNode {
    public static Node deleteNode(Node root, int key)
    {
        Node nodeToDelete = root.search(key); // This obtains a reference to the node we want to delete
        Node parentNode = root.searchParent(key, null); // This will be used later to delete the specified node
        if(parentNode != null && parentNode.getKey() > nodeToDelete.getKey()) // This checks if the node being deleted is to the left of it's parent
        {
            Node storedNode = null; // This creates a variable that will be used to add the deleted node's children back to the tree if it has any
            if(nodeToDelete.getLeft() != null) // This checks if the node being deleted has a left child
            {
                storedNode = nodeToDelete.getLeft(); // This assigns the node being deleted's left child to the variable mentioned above
            }
            if(nodeToDelete.getRight() != null) // This checks if the node being deleted has a right child
            {
                Node newNode = nodeToDelete.getRight();
                parentNode.setLeft(newNode); // These two lines replace the deleted node with it's right child
            }
            else // Since the node being deleted doesn't have a right child, if storedNode exists, it will replace the deleted node instead after addNode() is called
            {
                parentNode.setLeft(null); // This deletes the node without replacing it
            }
            if(storedNode != null) // This checks if the deleted node had a left child assigned to the storedNode variable
            {
                addNode(root, storedNode); // This adds the leftover child back to the tree
            }
            return root; // Returns the root node
        }
        else if(parentNode != null && parentNode.getKey() < nodeToDelete.getKey()) // Since the if statement confirmed that the node being deleted isn't to the left of it's parent, this one checks if it's to the right of it's parent
        {
            Node storedNode = null; // Much of this code is the same as the previous if statement
            if(nodeToDelete.getRight() != null)
            {
                storedNode = nodeToDelete.getRight(); // However, the roles of the left child and right child will be swapped
            }
            if(nodeToDelete.getLeft() != null)
            {
                Node newNode = nodeToDelete.getLeft();
                parentNode.setRight(newNode); // And everything happens to the right of the deleted node's parent
            }
            else
            {
                parentNode.setRight(null); 
            }
            if(storedNode != null)
            {
                addNode(root, storedNode); // This adds the leftover child back to the tree
            }
            return root; // Returns the root node
        }
        else // This only executes if the node being deleted doesn't have a parent
        {
            if(nodeToDelete.getRight() != null) // This checks if the node being deleted has a right child
            {
                Node storedNode = null; // Like before, a variable is created to be used to add a leftover child back to the tree after it's parent gets deleted
                if(nodeToDelete.getLeft() != null) // This checks if the node being deleted has a left child
                {
                    storedNode = nodeToDelete.getLeft(); // If the node being deleted has two children, the left child is assigned to the variable here so it can be added back to the tree
                }
                nodeToDelete = nodeToDelete.getRight(); // This replaces the deleted node with it's right child
                if(storedNode != null)
                {
                    addNode(nodeToDelete, storedNode); // If a leftover child was assigned to a variable, it's added back to the tree
                }
            }
            else if(nodeToDelete.getLeft() != null) // This checks if the node being deleted has only a left child
            {
                nodeToDelete = nodeToDelete.getLeft(); // If so, the deleted node is replaced with it's left child
            }
            else 
            {
                nodeToDelete = null; // If the node being deleted has no children and no parents, the entire tree is deleted
            }
            return nodeToDelete; // Returns null
        }
    }
    
    public static void addNode(Node root, Node nodeToAdd)
    {
        if(nodeToAdd.getKey() < root.getKey()) // This checks if the node being added is to the left of the root node
        {
            if(root.getLeft() != null) // This checks if the root node has a left child
            {
                addNode(root.getLeft(), nodeToAdd); // The function is called recursively, treating the left child of the root node as the new root node
            }
            else
            {
                root.setLeft(nodeToAdd); // If the root node doesn't have a left child, this simply sets the input node as the new left child of the root node
            }
        }
        else // The following code executes if the node being added is to the right of the root node
        {
            if(root.getRight() != null) // This checks if the root node has a right child
            {
                addNode(root.getRight(), nodeToAdd); // If so, the function is called recursively, treating the right child of the root node as the new root node
            }
            else 
            {
                root.setRight(nodeToAdd); // If the root node doesn't have a right child, the root node's right child is simply set to the new node
            }
        }
    }
}
