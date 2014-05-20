/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author n9e
 */
public class MyArrayList<T> {
  
  private T[] elements;
  private int size;
  
  public MyArrayList( ) 
  {
      
       elements = createArray(3);
       
  }
  
  private T[] createArray(int size)
  {
      Object[] array = new Object[size];
      return (T[])array;
  }
  
  public void add(T item)       
  {
      System.out.println("The length of the initial array is " + elements.length);
      System.out.println("The actual size of the initial array is " + size);
      
      if ((elements.length == size)&&(size == 0))
      {  
        ensureCapacity(size + 2);
        System.out.println("The length of the expanded array is " + elements.length);
        elements[size] = item;
        size++;
      }  
      else if (elements.length == size)
      {
        ensureCapacity(size * 2 );
        System.out.println("The length of the expanded array is " + elements.length);
        elements[size] = item;
        size++;
      }    
      else 
      {
        elements[size]= item;
        size++;
      }
     
          
  }
  
  public int size()
  {
        return size;
  }
  
  public T get(int index) 
  {    
      if( index < 0 || index >= size)
        throw new ArrayIndexOutOfBoundsException();
      else
        return elements[index]; 
  }
  
  public void remove(int index)
  {
    if ( index < 0 || index >= size)
        throw new ArrayIndexOutOfBoundsException();
    else 
    {     
        for( int i = index; i < size-1; i++ )
        {
            elements[i] = elements[i + 1];           
        }  
    }   size--;
  }
  
  public void ensureCapacity(int newCapacity )
  {
    if ( newCapacity < 0 )
         throw new ArrayIndexOutOfBoundsException();
    else
    {    
        T[] oldList = elements;   
        T[] expandedList = createArray(newCapacity);
    
        for( int i = 0; i < size; i++ )
        expandedList[i] = oldList[i];
    
        elements = expandedList;
    }   
  }

}
