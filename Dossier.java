/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author n9e
 */
public class Dossier implements Comparable<Object> {
    
    public String name = "";
    public Database database = new Database(){};
    public List<String> keyWords = new ArrayList<>();
    public List<String> criminalAssociations = new ArrayList<>();
    public MyHashTable<String, Integer> flagCounts = new MyHashTable<>(10,11);
    public MyHashTable<String, Integer> knownAssociates = new MyHashTable<>(10,11);
    public int numberOfKnownCriminalViolations = 0;
    public MyHashTable<String, Integer> numberOfFriendsCriminalViolations = new MyHashTable<>(10,11);
    public String password = "";
    public MyHashTable<String, String> friendsPasswords = new MyHashTable<>(10,11);
    
   
    
    public Dossier(String name, Database database, List<String> keyWords)
    {
        this.name = name;
        this.database = database;
        this.keyWords = keyWords;  
    }
    
    
    public int getThreatLevel()
    {
        int threatLevel = 0;  
        int sumOfFlagCounts = 0;
             
        int sumOfThreatLevelsOfFriends = 0;     
        int numberOfPeopleInEachGroup = 0;
       
                List<Integer> flagCountsList = flagCounts.getValues();
                for(Integer flagCount : flagCountsList)
                {
                    sumOfFlagCounts += flagCount;
                }    
//         System.out.println("alice.flagCount " + sumOfFlagCounts);
//         System.out.println("numberOfKnownCriminalViolations " + numberOfKnownCriminalViolations);
//         System.out.println("criminalAssociations " + criminalAssociations);

                for(int index = 0; index < knownAssociates.size(); index++)
                {    
                    
                    int associationCount = knownAssociates.getValues().get(index); 
                    String associateName = knownAssociates.getKeys().get(index);
                    if ( numberOfFriendsCriminalViolations.contains(associateName))
                    {    
                        int numberOfCriminal = numberOfFriendsCriminalViolations.get(associateName);
                        int associateThreatCount = associationCount*numberOfCriminal;
                        sumOfThreatLevelsOfFriends += associateThreatCount;
                    }
                    
                }    
                
//                System.out.println("sumOfThreatLevelsOfFriends " + sumOfThreatLevelsOfFriends);
                
                for(int x = 0; x < criminalAssociations.size(); x++ )
                {
                    numberOfPeopleInEachGroup += database.fellowTravelers.get(criminalAssociations.get(x)).size();
                }
                         
//                System.out.println(" numberOfPeopleInEachGroup " +  numberOfPeopleInEachGroup);
//                System.out.println("");
//                        
        threatLevel = sumOfFlagCounts + numberOfKnownCriminalViolations + criminalAssociations.size() + numberOfPeopleInEachGroup + sumOfThreatLevelsOfFriends; 
        return threatLevel;
    }        
    
