
package csci1902hw3;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author n9e
 */
public class ThreatPrioritizer {
    
    public List<Dossier> generateTop10List(List<Dossier> personsOfInterest)
    {
        List<Dossier> Top10List = new LinkedList<>();
        MyMaxHeap<Dossier> TopList = new MyMaxHeap<>(personsOfInterest);
        if(personsOfInterest.size() >= 10)
        {
            for(int i = 0; i < 10; i++)
            {    
                Top10List.add(TopList.pop());
            }
            
        } 
        else
        {
            for(int j = 0; j < personsOfInterest.size(); j++)
            {    
                Top10List.add(TopList.pop());
            }
        }   
        
        return Top10List;
    }        
}
