import java.util.*;

class ReverseString{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string to be reversed : ");
		String str = sc.nextLine();
		String reverseString="";
		for(int i=str.length()-1;i>=0;i--)
			reverseString+=str.charAt(i);
		
		System.out.print("Reverse String : " + reverseString);
		
	}
}