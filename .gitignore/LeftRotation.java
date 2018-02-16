import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftRotation {

    static int[] leftRotation(int[] a, int d) {
    	int temp[]=new int[a.length];
    	 int mod = d % a.length;
    	 for(int i=0;i<a.length;i++){
    		temp[i]=a[(i+mod)%a.length];
     	}
    	return temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
        in.close();
    }
}
