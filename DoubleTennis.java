/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw1.Q2;

/**
 *
 * @author n9e
 */
public class DoubleTennis extends Tennis {
    public DoubleTennis(){
            name = "doubles tennis";
            numberOfPlayer = 2;
            
    
    }
    public DoubleTennis(String name, int numberOfPlayer, String ScoringWay){
   
            this.name = name;
            this.numberOfPlayer = numberOfPlayer;
            this.scoringWay = ScoringWay;
    }
}
