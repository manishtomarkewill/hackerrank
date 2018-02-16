import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Word {

    static int camelcase(String s) {
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) >='A' && s.charAt(i) <='Z')
            	count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int result = camelcase(s);
        System.out.println(result);
        in.close();
    }
}
