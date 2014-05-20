/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLinkedList;

/**
 *
 * @author n9e
 */
public class MyStack<T> {
    
        private Node<T> head; 
        
    public void clear()
    {
        head = null;
    }    
    
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public T peek()
    {
        if(head == null)
        {
            return null;
        }    
        return head.data;
    }   
    
    public T pop()
    {
        Node<T> temp = head;
        
        if(head == null)
        {
            return null;
        }
        else
        {   
           head.next = null;
           head = temp.next;
           return temp.data;                  
        }
          
    } 
    
    public void push(T data)
    {
       Node<T> newNode = new Node(data);
       if(head == null) 
       {
          head = newNode; 
       } 
       else
       {
          //newNode.next = head.next;
          //head.next = newNode; This is wrong
          
         newNode.next = head;
         head = newNode;
       }
         
    }        
            
}
