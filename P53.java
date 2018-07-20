
public class P53 {
	
	public static int maxSubArray(int[] nums) {
		int sum=nums[0],sum_so_far=nums[0],start=0,end=0,s=0;
		
		for(int i=0;i<nums.length;i++){
			sum_so_far=sum_so_far+nums[i];
			if(sum_so_far<0){
				sum_so_far=0;
				s=i+1;
			}
			else if(sum_so_far>sum){
				sum=sum_so_far;
				start=s;
				end=i;
			}
		}
		System.out.println(start);
		System.out.println(end);
        return sum;
    }

	public static void main(String[] args) {// TODO Auto-generated method stub
		int [] a={-1};
		System.out.println(maxSubArray(a));
	}

}
