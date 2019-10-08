import java.util.*;

class StringPalindrome{
	public static void main(String[] args) {
		int i,j,count=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string to be tested : ");
		String str = sc.nextLine();
		for(i = 0 , j = str.length()-1 ; i<(str.length()-1)/2 ;   i++ , j--)
		{
			count=0;
			if(str.charAt(i)!=str.charAt(j)){
				System.out.println("String is not palindrome");
				break;
			}
			else
				count++;
		}
		if (count==1) {
			System.out.println("String is palindrome");
		}
		
	}
}