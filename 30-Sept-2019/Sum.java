import java.util.*;

class Sum{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count=0;
		System.out.print("Enter the three numbers : ");
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int num3=sc.nextInt();
		int sum=num1+num2+num3;
		if (num1>=40)
			count++;
		if(num2>=40)
			count++;
		if(num3>=40)
			count++;
		if(sum>=125)
			count++;
		if(count==4)
			System.out.println("PASSING");
		System.out.println("FAILING");


	}
}