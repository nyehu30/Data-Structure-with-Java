/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw1.Q2;

/**
 *
 * @author n9e
 */
public class Volleyball extends Sport {
    public Volleyball(){
            name = "volleyball";
            numberOfPlayer = 6;
            scoringWay = "best of 3 Games";
    
    }
    public Volleyball(String name, int numberOfPlayer, String ScoringWay){
  
            this.name = name;
            this.numberOfPlayer = numberOfPlayer;
            this.scoringWay = ScoringWay;
    }
}
