
public class solve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Coins = {1,2,3};
		int n=4;
		int numOfCoinsToUse=2;
		printChangeLimited(Coins, n, numOfCoinsToUse);
	}
    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse){
    	int [] arr = new int[numOfCoinsToUse]; // This array will represent our solutions
    		printChangeLimited(coins,n,numOfCoinsToUse,0, arr);
    		for(int x:arr)
    			System.out.println(x);

    }
  
    public static boolean printChangeLimited(int[] coins, int n, int numOfCoinsToUse,int index,int[] arr){
    	boolean ans = false;

		if (n < 0 | index == coins.length) //Stop case
			ans = false; 
		
		else if(n == 0 & numOfCoinsToUse==0 ) {//Desired term for solution
			 ans = true;
			}	
		
		else if(printChangeLimited(coins, n,numOfCoinsToUse, index+1,arr)) 	
			ans = true;
		
		else if(printChangeLimited(coins, n - coins[index],numOfCoinsToUse-1, index,arr)){
			arr[index] = coins[index];
			ans = true;
		}

    		
		return ans;
    }	

}