    public void loadFromDatabase()
    {
        CommunicationAnalysis bookExamination = new CommunicationAnalysis();
        
        //List<String> criminalAssociations    
            
         criminalAssociations = database.criminalAssociations.get(name); //should be ok
         
           
        // MyHashTable<String, Integer> knownAssociates  
         
         for(String groupName : criminalAssociations)
         {            
             List <String> groupMembers = database.fellowTravelers.get(groupName);
             for(String groupMember : groupMembers)
             {
                 
                 if(knownAssociates.contains(groupMember))
                 {
                     int associationLevel = knownAssociates.get(groupMember);
                     if (groupMember.equals(name))
                     continue;
                     knownAssociates.put(groupMember, associationLevel+1);
                 } 
                 else
                 {
                     if (groupMember.equals(name))
                     continue;
                     knownAssociates.put(groupMember, 1);
                 }    
             }    
         }


           
        //MyHashTable<String, Integer> flagCounts from bookcheckout history


           List<String> booksCheckedOut = database.libraryCheckoutHistory.get(name);
           
           for( String book : booksCheckedOut )
           {
               List<String> bookContent = database.bookContents.get(book);
               
               for (String string: bookContent)
               {
                   boolean isAFlaggedWord =  bookExamination.isAFlaggedWord(string, keyWords); 
                   
                   if(isAFlaggedWord)
                   {

                       if(flagCounts.contains(string))
                        {
                            int valueInFlagCounts = flagCounts.get(string);
                            flagCounts.put(string,  valueInFlagCounts + 1);
                        } 
                        else
                        {
                            flagCounts.put(string, 1);
                        }    
                   }    
               }    
           }    
           
                    
            
     // int numberOfKnownCriminalViolations;
         
        
            numberOfKnownCriminalViolations = database.criminalHistory.get(name); //should be ok  
           
    
            
           
     // String password
           
            password = database.password.get(name); //should be ok
           
           
     //MyHashTable<String, String> friendsPasswords 
          
           
           List<String> friendsNames = knownAssociates.getKeys();
           
           for( String friend: friendsNames)
           {
               if( database.password.contains(friend))
               {    
                    String friendPassword = database.password.get(friend);
                    if (friend.equals(name))
                    continue;    
                    friendsPasswords.put(friend, friendPassword);
               }
           }    
          
        
    // MyHashTable<String, Integer>  numberOfFriendsCriminalViolations 
           
          for (String friend : friendsNames)
          {
              if( database.criminalHistory.contains(friend) )
              {    
                    int numberOfFriendsCrime = database.criminalHistory.get(friend);
                    if (friend.equals(name))
                    continue;
                    numberOfFriendsCriminalViolations.put(friend, numberOfFriendsCrime);
              }
          }    
        
        
        
               
        
    }        
    
    public void processEmails(List<Communication> emails)
    {
        CommunicationAnalysis emailsExamination = new CommunicationAnalysis();
        MyHashTable<String, Integer> keyWordsFoundInEmails = new MyHashTable<>(10,11);
          

         
        for ( Communication email : emails)  
        {
             keyWordsFoundInEmails = emailsExamination.getThreatAnalysis(email, keyWords);
             List<String> keySet = keyWordsFoundInEmails.getKeys();
             
             for (String key : keySet)
             {
                int flagCountInEmail = keyWordsFoundInEmails.get(key);
                if(flagCounts.contains(key))
                {
                    
                    int valueInFlagCounts = flagCounts.get(key);
                    flagCounts.put(key,  valueInFlagCounts + flagCountInEmail);
                } 
                else
                {
                    flagCounts.put(key, flagCountInEmail);
                }     
                 
             }
        }    
              


        
      for ( Communication email : emails) 
      {
           boolean isAThreat = emailsExamination.isAThreat(email, keyWords);
//           System.out.println("keyWords " + keyWords);
//           System.out.println("email " + email.words + " " + isAThreat);
                if(isAThreat)
                {      
//                    System.out.println("in here!");
                       String associateName =  email.receiverName; 
                       String associatePassword =  database.password.get(associateName);
                       int numberOfAssociateCriminalViolation = database.criminalHistory.get(associateName);
                    
                        if(knownAssociates.contains(email.receiverName))
                        {
//                            System.out.println("receiver already known " + email.receiverName);
                            int associatesCount = knownAssociates.get(email.receiverName);
//                            System.out.println("known asscoiate count " + associatesCount);
                            
                                knownAssociates.put(email.receiverName, associatesCount+1);  
//                                System.out.println("updated associate " +  knownAssociates.get(email.receiverName));                           
                        }                                                  
                        else
                        {
                            knownAssociates.put(email.receiverName, 1);
                            friendsPasswords.put(email.receiverName, associatePassword); 
                            numberOfFriendsCriminalViolations.put(email.receiverName, numberOfAssociateCriminalViolation);

                        }    
                       
                }
      }    
            
        
        
        
     
       
         
    } 

    @Override
    
    public String toString()
    {
        return Integer.toString(getThreatLevel());
    } 
    
    @Override
    
    public int compareTo(Object o)
    {
        if(getThreatLevel() > ((Dossier)o).getThreatLevel())
        {
            return 1;
        }
        else if( getThreatLevel() < ((Dossier)o).getThreatLevel())
        {
            return -1;
        } 
        else
        {
            return 0;
        }
    }        
}
