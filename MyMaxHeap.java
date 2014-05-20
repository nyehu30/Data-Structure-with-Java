/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author katy
 */
public class MyMaxHeap<T extends Comparable> {
    
    
    public MyMaxHeapNode<T> top;
    
    public MyMaxHeap(){}        
    
    public MyMaxHeap(List<T> data)
    {
        for (T item : data)
        {
            push(item);
        }    
    }        
    
    public void push(T v)
    {
        if (top == null || top.data == null)
        {
            top = new MyMaxHeapNode<>(v);
            return;
        }
        
        MyMaxHeapNode<T> addNode = new MyMaxHeapNode<>(v, getAddNode());
        addNode.promote(v);
//        if(addNode.left == null)
//        {
//            addNode.left = new MyMaxHeapNode<>(v);
//            addNode.left.promote(v);
//            return;
//        }  
//        else if(addNode.right == null)
//        {
//            addNode.right = new MyMaxHeapNode<>(v);
//            addNode.right.promote(v);
//           return;
//        }    
        
    }   
    
    public MyMaxHeapNode<T> getAddNode()
    {
        List<MyMaxHeapNode<T>> list = new LinkedList<>();
        list.add(top);

        for (int i = 0; i < list.size(); i++) 
        {
            if (list.get(i).left != null)
                list.add(list.get(i).left);
            if (list.get(i).right != null)
                list.add(list.get(i).right);
            
            if (list.get(i).left == null || list.get(i).right == null )
                return list.get(i);
        }
        return null;
    }   
    
    public T peek()
    {
        if(top.data != null)
        {    
            return top.data;
        }   
        return null;
    }   
    
    public T pop()
    {
        T topData = top.data;
        MyMaxHeapNode<T> lastNode = getLastNode();
        top.data = lastNode.data;
        
        if(top.left == null)
        {
            top =null;
            return topData;
        }
        
        if(lastNode.parent.left == lastNode)
        {
            lastNode.parent.left = null;
        }
        else if(lastNode.parent.right == lastNode)
        {
            lastNode.parent.right = null;
        }  
        top.heapify();
        return topData;
      
    }   
    
    public boolean isEmpty()
    {
        return top == null;
    } 
	
	public void printHeap(){
		//Prints the entire heap recursively.
		if(isEmpty())return;
		top.printSubTree(0);
		System.out.println();
	}
        
    public MyMaxHeapNode<T> getLastNode()  
    {
        
        List<MyMaxHeapNode<T>> list = new LinkedList<>();
        if(top != null)
        {    
            list.add(top);
        
            for (int i = 0; i < list.size(); i++) 
            {
                if (list.get(i).left != null)
                    list.add(list.get(i).left);
                if (list.get(i).right != null)
                    list.add(list.get(i).right);
                 
            }
        }
        return  list.get(list.size()-1);
    }
}
