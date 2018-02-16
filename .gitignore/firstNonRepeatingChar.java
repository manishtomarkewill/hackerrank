import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class firstNonRepeatingChar {
	private static int method(String s) {
		char firstUniqueChar = 0;
		LinkedHashMap<Character,Integer> lhs=new LinkedHashMap<Character,Integer>();
		
		for(int i=0;i<s.length();i++){
			if(lhs.containsKey(s.charAt(i))){
				int value=lhs.get(s.charAt(i));
				value++;
				lhs.put(s.charAt(i), value);
			}else{
				lhs.put(s.charAt(i), 1);
			}
		}
		
		for(Entry<Character, Integer> entry : lhs.entrySet()){
			if(entry.getValue()>1){
				firstUniqueChar=entry.getKey();
				break;
			}
		}
		return s.indexOf(firstUniqueChar);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int c=method(s);
		System.out.println(c);
	}

}
