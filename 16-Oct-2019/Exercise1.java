import java.io.*;

class Exercise1{
	public static void main(String[] args) throws IOException {

		int lineNumber=1;

		File fileObj = new File("File1.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileObj));

		bw.write("Hey my name is Aditya \n");
		bw.write("Hey my name is Aditya \n");
		bw.write("Hey my name is Aditya \n");
		bw.write("Hey my name is Aditya \n");
		bw.write("Hey my name is Aditya \n");
		bw.flush(); 
		bw.close();

		BufferedReader br = new BufferedReader(new FileReader(fileObj));
		String str = "";
		while((str = br.readLine()) != null){
					System.out.println(lineNumber+") "+str);
		 			lineNumber++;
		    	}
		br.close();
	}
}