import java.util.HashMap;
import java.util.Scanner;

public class PageOneP1 {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			int num2=target-nums[i];
			if(map.containsKey(num2) && map.get(num2)!=i){
				return new int []{map.get(num2),i};
			}
			map.put(nums[i], i);
		}
		return nums;
    }

	public static void main(String[] args) {
		int a[]=new int[2];
		int nums []=new int[6];
		Scanner sc= new Scanner(System.in);
		for(int z=0;z<4;z++){
			nums[z]=sc.nextInt();
		}
		
		a=twoSum(nums,9);
		System.out.println(a[0]);
		System.out.println(a[1]);

	}

}
