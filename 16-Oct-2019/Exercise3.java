import java.util.Scanner;
import java.io.*;

class Exercise3{
	public static void main(String[] args) {
		
		char[] in = new char[500];
		int size = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the file : ");
		String fileName = sc.nextLine();

		File myFile = new File(fileName);
		if(myFile.exists()==false)
            {
                System.out.println("File doesn't exist!!!");
                System.exit(0);
            }

		System.out.println("File exists ? : " + myFile.exists());
		System.out.println("Readable ? : " + myFile.canRead());
		System.out.println("Writable ? : " + myFile.canWrite());
		System.out.println("Type of file : "+ Files.getFileExtension(myFile));
		System.out.println("Length of file in bytes : "+  myFile.length());
		
	}
}