class Timer extends Thread{
	public static void main(String[] args){
		Timer t = new Timer();
		t.start();
	}

	@Override
	public void run(){
		System.out.println("-----TIMER-----");
		for (int time=0; ;time++ ) {
			System.out.print("\r"+time);
			try{
			Thread.sleep(1000);
		}catch(InterruptedException ie){
			System.out.println("Exception is caught");
			}
		}
	}
}