import java.util.Scanner;

public class MaxOccuring {

	private static  void print_duplicates(String str) {
		int[] count=new int[256];
		
		for(int i=0;i<str.length();i++){
			count[str.charAt(i)]++;
		}
		int max=-1;
		char result = 0;
		for(int i=0;i<str.length();i++){
			if(max<count[str.charAt(i)]){
				max=count[str.charAt(i)];
				result=str.charAt(i);
			}
		}
		System.out.printf("%c, count = %d \n", result, max);
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str=sc.nextLine(); 
		print_duplicates(str);
		

	}

}
