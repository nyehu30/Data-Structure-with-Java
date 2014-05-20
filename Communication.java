/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw3;

import java.util.List;

/**
 *
 * @author n9e
 */
public class Communication {
    
    public String receiverName;
    public String senderName;
    public List<String> words;
    
    public Communication(){}
    
    public Communication( String receiverName, String senderName, List<String> words)
    {
        this.receiverName = receiverName;
        this.senderName = senderName;
        this.words = words;
    }        
    
    
}
