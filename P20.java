import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P20 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		System.out.println(isValid(str));

	}

	private static boolean isValid(String str) {
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++){
			int value=0;
			if(map.containsKey(str.charAt(i))) 
				value=map.get(str.charAt(i));
				map.put(str.charAt(i),value++);
			{
				map.put(str.charAt(i), value++);
			}
		}
		if(map.get('(')==map.get(')') && map.get('{')==map.get('}') && map.get('[')==map.get(']')){
			return true;
		}
		return false;
	}

}
