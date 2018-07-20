
public class P66 {
	
	 public static int[] plusOne(int[] digits) {
		    
	        String str="",s2="";
	        String value;
	        for(int i=0;i<digits.length;i++){
	        	value=String.valueOf(digits[i]);
	        	str=str+value;
	        }
	        int add=0;
	        try{
	        	add=(Integer.parseInt(str))+1;
	        }catch(NumberFormatException e){
	        	e.printStackTrace();
	        }
	        String s=String.valueOf(add);
	        if(s.length()==digits.length){
	        	int arr[]=new int [digits.length];
	        	for(int j=0;j<s.length();j++){
		        	s2=Character.toString(s.charAt(j));
		        	arr[j]=Integer.valueOf(s2);
		        }
	        	return arr;
	        }else{
	        	int arr[]=new int [digits.length+1];
	        	for(int j=0;j<s.length();j++){
		        	s2=Character.toString(s.charAt(j));
		        	arr[j]=Integer.valueOf(s2);
		        }
	        	return arr;
	        }
	        	
	 }

	public static void main(String[] args) {
		int arr []={9,8,7,6,5,4,3,2,0};
		int [] result=plusOne(arr);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
		System.out.println();

	}

}
