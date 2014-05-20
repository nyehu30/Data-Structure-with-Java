/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw3;

/**
 *
 * @author katy
 */
public class MyMaxHeapNode<T extends Comparable> {
        
        
    public T data;
    public MyMaxHeapNode<T> parent;
    public MyMaxHeapNode<T> left;
    public MyMaxHeapNode<T> right;
    
    
    public MyMaxHeapNode(T data)
    {
        this.data = data;
    }   
    
    public MyMaxHeapNode(T data, MyMaxHeapNode<T> parent)
    {
        this.data = data;
        this.parent = parent;
        if (parent.left == null)
        {
            parent.left = this; 
        }  
        else
        {
            parent.right = this; 
        }    
    }   
    
    
    public void heapify()
    {
        //this.compareTo(that)

//    returns
//    a negative int if this < that
//    0 if this == that
//    a positive int if this > that

        MyMaxHeapNode<T>  largestChild;
        
        if (left == null)
        {
            return;
        }
        
        if (right == null || left.data.compareTo(right.data) > 0 )
        {
            largestChild = left;
        } 
        else
        {
            largestChild = right;
        }    
            
        if(largestChild.data.compareTo(data) > 0)
        {
            T temp = data;            
            data = largestChild.data;
            largestChild.data = temp;
            largestChild.heapify();
            // heapify the child node???
        }    
    }        
        
    public void promote(T v)
    {
        data = v;
             
        if (parent == null)
        {
            return;
        }
        
        if(data.compareTo(parent.data) > 0)
        {
            T temp = data;            
            data = parent.data;
            parent.promote(temp);        
        }    
        
        
    
    }        
    
          
       
	public void printSubTree(int depth){
		//Prints the node and its children, using the style developed by Baylor.
		for(int i = 1; i<depth; i++){
			System.out.print("    ");
		}
		if(depth!=0){
			System.out.print("|~~~");
		}
		System.out.println(this.data);
		if(left!=null)
			{left.printSubTree(depth+1);}
		if(right!=null)
			{right.printSubTree(depth+1);}
	}
        
        
}
