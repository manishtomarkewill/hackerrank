import java.util.ArrayList;

public class P38 {

	public static void main(String[] args) {
		System.out.println(countAndSay(7));

	}

	private static String countAndSay(int  input) {
		ArrayList<String> als=new ArrayList<String>();
		als.add("1");
		String str="";
		ArrayList<Character> al=new ArrayList<Character>();
		int count=1;
		String s = "";
		if(input==1)
			return "1";
		for(int j=1;j<input;j++){
			s="";
			str=als.remove(0);
			
			for(int i=0;i<str.length();i++){
				char n=str.charAt(i);
				if(al.contains(n))
					count++;
				else{
					if(al.size()>0){
						char prevChar=al.remove(al.size()-1);
						if(n!=prevChar){
							s=s+Integer.toString(count)+Character.toString(prevChar);
							count=1;
							al.clear();
						}
					}
					al.add(n);
				}
			}
			if(al.size()>0){
				char prevChar=al.remove(al.size()-1);
					s=s+Integer.toString(count)+Character.toString(prevChar);
					al.clear();
					count=1;
			}
			als.add(s);
		}
		
		return s;
	}

}
