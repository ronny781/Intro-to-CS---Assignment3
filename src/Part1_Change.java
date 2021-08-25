
class Part1_Change{

    public static boolean change(int [] coins, int n){
        //Task 2.1
        return change(coins,n , 0);
    }
    public static boolean change(int [] coins, int n , int index) {
		boolean ans = false;
		
		if (n < 0 | index == coins.length)
			ans = false; 
		
		else if(n == 0) 
			ans = true;
		
		else //if we take the coin substract if form n and raise by one our index,
			ans = change(coins, n - coins[index], index) || change(coins, n, index+1);

		return ans;
	}

    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse){
    	if(!change(coins,n)) //if we can't give change with any of the coins return false
    		return false;
    	else
    		return changeLimited(coins,n,numOfCoinsToUse, 0);//the zero argument is the index we want to start from in the array
        //Task 2.2
     
    }
    public static boolean changeLimited(int [] coins, int n , int numOfCoinsToUse, int index) {
		boolean ans = false;
		
		 if (n < 0 | index == coins.length) //Stop case
				ans = false; 
		 else if(n == 0 & numOfCoinsToUse==0) //Desired term for solution
			ans = true;
		 	
		 else 	//when i "take" the coin i subtract it by one and when i skip the coin i don't substract one for numOfCoins.
			ans = changeLimited(coins, n - coins[index],numOfCoinsToUse-1, index) || changeLimited(coins, n,numOfCoinsToUse, index+1); 
	
		return ans;
	}
    

    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse){
    	String accumulator = ""; // This array will represent our solutions
    	if(change(coins,n))  //if we can give change with the given coins go into the function 
    		printChangeLimited(coins,n,numOfCoinsToUse,0, accumulator);

    }
    


    
    public static boolean printChangeLimited(int[] coins, int n, int numOfCoinsToUse,int index,String accumulator){
    	boolean ans = false;

		if (n < 0 | index == coins.length) //Stop case
			ans = false; 
		
		else if(n == 0 & numOfCoinsToUse==0 ) {//Desired term for solution
			System.out.println(accumulator.substring(0, accumulator.length()-1)); //Prints the entire accumlator except the last "," at the end.
			 ans = true;
			}	
		
		else  //If we take the coin go into the function with one less coin,raise the index by one, substract the coin from n, and add it to accumlator.
			ans = printChangeLimited(coins, n,numOfCoinsToUse, index+1,accumulator) || printChangeLimited(coins, n - coins[index],numOfCoinsToUse-1, index,accumulator+ coins[index] +",");
    		
		return ans;
    }	




    public static void main(String[] args){
    	int [] coins = {1,2,3,5,6};
    	int n = 10;
    	int numOfcoins = 3; 
    	printChangeLimited(coins, n, numOfcoins);

    }
}
