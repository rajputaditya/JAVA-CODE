import java.util.*;
class Binary{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r=0,q=0;
		String binaryform="";
		System.out.print("Enter the number : ");
		int num=sc.nextInt();
		while(num>0){
			r=num%2;
			binaryform+=Integer.toString(r);
			num=num/2;
		}
		for(int i=binaryform.length()-1;i>=0;i--)
			System.out.print(binaryform.charAt(i));

	}
}