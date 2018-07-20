import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P13 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		System.out.println(value(str));

	}

	private static int value(String str) {
		int val=0,value = 0;
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='M')
				val=1000;
			if(str.charAt(i)=='D')
				val=500;
			if(str.charAt(i)=='C')
				val=100;
			if(str.charAt(i)=='L')
				val=50;
			if(str.charAt(i)=='X')
				val=10;
			if(str.charAt(i)=='V')
				val=5;
			if(str.charAt(i)=='I')
				val=1;
			map.put(str.charAt(i), val);
		}
		for(int i=0;i<str.length();i++){
			if(i!=str.length()-1 && map.get(str.charAt(i)) < map.get(str.charAt(i+1))){
				value=value+map.get(str.charAt(i+1)) - map.get(str.charAt(i));
				i++;
			}else{
				value=value+map.get(str.charAt(i));
			}
			
		}
		return value;
	}

}
