import java.util.Scanner;

public class PrintDuplicateElements {

	private static  void print_duplicates(String str) {
		int[] count=new int[256];
		for(int i=0;i<str.length();i++){
			count[str.charAt(i)]++;
		}
		for(int j=0;j<count.length;j++){
			if(count[j]>1)
				System.out.printf("%c, count = %d \n", j, count[j]);
		}
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str=sc.nextLine(); 
		print_duplicates(str);
		

	}

}
