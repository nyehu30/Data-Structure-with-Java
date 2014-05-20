package csci1902hw1.Q1;

/**
 * HW1 Q1.
 *
 * @author n9e
 */
public class FunctionalityTest
{
        public int add(int a, int b) {
                
                return a + b;
        }// passed
	/**
	 * Fix compilation issues. This method does not compile. Make sure it does.
	 *
	 * @param numbers An array of integers.
	 * @return int Mean of the passed in array of numbers.
	 */
	public int calculateAverage(int numbers[])
	{
		int sum = 0;
		for (int number = 0 ; number < numbers.length; number ++)
		{
			sum = sum + numbers[number];
                }			
		int mean = sum / numbers.length;
		return mean; // passed
	}
                
        
        public boolean canLegallyDrink(int age) {
            
            return (age >= 21); // passed
        }
        public int convertToInt(double someDouble) { 
            
            return(int)someDouble; // passed
        }
        
        public int convertToInt(String number) {
            
            return Integer.parseInt(number); // passed
        }
        
        public int getLength(float[] anArray) {
            
            return anArray.length; // passed
        }
        
        public int getLength(String aString) {
            
            return aString.length(); // passed
        }
        
        public float getPercentFailing(float[] grades) {
            if (grades.length == 0){
               return 0f; 
            } else {
            int number = 0;
            for(int i = 0; i < grades.length; i++){
                if (grades[i] < 60)
                { number+=1;}   
            } 
            return (float)number/grades.length;
            }
        }// passed
            
        public Puppy getPuppy() {
            Puppy puppy;
            puppy = new Puppy("Teddy", 90);
            return puppy;// passed
        }
        
        public Puppy getPuppy(String name, int weight) {
            Puppy puppy;
            puppy = new Puppy(name, weight);
            return puppy ;// passed
        }
        
        public int getTotalWeight(Puppy[] bulkGoods) {
            int totalweight = 0;
            for (int i = 0; i < bulkGoods.length; i++ )
                totalweight+= bulkGoods[i].weight;
            return totalweight; // passed
        }
        
        public boolean isBob(String name) {
            return (name=="Bob"); // passed
        }
        
        public boolean isPassingEverything(int labGrade,int homeworkGrade, int examGrade) {
            if (labGrade>=70 && homeworkGrade >= 70 && examGrade >=70)
                return true;
            else 
                return false; // passed
        }
        public boolean isPassingSomething(int labGrade,int homeworkGrade, int examGrade) {
            
            if (labGrade>=70 || homeworkGrade >= 70 || examGrade >=70)
                return true;
            else 
                return false; // passed
        }
        
        public int raiseToPower(int base, int exponent) {
            
            return (int)Math.pow(base, exponent); // passed
        }
        
        public int remainder(int base, int divisor) {
            
            return base%divisor; // passed
        }
        
        public int predictIncome(int age) {
            
            if (age < 20)  {
            return 0;
        }
        else if(age < 30){
            return 20000;
        }
        else if(age < 40){
            return 40000;
        }
        else if(age < 50){
            return 50000;
        }
        else if(age < 60){
            return 70000;
        }
        else return 14000;
            
        } // passed
        
        public String sayHelloTo(String name) {
        
            if (name == "Bob"){
                return "Hello Bob";
            }
            else return "Hello "+name;
            }
        
            
        public boolean shouldSkipLine(String string) {
           
            string = string.trim();
            return (string.startsWith("#")||string.isEmpty());
            
        }

}
