import java.io.*;
import java.util.*;

public class ReverseArr {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        reverse(a,n);
    }

	private static void reverse(int[] a,int n) {
		for(int i=0;i<n/2;i++){
			int temp=a[i];
			a[i]=a[n-1-i];
			a[n-1-i]=temp;
		}
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
		}
	}
}