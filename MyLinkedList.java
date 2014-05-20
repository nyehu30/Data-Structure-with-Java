/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLinkedList;

/**
 *
 * @author n9e
 */
public class MyLinkedList<T> {
    
    private Node<T> head;
    
    private Node<T> getEnd()           
    {
        Node<T> current = head;
        if(null == head)
        {
            return null;
        }
        while(current.next != null)
        {
            current = current.next;
        }
        
        return current;
    }        
    
    public void add(T data)
    {
       Node<T> newNode = new Node(data);
       Node<T> lastNode = getEnd();
       if(null == head)
       {
           head = newNode;
       } 
       else
       {
           lastNode.next = newNode;
       }    
    } 
    
    public void clear()
    {
        head = null;
    }
    
    private Node<T> getNode(int desiredIndex)
    {
        int index = 0;
        Node<T> current = head;
        
        if( size() < desiredIndex && desiredIndex < 0)
            return null;
        else 
        {    
            while(index < desiredIndex)
            {
                index++;
                current = current.next;
            }    
        }
        return current;
    }         
    
    public T get(int index)
    {
       
       if (size() < index && size()< 0)
           return null;
       else
       {    
       Node<T> desiredNode = getNode(index);
       return desiredNode.data;
       }        
    }
           
    
    public boolean isEmpty() 
    {
        return size() == 0;
    }        
    
     
    public void remove(int index)       
    {
        Node<T> desiredNode = getNode(index);
        if (size() >= index && index >= 0)
        { 
            if(null == head)
                return;
            if(index == 0)
            {   
                head = head.next;   
                return;
            }    
            if(desiredNode != null)
            {   
            Node<T> previousNode = getNode(index-1);
            Node<T> nextNode = getNode(index+1);
            previousNode.next = nextNode;
            }
        }    
    }        
    
    public int size()
    {
        int size = 0;
        Node<T> current = head;
        while(current != null)
        {
            size++;
            current = current.next;    
        }  
        return size;
    }    
          
}
