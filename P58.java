
public class P58 {
	
	 public static int lengthOfLastWord(String s) {
	        int count=0,space=0;
	        for(int i=s.length()-1;i>=0;i--){
	        	if(s.charAt(i)==' '){
	        		space++;
	        	}else
	        		break;
	        }
	        for(int i=s.length()-space-1;i>=0;i--){
	            if(s.charAt(i)!=' ')
	                count++;
	            else 
	            	break;
	        }
	        return count;
	    }

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("a "));

	}

}
