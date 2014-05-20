package csci1902hw1.Q3;

/**
 *
 * @author n9e
 */
public class Array {

    int i;
    
    //swaps value a and b of array, returns true if successfully swapped
    public boolean swap(int array[], int a, int b) {
        int first = 0; 
        if (array==null) {
            return false;
        } else if(a > array.length-1 || b > array.length-1) {
            return false;   
        }
        else{
         first = array[a];
         array[a]= array[b];
         array[b]= first;
            return false;
        }
        
//        public boolean swap(int array[], int a, int b) {
//          return array[b] == array[a] == array[b];
    } 

//returns a string with the contents of array
    public String print(int array[]) {
        String out="";
    
        if(array==null){ 
            return out;
        } else {
        
        for (i = 0; i < array.length; i++)
        out += array[i] + " ";

        return out;
        }
    } // passed

//adds all the values within array
    public int sum(int array[]) {
        int res = 0;
        if (array==null){
            return 0;
        }
        else {
        while (i < array.length) {
            res += array[i++];
        }
        return res;
        }
    }
}
