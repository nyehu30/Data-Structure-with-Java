/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw1.Q2;

/**
 *
 * @author n9e
 */
public class Sport {
    
    public String name ;
    public int numberOfPlayer;
    public String scoringWay;
    
    public Sport(){}
    
    
    
    public Sport(String name, int numberOfPlayer, String scoringWay){
    this.name = name;
    this.numberOfPlayer = numberOfPlayer;
    this.scoringWay = scoringWay;
    }
    
    public int getNumberOfPlayers(){
        return numberOfPlayer;
    }
      
    public String getScoringWay(){
        return scoringWay;
    }
    
    
    @Override 
    public String toString(){
            
        String s = name.toLowerCase();
        return s;
    }

    public void print(){
        System.out.println();
    }
}
