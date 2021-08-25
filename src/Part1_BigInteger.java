
import java.math.BigInteger;
import java.util.Random;

class Part1_BigInteger{

    public static BigInteger sumSmaller(BigInteger n){
        BigInteger sum =  new BigInteger("0");
        //Task 1.1
        for(BigInteger i = new BigInteger("0") ; i.compareTo(n) == -1; i = i.add(BigInteger.ONE)) {
        	sum = sum.add(i);
        }
        return sum;
    }

    public static void printRandoms(int n){
        //Task 1.2
    	Random rnd = new Random();
    	 for(int i = 0; i < n ;i++) {
    		 System.out.println(rnd.nextInt());
    	 }
    }


    public static   boolean isPrime(BigInteger n){
        boolean ans= true;
        //Task 1.3
        BigInteger sqrt = n.sqrt(); //we want to check until p*p<=n
        for(BigInteger p = new BigInteger("2") ; p.compareTo(sqrt) != 1; p = p.add(BigInteger.ONE))
        	if(n.mod(p).equals(BigInteger.ZERO))
        	ans =false;  
      
        return ans;
     	} 
    

    public static BigInteger randomPrime(int n){
    	 //Task 1.4
    	BigInteger randBig = new BigInteger("0");
        Random rnd = new Random();
        randBig = new BigInteger(n,rnd);
        	while(!isPrime(new BigInteger(""+randBig))) {
        		randBig = new BigInteger(n,rnd);
        		System.out.println(randBig);
        	}

        return randBig;
    }

    public static void main(String[] args) {
        System.out.println(sumSmaller(new BigInteger("0")));
     //   printRandoms(5);
       System.out.println(isPrime(new BigInteger("171")));
    //	System.out.println(randomPrime(15));
    }
}