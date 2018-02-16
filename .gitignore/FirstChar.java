import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class firstRepeatingChar {
	private static String method(String s) {
		char firstUniqueChar = 0;
		LinkedHashMap<Character,Integer> lhs=new LinkedHashMap<Character,Integer>();
		
		for(int i=0;i<s.length();i++){
			if(lhs.containsKey(s.charAt(i))){
				firstUniqueChar=s.charAt(i);
			}else{
				lhs.put(s.charAt(i), 1);
			}
		}
		
		return ""+firstUniqueChar;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String c=method(s);
		System.out.println(c);
	}

}
