
public class NumberAsBits {

    private Bit[] bits;

    public NumberAsBits(Bit[] bits) {
        this.bits = new Bit[bits.length];
        
    	for(int i = 0 ; i < bits.length ; i++) {
    		//For each in the array: if the value is 1/0 create an object(Bit) with the value true/false in the corresponding place in Bit[].
    		if(bits[i].toInt()==1) 
    			this.bits[i] = new Bit(true); 
    		
    		else
    			this.bits[i] = new Bit(false);
    	}
    }



    public String toString() { 
        String sum = "";
        String num = "";
        int baseCounter = 0;
        //the decimal value is equal to the sum of the following: bit value * base^(the location of the digit, when the digit in the units place is the first one(0), and so on)
        for(int i = this.bits.length - 1 ; i >=0  ; i--) {
        	if(bits[i].toInt()==1) {
        		num = String.valueOf(this.bits[i].toInt());
        		for(int h = 0 ; h< baseCounter; h++) 
        			num = multiplyBy2(num);
        		sum = addition(num,sum);
        	}
        	baseCounter++;
        }
        if(sum.isEmpty())//If the sum is zero return 0.
        	sum = "0";
        return sum;
    }
    
  //This function gives the result of the addition of both numbers in String representation.
    private String addition(String num1, String num2) {//Assumes num1 is bigger than num2.
    	String ans = "";
    	int temp = 0;
    	int carry = 0;
    	//Combining the numbers until we reach to the end of the smaller(num2) number.
    	for(int i = num1.length()-1, j=num2.length()-1; j>=0 ;i--,j--) {
    		temp =  (num1.charAt(i)-'0') + (num2.charAt(j)-'0') + carry;
    			if(temp>=10) {//If the the result of the addition is bigger than 10, insert the last digit and insert 1 to carry.
    				ans = temp%10 + ans;
    				carry = 1;
    				if(i==0)//If we reached to the end of num2 and we have a carry then add it to the string.
        	    		ans = carry + ans;
    			}
    			else {//Else insert the  digit and assign 0 to the carry. 
    				carry = 0;
    				ans = temp + ans;
    			}
    	}

        	for(int c = num1.length()-num2.length()-1 ; c >=0 ; c--) {//Finishing the rest of remaining addition.(only for num1).
        		temp =  (num1.charAt(c)-'0')  + carry;
        	   	if(temp>=10) {//If the the result of the addition is bigger than 10, insert the last digit and insert 1 to carry.
        	    	ans = temp%10 + ans;
        	    	carry = 1;
        	    	if(c==0) //If we reached to the end of num1 and we have a carry then add it to the string.
        	    		ans = carry + ans;
        	    	}
        	    	else {//Else insert the  digit and assign 0 to the carry. 
        	    		carry = 0;
        	    		ans = temp + ans;
        	    	}
        		}
    			
     	return ans;
     	}
    	
    

    private String multiplyBy2(String a) {
    	String ans = "";
    	int temp = 0;
    	int carry = 0;
    	int multiplier = 2;//Multiplier which is always 2.
    	for(int i = a.length()-1 ; i >= 0  ; i--) {
    		temp = (a.charAt(i)-'0') * multiplier + carry;
    		if(temp>=10) {//If the the result of the multiplication is bigger than 10, insert the last digit and insert 1 to carry.
    			ans = temp%10 + ans;
    			carry = 1;
    			if(i==0)//If we reached to the end and we have a carry then add it to the string.
    				ans = carry + ans;
    		}
    		else {//Else insert the  digit and assign 0 to the carry. 
				carry = 0;
				ans = temp + ans;
			}
    			
    	}
    	return ans;
    }
   
    
    public String base2() {
        String ans ="";
        
        for(int i = 0; i < this.bits.length; i++) {
        	ans = ans + this.bits[i].toInt();
        }
        return ans;
    }
    
    public static void main (String [] args) {
    	Bit bitT = new Bit(true);
    	Bit[] bits = { bitT, new Bit(false), new Bit(false), new Bit(false),new Bit(false),new Bit(false),new Bit(true)};
    	NumberAsBits number = new NumberAsBits (bits);
    	//System.out.println(number.toString()); // 
    //	System.out.println(number.base2()); // 1000
    	bitT = new Bit(false);
    	bits[1] = new Bit(true);
    //	System.out.println(number.toString()); // 8
    //	System.out.println(number.base2()); // 1000
    	Bit[] bits1 = {  new Bit(true), new Bit(false), new Bit(false),new Bit(false),new Bit(false),new Bit(true),new Bit(false)
    			, new Bit(false), new Bit(true), new Bit(false), new Bit(false),new Bit(false),new Bit(false),new Bit(true)
    			,new Bit(false), new Bit(false), new Bit(true), new Bit(false), new Bit(false),new Bit(false),new Bit(false)
    			,new Bit(true),new Bit(false), new Bit(false), new Bit(true), new Bit(false), new Bit(false),new Bit(false),
    			new Bit(false),new Bit(true),new Bit(false), new Bit(false), new Bit(true), new Bit(false), new Bit(false),
    			new Bit(false),new Bit(false),new Bit(true),new Bit(false), new Bit(false), new Bit(true), new Bit(false), 
    			new Bit(false),new Bit(false),new Bit(false),new Bit(true),new Bit(false), new Bit(false), new Bit(true),
    			new Bit(false), new Bit(false),new Bit(false),new Bit(false),new Bit(true),new Bit(false), new Bit(false),
    			new Bit(true), new Bit(false), new Bit(false),new Bit(false),new Bit(false),new Bit(true),new Bit(false), 
    			new Bit(false), new Bit(true), new Bit(false)
    			, new Bit(false),new Bit(false),new Bit(false),new Bit(true),new Bit(false), new Bit(false)};
    //	Bit[] bits2 = new Bit[500];
    //	for(int i = 0; i < bits2.length ; i = i+2) {
   //		bits2[i] = new Bit(true);
    //		bits2[i+1] = new Bit(true);
    //	}
    	Bit[] bits3 = { new Bit(false)};
    		
   		NumberAsBits number1 = new NumberAsBits (bits1);
    	System.out.println(number1.toString() + "this is"); // 
    //	System.out.println(number1.base2()); // 1000
   // 	System.out.println(number1.binarytoDecimal(number1.get()));
   // 	String s1 = "9991";
   // 	System.out.println(s1.charAt(s1.length()-2) );
    	
    //	System.out.println(addition("123","78"));
    //	System.out.println(multiplyBy2("55454545"));
    //	String s3 = "abfd";
    //	s3 = "a" + s3;
    //	System.out.println(s3);
    //	System.out.println(addition("111111", "99"));

    	

    	
    	

    	
    }
    //Bit[] bits = { new Bit(true) , new Bit(true) , new Bit(true) , new Bit(false), new Bit(false) , new Bit(true)};
	//NumberAsBits a = new NumberAsBits(bits);
//	System.out.println(a.bits[0]);
	//System.out.println(a.bits[1]);
	//System.out.println(a.bits[2]);
	//System.out.println(a.bits[3]);
	//System.out.println(a.toString());
	//System.out.println(a.base2());
    //  public String toString() { 
    //     String ans ="";
     //    int sum = 0;
       //  for(int i = this.bits.length - 1 ; i >=0  ; i--) {
         //	if(bits[i].toInt()==1)
         //		sum = (int) (sum + Math.pow(2, this.bits.length - 1 - i));
         //}
         //ans = ans + sum;
         //return ans;
     //}
}


