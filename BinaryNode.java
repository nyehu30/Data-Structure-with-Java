/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw3;
/**
 *
 * @author n9e
 */
public class BinaryNode<T extends Comparable<T>> {
    
    public T data;
    public BinaryNode<T> leftChild;
    public BinaryNode<T> rigthChild;
    
    public BinaryNode(T data)
    {
        this.data = data;
    }
}
