import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Pangram {
	static boolean is_pangram_string(String s){
		boolean finalflag=true;
	    s=s.replaceAll(" ", "").toLowerCase();
	    boolean flag[]=new boolean[26];
	    
	    for(int i=0;i<s.length();i++){
	    	flag[s.charAt(i)-97]=true;
	    }
	    for(int j=0;j<flag.length;j++){
	    	if(!flag[j])
	    		finalflag=false;
	    }
		return finalflag;
	}
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean result = is_pangram_string(s);
        if(result){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        }
    }
}
