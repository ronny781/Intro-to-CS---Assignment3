
public class binarytodec {
	 public static int recursive(String binaryNumber) {
	        int decimal = 0;
	        int length = binaryNumber.length();
	        if (length > 0) {
	            String substring = binaryNumber.substring(1);
	            int digit = Character.getNumericValue(binaryNumber.charAt(0));
	            decimal = digit * (int) Math.pow(2, length - 1) + recursive(substring);
	        }
	        return decimal;
	    }
	 public static void main(String [] args) {
		 System.out.println(recursive("10000000000000011111111111111111111111111111111111111111111111111"));;
	 }
}
