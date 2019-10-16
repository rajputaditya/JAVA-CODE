import java.io.*;

class Exercise5{
	public static void main(String[] args) throws IOException, InterruptedException {

		CopyDataThread cdt = new CopyDataThread();
		cdt.copyContent();
		
	}
}

class CopyDataThread extends Thread  {

	void copyContent() throws IOException,InterruptedException{

	int time=0;

	File oldFile = new File("source.txt");
	File newFile = new File("target.txt");

	BufferedReader br = new BufferedReader(new FileReader(oldFile));
	BufferedWriter bw= new BufferedWriter(new FileWriter(newFile));
	int ch;
	System.out.println("Source file ...");
	while((ch = br.read()) != -1)
		{
			time++;
			bw.write((char)ch);
			if(time==10){
				time=0;
    			System.out.println("10 characters are copied");
    			this.sleep(5000);
    		}
		}
	bw.flush();
	bw.close();
	br.close();
}
}