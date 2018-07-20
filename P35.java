
public class P35 {
	
	public static int searchInsert(int[] nums, int target) {
		int end=nums.length-1;
		int st=0;
		int mid=(end+st)/2;
		
		while(st<=end){
			if(nums[mid]==target)
				return mid;
			else if(nums[mid]>target)
				end=mid-1;
			else
				st=mid+1;
			mid=(st+end)/2;
			
			if(st>end){
				if(end<0){
					return mid;
				}
				return mid+1;
			}
			
		}
        return mid;
    }

	public static void main(String[] args) {
		int arr[]={1,3};
		int target=4;
		System.out.println(searchInsert(arr,target));

	}

}
