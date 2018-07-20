import java.util.Arrays;

public class p88 {
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
		 for(int i=0;i<n;i++){
			 nums1[m]=nums2[i];
			 m++;
		 }
		 Arrays.sort(nums1);
		 for(int i=0;i<m;i++){
			 System.out.print(nums1[i]+" ");
		 }
	 }

	public static void main(String[] args) {
		int num1[]={-1,0,0,3,3,3,0,0,0};
		int num2[]={1,2,2};
		merge(num1,6,num2,3);

	}

}
