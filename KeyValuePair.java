/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw3;

/**
 *
 * @author n9e
 */
public class KeyValuePair<K, V> {
    
    public K key;
    public V value;
    
    public KeyValuePair(){}
    public KeyValuePair(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
    
@Override    
    public String toString()
    {
        return key + "=" + value;  
    }        
}
