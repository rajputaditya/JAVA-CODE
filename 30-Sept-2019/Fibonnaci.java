class Fibonnaci{
	public static void main(String[] args) {
		int first=0,second=1,next=0;
		System.out.print(first+" "+second);
		while(next<89)
		{
			next=first+second;
			first=second;
			second=next;
			System.out.print(" "+next);
		}
	}
}