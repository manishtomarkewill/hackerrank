import java.util.Scanner;

public class P9 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println(palin(num));

	}
	public static boolean palin(int x){
		if(x<0)
			return false;
		 int y=x;
	        int num=0;
			while(x!=0){
				num=num*10+x%10;;
				x=x/10;
			}
	        if(y==num)
			  return true;
	        return false;
	}

}
