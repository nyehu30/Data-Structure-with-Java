/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw1.Q2;

/**
 *
 * @author n9e
 */
public class Soccer extends Sport {
    
    public Soccer(){
            name = "soccer";
            numberOfPlayer = 11;
            scoringWay = "scoring more goals during the Match";
    
    }
    public Soccer(String name, int numberOfPlayer, String ScoringWay){
//            super("soccer", 11, "scoring more goals during the Match");    
            this.name = name;
            this.numberOfPlayer = numberOfPlayer;
            this.scoringWay = ScoringWay;
    }
}
////        super("soccer", 11, "scoring more goals during the Match");    
////        name= "soccer";
////        numberOfPlayer = 11;
////        scoringWay = "scoring more goals during the Match";
    
    
//    public static void main(String args[]) {
//         Soccer soccer = new Soccer("soccer", 11,"scoring more goals during the Match" );
//         soccer.getNumberOfPlayers();
//         soccer.getScoringWay();
//         soccer.toString();
//}

