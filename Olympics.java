/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw1.Q2;

/**
 *
 * @author n9e
 */
public class Olympics {
    public void organizeSports(Sport[] sports) {
    for(int i = 0; i < sports.length; i++)
    System.out.println("For "+sports[i].name+" ,the number of players is "+sports[i].numberOfPlayer);
    }
}
