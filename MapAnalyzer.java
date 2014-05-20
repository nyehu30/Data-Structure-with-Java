/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci1902hw1.Q5;

/**
 *
 * @author n9e
 */
public class MapAnalyzer {
      
    public int[][] getDesirabilityMap(char[][] terrainMap)
    {               
        int desirabilityMap[][] = new int[terrainMap.length][terrainMap[0].length];
//        System.out.println("The size of the array is "+desirabilityMap.length + " " + desirabilityMap[0].length);
        int featureValue = 0;
        int propagationDistance = 0;
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0; 
        int xStartDistance = 0;
        int yStartDistance = 0;
        int updatedStartX = 0;
        int updatedStartY = 0;
        int updatedEndX = 0;
        int updatedEndY = 0;
        int distance = 0;
//        System.out.println("----------------------------------------------------");
//        for (int x = 0; x < terrainMap.length; x++) {
//		for (int y = 0; y < terrainMap[0].length; y++) {
//				System.out.print(terrainMap[x][y] + " ");
//			}
//			System.out.println();
//		}
//        System.out.println("----------------------------------------------------");
        for(int i = 0; i < terrainMap.length; i++) 
        {  
            for(int j = 0; j < terrainMap[0].length; j++)
            {  
                if (terrainMap[i][j] != ' ')
                {    
                switch (terrainMap[i][j]) 
                {
                    case 'T':
                        featureValue = 8;
                        propagationDistance = 2; 
//                        System.out.println("The feature is 'T'");
                        break;
                    case 'W':
                        featureValue = 2;
                        propagationDistance = 1;
//                        System.out.println("The feature is 'W'");
                        break;
                    case 'C':
                        featureValue = 16;
                        propagationDistance = 3;
//                        System.out.println("The feature is 'C'");
                        break;
                    case 'P':
                        featureValue = -8;
                        propagationDistance = 2;
//                        System.out.println("The feature is 'P'");
                        break;
        
                }        
//                        System.out.println("The location of the feature is " + i + " " + j );
                
                        startX = i - propagationDistance;
                        endX = i + propagationDistance;
                        startY = j - propagationDistance;
                        endY = j + propagationDistance;
                    
//                        System.out.println("startX = " +startX);
//                        System.out.println("startY = " + startY);
//                        System.out.println("endX   = " + endX); 
//                        System.out.println("endY   = "+ endY);
//                        System.out.println();
                    
                        updatedStartX = clamp(startX, terrainMap.length-1);
                        updatedStartY = clamp(startY, terrainMap[0].length-1);
                        updatedEndX = clamp(endX, terrainMap.length-1);        
                        updatedEndY = clamp(endY, terrainMap[0].length-1);
                    
//                        System.out.println("updatedStartX = " + updatedStartX);
//                        System.out.println("updatedStartY = " + updatedStartY);
//                        System.out.println("updatedEndX   = " + updatedEndX);
//                        System.out.println("updatedEndY   = " + updatedEndY);
//                        System.out.println();
                    
                    for(int x = updatedStartX; x <= updatedEndX; x++)
                        for (int y = updatedStartY; y <= updatedEndY; y++)
                        {
     
//                         desirabilityMap[x][y] = 0;   
                         xStartDistance = Math.abs(x - i);
                         yStartDistance = Math.abs(y - j); 
                         
//                         System.out.println("xStartDistance = "+ xStartDistance); 
//                         System.out.println("yStartDistance = "+ yStartDistance);   
//                         System.out.println();
                         
                         distance = Math.max(xStartDistance, yStartDistance);
                         desirabilityMap[x][y] += (int) (featureValue / Math.pow(2, distance));
//                         System.out.println("x = " +x +" y = " +y);
//                         System.out.println("desirabilityMap = " + desirabilityMap[x][y]);
                         
                        }                   
                }
             }    
        } 

        return desirabilityMap;
    }
            
            
   
    
    public int clamp(int startOrEnd, int maxValue)
    {
        if(startOrEnd < 0)
        {
            return 0;
        }
        if (startOrEnd > maxValue)
        {
            return maxValue;
            
        } else return startOrEnd;   
    }
    


    
    public GridPoint getBestPosition(char[][] terrainMap){
//        GridPoint bestPosition = new GridPoint();
        int[][] map = new int[terrainMap.length][terrainMap[0].length];
        int max = map[0][0];
        int bestPositionX = 0;
        int bestPositionY = 0;
        map = getDesirabilityMap(terrainMap); 
        for(int i = 0; i < terrainMap.length; i++) 
        {  
            for(int j = 0; j < terrainMap[0].length; j++)
            {  
                if ( terrainMap[i][j] == 'T'|| terrainMap[i][j] == 'W'|| terrainMap[i][j] == 'C' || terrainMap[i][j] == 'P')
                {                  
                map[i][j] = 0;
                }
            }
        }    
        
//        System.out.println("----------------------------------------------------");
//        for (int x = 0; x < map.length; x++) {
//		for (int y = 0; y < map[0].length; y++) {
//				System.out.print(map[x][y] + " ");
//			}
//			System.out.println();
//		}
//        System.out.println("----------------------------------------------------");
        
        for(int x = 0; x < map.length; x++) 
        {  
            for(int y = 0; y < map[0].length; y++)
            {  
                if(map[x][y] > max)
                {
                  max = map[x][y];
                  bestPositionX = x;
                  bestPositionY = y;
                }  
//         System.out.println("the best position is " + bestPositionX + " "+ bestPositionY);          
            }
        }   
//         System.out.println("the best position is " + bestPositionX + " "+ bestPositionY);                     
        return new GridPoint(bestPositionX,bestPositionY);
    }
            
            

}
