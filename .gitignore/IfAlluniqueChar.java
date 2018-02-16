import java.util.Scanner;

public class IfAlluniqueChar {
	private static boolean is_unique_char_string(String str) {
		int[] count=new int[256];
		for(int i=0;i<str.length();i++){
			count[str.charAt(i)]++;
		}
		for(int j=0;j<count.length;j++){
			if(count[j]>1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str=sc.nextLine(); 
		boolean value=is_unique_char_string(str);
		if(value)
			System.out.print("Unique String");
		else
			System.out.print("Contains Duplicacy");

	}

	

}
