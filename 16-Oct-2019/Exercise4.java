import java.util.Scanner;
import java.io.*;

class Exercise4{
	public static void main(String[] args) throws IOException{

		final String myFileName="File1.txt";
          
            File myFile=new File(myFileName);
            if(myFile.exists()==false)
            {
                System.out.println("File doesn't exist!!!");
                System.exit(0);
            }

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the word you want to replace : ");
            String wordToReplace = sc.nextLine();
            System.out.print("\nEnter the new word : ");
            String newWord = sc.nextLine();

            StringBuilder sb = new StringBuilder("");
 
			BufferedReader br = new BufferedReader(new FileReader(myFile));
			String str = "";
			while((str = br.readLine()) != null)
   				 sb.append(str);
   			//br.flush()
   			//br.close();
			System.out.println("Previous Content : " + sb);

			str=sb.toString();
			str = str.replaceAll(wordToReplace,newWord);

			BufferedWriter bw = new BufferedWriter(new FileWriter(myFile));
			bw.write(str);
			bw.flush();
			bw.close();

			sb = new StringBuilder("");
			br = new BufferedReader(new FileReader(myFile));
			while((str = br.readLine()) != null){

				//System.out.println("Line  : " + str);
   				 sb.append(str);

   				}
   			System.out.println("New Content : " + sb);
   			br.close();
			





              
	}
}
