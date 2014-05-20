/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw3;
/**
 *
 * @author n9e
 */
public class MaxHeapChecker {
    
    public MaxHeapChecker(){}
    
    public boolean isAMaxHeap(MyBinaryTree possibleHeap)
    {
        BinaryNode<T> currentNode = possibleHeap.root;
        if(possibleHeap.root.leftChild == null)
        {
            return false;
        }    
    }        
    
}
