
class Part2_Change{
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
		
		else 
			ans = change(coins, n - coins[index], index) || change(coins, n, index+1);

		return ans;
	}
    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        //Task 2.4
    	return countChangeLimited(coins,n,numOfCoinsToUse,0);
        
    }
    ////count the different solutions we have.
    public static int countChangeLimited(int [] coins, int n , int numOfCoinsToUse, int index) {
		int ans = 0;

		if(n == 0 & numOfCoinsToUse==0) 
			ans = 1;
		else if (n < 0 | index == coins.length)
			ans = 0; 
		else 	//when i "take" the coin i subtract it by one and when i skip the coin i don't substract one for numOfCoins.
			ans = countChangeLimited(coins, n - coins[index],numOfCoinsToUse-1, index) + countChangeLimited(coins, n,numOfCoinsToUse, index+1); 
	
		return ans;
	}

    public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse){
    	String accumulator = ""; // This array will represent our solutions
    	if(change(coins,n))  //if we can give change with the given coins go into the function 
    		printAllChangeLimited(coins,n,numOfCoinsToUse,0, accumulator);
    }
    

    public static boolean printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse,int index,String accumulator){//nextavailableIndex is a pointer for the next available cell in []solution.
    	boolean ans = false;

		if (n < 0 | index == coins.length) //Stop case
			ans = false; 
		
		else if(n == 0 & numOfCoinsToUse==0 ) {//Desired term for solution
			System.out.println(accumulator.substring(0, accumulator.length()-1)); //Prints the entire accumlator except the last "," at the end.
			 ans = true;
			}	
		
		else  //If we take the coin go into the function with one less coin,raise the index by one, substract the coin from n, and add it to accumlator.
			ans = printAllChangeLimited(coins, n,numOfCoinsToUse, index+1,accumulator) | printAllChangeLimited(coins, n - coins[index],numOfCoinsToUse-1, index,accumulator+ coins[index] +",");
    		
		return ans;
    }

    public static int currencyConverter(int cuc) {//Convert CUC to CUP
    	return cuc*3; 
    }

    public static int changeInCuba(int cuc){
    	int [] cucCoins = {1,3,5,10,20,50,100};
    	int [] cupCoins = {1,3,5,10,20,50,100};
    	int [] bothCoins = new int [cucCoins.length + cupCoins.length]; //Create one array with both coin systems with proportional values.
    	//Fill the array with both coins.
    	for(int i = 0; i < cucCoins.length;i++)	
    		bothCoins[i] = cucCoins[i];
    	for(int i = cucCoins.length , j=0; i < bothCoins.length;i++,j++)
    		bothCoins[i] = currencyConverter(cucCoins[j]);
    	
        return changeInCuba(bothCoins,currencyConverter(cuc),0);
    }
    public static int changeInCuba(int [] coins,int cuc,int index){
        int ans = 0;
        if (cuc < 0 | index == coins.length )
			ans = 0; 
		
		else if(cuc == 0) 
		 ans = 1;
		
		else 
			ans = changeInCuba(coins, cuc - coins[index], index)+ changeInCuba(coins, cuc, index+1);

		return ans;
    }
	
	
		

    public static void main(String[] args){
    	int [] coins = {1,3,5,10,20,50,100};
    	int n = 3020;
    	int numOfcoins = 120; 
    	printAllChangeLimited(coins, n, numOfcoins);
    	//int cuc = 100;
    	//System.out.println(changeInCuba(cuc));
    }
}
