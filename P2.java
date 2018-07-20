
public class P2 {

	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}

	private static int reverse(int i) {
		int r,sum=0;
		while(i!=0){
			r=i%10;
			sum=sum*10+r;
			i=i/10;
		}
		return sum;
	}
}
