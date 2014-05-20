package csci1902hw3;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author baylor & eman
 */
public class MyHashTable<K, V> {
    //--- It's a prime, stays prime for first 5 capacity expansions
    //---	(assuming java's expansion policy of 2n+1)
    //-- Technically, java no longer uses primes, uses power of 2
    
    protected List<KeyValuePair<K,V>>[] collisionBuckets;
    protected float loadFactor;
    
   
    public MyHashTable(int initialCapacity, float loadFactor)
    {
        this.collisionBuckets = allocateBucketArray(initialCapacity); 
        this.loadFactor = loadFactor;
        
    }        
        
    public boolean contains(K key)
    {
        return get(key) != null;
    }
     
    public V get(K key)
    {
        int hash = Math.abs(key.hashCode());
        int index = hash % collisionBuckets.length;
   
          
        for(int i = 0 ; i < collisionBuckets[index].size(); i++)
        {
            if(collisionBuckets[index].get(i).key.equals(key) )
            {
                return collisionBuckets[index].get(i).value;
            }    
        }
        
        return null;  
    }        
    
    public List<KeyValuePair<K,V>> getEntries()
    {
        List<KeyValuePair<K,V>> entries = new LinkedList<>();
        for(int i = 0; i < collisionBuckets.length; i++)
        {   
            if( !collisionBuckets[i].isEmpty() )
            {    
                for(int j = 0; j < collisionBuckets[i].size(); j++)
                {    
                    entries.add(collisionBuckets[i].get(j)); 
                }
            }
        } 
        
        return entries;
    }        

    public List<K> getKeys()
    {
        List<K> keys = new LinkedList<>();
        for(int i = 0; i < collisionBuckets.length; i++)
        {   
            for(int j = 0; j < collisionBuckets[i].size(); j++ )
            {    
                keys.add(collisionBuckets[i].get(j).key); 
            }
        } 
        
        return keys;
    }   
    
    public List<V> getValues()
    {        
        List<V> values = new LinkedList<>();
        for(int i = 0; i < collisionBuckets.length; i++)
        {   
            for(int j = 0; j < collisionBuckets[i].size(); j++ )
            {    
                values.add(collisionBuckets[i].get(j).value);
            }    
        } 
        
        return values;
    }
    
    public boolean isEmpty()
    {
        return size() == 0;
    }    
           
    public void put(K key, V value)
    {
        int hash = Math.abs(Math.abs(key.hashCode()));
        int bucketIndex = hash % collisionBuckets.length;  

        if (contains(key))
        {    
            for(int i = 0 ; i < collisionBuckets[bucketIndex].size(); i++)
            {   
                if(collisionBuckets[bucketIndex].get(i).key.equals(key))
                collisionBuckets[bucketIndex].get(i).value = value;
            }
        }
        else
        {
             
            resize();
           
            hash = Math.abs(Math.abs(key.hashCode()));
            bucketIndex = hash % collisionBuckets.length;  
            KeyValuePair newKeyValuePair = new KeyValuePair(key, value);
            List<KeyValuePair<K,V>> newBucket = collisionBuckets[bucketIndex];
            newBucket.add(newKeyValuePair);
            collisionBuckets[bucketIndex] = newBucket;
        }
            
    }        
    
    public void remove(K key)
    {
        int hash = Math.abs(key.hashCode());
        int bucketIndex = hash % collisionBuckets.length;
 
         if (contains(key))
        {            

            for(int i = 0 ; i < collisionBuckets[bucketIndex].size(); i++)
            {   
                if(collisionBuckets[bucketIndex].get(i).key.equals(key))
                {    

                    collisionBuckets[bucketIndex].remove(i); 

                    break;
                }
            }
        }
         
        
    }        
    
    public void print(int index)
    {
       
            for(int j = 0; j < collisionBuckets[index].size(); j++)
            {
                System.out.print(collisionBuckets[index].get(j).key + " ");
            }
            System.out.println();
            
    }        
    

    public int size()
    {
       return getEntries().size();
    }        
    
    public int getBucketIndex(int hashCode) 
    {
       return hashCode % collisionBuckets.length;
    }        
    
    public List<KeyValuePair<K, V>> getBucket(int bucketIndex)
    {
       if(bucketIndex < collisionBuckets.length) 
       {    
        return collisionBuckets[bucketIndex];
       }
       
       return null;
    }        
    
    public KeyValuePair<K, V> getEntry(K key)
    {
         int hash = Math.abs(Math.abs(key.hashCode()));
         int bucketIndex = hash % collisionBuckets.length;
         if (contains(key))
        {            
            for(int i = 0 ; i < collisionBuckets[bucketIndex].size(); i++)
            {   
                if(collisionBuckets[bucketIndex].get(i).key.equals(key))
                {
                    return collisionBuckets[bucketIndex].get(i); 
                }
            }
        }
        return null; 
    }        
            
    public int getNumberOfCollisionBuckets()
    {
        return collisionBuckets.length;
    }        
        
 
    protected void resize()
    {
        if(shouldGrow())
        {
            int newCapacity = getNextPrime(collisionBuckets.length);
            
            
            List<KeyValuePair<K, V>>[] expandedCollisionBuckets = allocateBucketArray(newCapacity);
    
            for( int i = 0; i < collisionBuckets.length; i++ )
            {
                
                    for( int j = 0; j < collisionBuckets[i].size(); j++)
                    {                      
                        int newHash = Math.abs(collisionBuckets[i].get(j).key.hashCode()); 
                        int newBucketIndex = newHash %  expandedCollisionBuckets.length;            
                        expandedCollisionBuckets[newBucketIndex].add(collisionBuckets[i].get(j));
                        if(collisionBuckets[i].get(j).key.equals("Inigo"))
                            System.out.println(newBucketIndex);
                        
                    }  
                
            }    
        
            collisionBuckets = expandedCollisionBuckets;
        }    
    }
    
    protected boolean shouldGrow()
    {
        return size() > collisionBuckets.length *loadFactor;
    }        
     
    
    protected List<KeyValuePair<K, V>>[] allocateBucketArray(int numberOfBuckets) {
        //--- Creating arrays of templated objects has nasty syntax in java
        Class<?> type = new LinkedList<KeyValuePair<K, V>>().getClass();
        List<KeyValuePair<K, V>> temp[] = (List<KeyValuePair<K, V>>[]) Array.newInstance(type, numberOfBuckets);
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new LinkedList<>();
        }
        return temp;
    }

   
    protected int getNextPrime(int value) {
        for (int i = (value + 1);; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    protected boolean isPrime(int number) {
        double largestPossibleFactor = Math.sqrt(number);
        for (int i = 2; i <= largestPossibleFactor; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }

        return true;
    }
 
    
    public String toString()
    {
        return getEntries().toString();
    }        
}
