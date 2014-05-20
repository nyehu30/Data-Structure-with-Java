/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author n9e
 */
package MyLinkedList;

public class Node<T> 
{
        Node<T> next;
             T  data;

	public Node(T data)
	{
		this(data, null);
	}

	public Node(T data, Node<T> next)
	{
		this.data = data;
		this.next = next;
	}
        
}



                 
