
public class Bit {

    private boolean value;

    public Bit(boolean value){
        this.value = value;
    }

    public int toInt(){ 
        int ans = 0;
        if(this.value==true)
        	ans = 1;
        
        return ans;
    }

    public String toString(){
        String ans = "";
        ans = ans + toInt();
        
        return ans;
    }

    public static void main(String[] args) {
    	 Bit b1 = new Bit(true);
    	 Bit b0 = new Bit(false);
    	 System.out.println(Bit.fullAdderCarry( b0, b0, b0)+" "+
    	 Bit.fullAdderSum( b0, b0, b0)); // prints 0 0
    	 System.out.println(Bit.fullAdderCarry( b1, b0, b0)+" "+
    	 Bit.fullAdderSum( b1, b0, b0)); // prints 0 1
    	 System.out.println(Bit.fullAdderCarry( b1, b1, b0)+" "+
    	 Bit.fullAdderSum( b1, b1, b0)); // prints 1 0
    	 System.out.println(Bit.fullAdderCarry( b1, b1, b1)+" "+
    	 Bit.fullAdderSum( b1, b1, b1)); // prints 1 1
    	}
}

