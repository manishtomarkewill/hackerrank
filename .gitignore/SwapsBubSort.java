import java.io.*;
import java.util.*;

public class SwapsBubSort {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
        	a[i]=sc.nextInt();
        }
        int swaps=0;
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                	swaps++;
        			int temp=a[j+1];
        			a[j+1]=a[j];
        			a[j]=temp;
                }
            }
            
        }
       
        System.out.printf("Array is sorted in %d swaps. \nFirst Element: %d \nSecond Element: %d \n",swaps,a[0],a[n-1]);
    }
}