import java.util.*;

class BubbleSort{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp;
		System.out.print("Enter the size of array: ");
		int size = sc.nextInt();
		int arr[]=new int[size];
		System.out.println("Enter elements : ");
		for(int i=0;i<size;i++)
			arr[i]=sc.nextInt();
		System.out.println("Before sorting : ");
		for(int values:arr)
			System.out.print(values+" ");

		for(int i=0;i<size-1;i++)
			for(int j=0;j<size-i-1;j++)
				if(arr[j]>arr[j+1])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
		System.out.println("\nAfter Sorting :");
		for(int values:arr)
			System.out.print(values+" ");
	}
}