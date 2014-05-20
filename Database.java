/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package csci1902hw3;

import java.util.List;
/**
 *
 * @author n9e
 * 
 */





public class Database {
    
    public Database(){}
    
    
    public MyHashTable<String, List<String>> bookContents = new MyHashTable<>(10,11);
    public MyHashTable<String, Integer> criminalHistory = new MyHashTable<>(10,11); 
    public MyHashTable<String, List<String>> criminalAssociations = new MyHashTable<>(10,11);
    public MyHashTable<String, List<String>> fellowTravelers = new MyHashTable<>(10,11);
    public MyHashTable<String, List<String>> libraryCheckoutHistory = new MyHashTable<>(10,11);
    public MyHashTable<String, String> password = new MyHashTable<>(10,11);
   
    
    public void loadBookContents(String[] keys, List<String>[] values)
    {   
           
            for (int i = 0; i < values.length; i++)
            {    
                bookContents.put(keys[i], values[i]);
            }
        
    }   
    
    public void loadCriminalHistory(String[] keys, int[] values)
    {
        for (int i = 0; i < keys.length; i++)
        {    
            criminalHistory.put(keys[i], values[i]);
        }
        
    } 
    
    public void loadCriminalAssociations(String[] keys, List<String>[] values)
    {
        for (int i = 0; i < keys.length; i++)
        {    
            criminalAssociations.put(keys[i], values[i]);
        }
    }        
    
    public void loadFellowTravelers(String[] keys, List<String>[] values)
    {
        for (int i = 0; i < keys.length; i++)
        {    
            fellowTravelers.put(keys[i], values[i]);
        }
    } 
    
    public void loadLibraryCheckoutHistory(String[] keys, List<String>[] values)
    {
        for (int i = 0; i < keys.length; i++)
        {    
            libraryCheckoutHistory.put(keys[i], values[i]);
        }
       
    }  
    
    public void loadPassword(String[] keys, String[] values)
    {
        for (int i = 0; i < keys.length; i++)
        {    
            password.put(keys[i], values[i]);
        }
    }        
}


