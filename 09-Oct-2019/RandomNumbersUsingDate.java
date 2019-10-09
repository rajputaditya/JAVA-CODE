import java.util.Date;

class RandomNumbersUsingDate extends Thread{
	public static void main(String[] args) throws InterruptedException{
		RandomNumbersUsingDate obj = new RandomNumbersUsingDate();
        obj.start();
	}

	@Override
	public void run()
	{
		for (	;	;	) {
			Date date = new Date();
			long time = date.getTime();
			System.out.print(((time%1311)/2)*9);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){
				System.out.println("exception");
			}
			System.out.print("\r");
		}
	}
}