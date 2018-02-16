import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveAllDupliactesString {

	private static void removeAllDupliactes(String str) {
		LinkedHashSet<Character> lhs= new LinkedHashSet<Character>();
		for(int i=0;i<str.length();i++){
			lhs.add(str.charAt(i));
		}
		for(Character c:lhs){
			System.out.print(c);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str=sc.nextLine(); 
		removeAllDupliactes(str);

	}

	

}
