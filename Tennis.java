/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw1.Q2;

/**
 *
 * @author n9e
 */
public class Tennis extends Sport {
    public Tennis(){
            
            scoringWay = "best of 2 Sets";
    
    }
    public Tennis(String name, int numberOfPlayer, String ScoringWay){
  
            this.name = name;
            this.numberOfPlayer = numberOfPlayer;
            this.scoringWay = ScoringWay;
    }
    
}
