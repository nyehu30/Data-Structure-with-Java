/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw3;
/**
 *
 * @author n9e
 */
public class MyBinaryTree<T extends Comparable<T>> {
    
    public BinaryNode<T> root;
    
    public MyBinaryTree(){}
    
    public MyBinaryTree(BinaryNode<T> root)
    {
        this.root = root;
    }        
}
