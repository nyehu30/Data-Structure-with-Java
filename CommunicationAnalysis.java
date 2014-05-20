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
public class CommunicationAnalysis {
 



    public CommunicationAnalysis() {
    }

    public boolean isAFlaggedWord(String actualWord, String keyWord) {
        MyHashTable<Character, Integer> actualWordTable = new MyHashTable<>(11, 10);
        MyHashTable<Character, Integer> keyWordTable = new MyHashTable<>(11, 10);

        actualWord = actualWord.toLowerCase();
        keyWord = keyWord.toLowerCase();

        for (int i = 0; i < actualWord.length(); i++) {

            if (actualWordTable.contains(actualWord.charAt(i))) {
                int count = actualWordTable.get(actualWord.charAt(i));
                actualWordTable.put(actualWord.charAt(i), count + 1);
             
            } else {
                actualWordTable.put(actualWord.charAt(i), 1);
            }
        }


        for (int i = 0; i < keyWord.length(); i++) {
            if (keyWordTable.contains(keyWord.charAt(i))) {
                int count = keyWordTable.get(keyWord.charAt(i));
                keyWordTable.put(keyWord.charAt(i), count + 1);

            } else {
                keyWordTable.put(keyWord.charAt(i), 1);
            }
        }

        if (actualWordTable.size() != keyWordTable.size()) {
            return false;
        }
        
        for (int i = 0; i < actualWord.length(); i++) {
            if (actualWordTable.get(actualWord.charAt(i)) != keyWordTable.get(actualWord.charAt(i))) {
                return false;
            }
        }

//        for (int i = 0; i < actualWordTable.getKeys().size(); i++) {
//            if (!actualWordTable.getKeys().get(i).equals(keyWordTable.getKeys().get(i))) {
//                return false;
//            }
//        }

        return true;
    }

    public boolean isAFlaggedWord(String actualWord, List<String> keyWords) {

        
        for (int i = 0; i < keyWords.size(); i++) {
            String keyWord = keyWords.get(i);
            if (isAFlaggedWord(actualWord, keyWord)) {
                return true;
            }
        }

        return false;
    }

    public boolean isAThreat(Communication email, List<String> keyWords) {
//        System.out.println("email in isAThreat " + email.words);
//        System.out.println("keyWords in isAThreat" + keyWords); 
//        System.out.println("");
//        List<String> wordsInEmail  = email.words;
//        
//        for (String word : wordsInEmail) 
//        {
//           for (String keyword : keyWords)
//           {
//                if (isAFlaggedWord(word, keyword)) 
//                {
//                    return true;
//                }
//                
//               
//           }
//                       
//        }
        
        for(int i = 0; i < email.words.size(); i++)
        {
//            System.out.println("email.words at i = " + i + " " + email.words.get(i));
            for(int j = 0; j < keyWords.size(); j++)
            {
//                System.out.println("keywords at j = " + j + " " + keyWords.get(j));
                
                  if (isAFlaggedWord(email.words.get(i), keyWords.get(j))) 
                {
//                    System.out.println("happy");
                    return true;
                }
            }
        }    
//         System.out.println("unhappy");
         return false;

    }

    public MyHashTable<String, Integer> getThreatAnalysis(Communication email, List<String> keyWords)
    {
        MyHashTable<String, Integer> keyWordsFound = new MyHashTable<>(10,11);
        for(int i = 0; i < keyWords.size(); i++ )
        {
            String keyWord = keyWords.get(i);
            
            for(int j = 0; j < email.words.size(); j++)
            {
               String emailWord = email.words.get(j);
               if (isAFlaggedWord(keyWord, emailWord))
               {    
                if(keyWordsFound.contains(keyWord))
                {
                    int keyWordCount = 0;
                    keyWordCount = keyWordsFound.get(keyWord);
                    keyWordsFound.put(keyWord, keyWordCount+1 );
                } 
                else
                {
                    keyWordsFound.put(keyWord, 1);
                } 
               } 
            }    
        }    
       return keyWordsFound; 
        
    }
}
