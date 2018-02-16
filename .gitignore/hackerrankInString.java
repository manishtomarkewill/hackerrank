import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class hackerrankInString {

    static String hackerrankInAString(String s) {
    	String str="hackerrank";
    	String result="";
        for(int i=0,j=0;i<s.length();i++){
        	if(str=="" || str.equals(null)){
        		return "No";
        	}
        	if(j==str.length() || i==s.length())
        		break;
        	if(str.charAt(j)==s.charAt(i)){
        		result=""+result+str.charAt(j);
        		j++;
        	}
        }
        //System.out.println(result);
        if(result.equals("hackerrank"))
        	return "Yes";
        else
        	return "No";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = hackerrankInAString(s);
            System.out.println(result);
        }
        in.close();
    }
}
