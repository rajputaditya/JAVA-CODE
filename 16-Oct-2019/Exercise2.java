import java.io.*;

class Exercise2{
	public static void main(String[] args) throws IOException {
		int charCount=0;
		char[] in = new char[500]; // to store input
		int size = 0;
		int lineCount=0;
		int words=0;

		final String myFileName="File1.txt";
          
            File myFile=new File(myFileName);
            if(myFile.exists()==false)
            {
                System.out.println("File doesn't exist!!!");
                System.exit(0);
            }
                
			FileReader fr = new FileReader(myFile); // create a FileReader
// object
			size = fr.read(in); // read the whole file!
			
			for(char c : in) {// print the array
						if(c=='\n'||c=='.')
							lineCount++;
						if(c==' ')
							words++;
						System.out.print(c);
			
			}			
			System.out.println("Number of characters : " + size); // how many bytes read
			System.out.println("Number of lines : " + lineCount);
			System.out.println("Number of words : " + words);
			fr.close(); // again, always close         
        }
       
	}
