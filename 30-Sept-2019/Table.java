import java.util.*;
class Table{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number : ");
		int num=sc.nextInt();
		System.out.println("Enter limit : ");
		int limit = sc.nextInt();
		for(int i=1;i<=limit;i++)
			System.out.println(num + " * " + i +" = " + num*i);
		
	}
}