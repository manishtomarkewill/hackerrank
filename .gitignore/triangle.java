import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class triangle {
    public static void main(String args[] )
        {
            int[] s = new int[9];   
	        Scanner sc = new Scanner(System.in);
	        for (int i = 0; i < s.length; i++) {
	             s[i] = sc.nextInt();
	        }
            for(int i=0;i<s.length;){
            	if(( s[i]== s[i+1]) && ( s[i+1]== s[i+2]))
                {
                   System.out.println("Equilateral");
                }
                else if (( s[i] ==  s[i+1]) & ( s[i+1] !=  s[i+2]) || ( s[i+1] ==  s[i+2]) & ( s[i+2]!=  s[i]))
                {
                    System.out.println("Isosceles");
                }
     
                     
                     else if(( s[i] !=  s[i+1]) & ( s[i+1] !=  s[i+2]))
                     {
                        System.out.println("Scalene");
                     }
     
            else
            {
                System.out.println("None of these");
            }
            	i=i+3;
            }
            
}}