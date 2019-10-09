class RandomNumbers extends Thread{
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
		RandomNumbers num = new RandomNumbers();
		num.setName(Integer.toString(i));
		num.start();
	}		
	}

	@Override
	public void run(){
		System.out.print(" " + Thread.currentThread().getName());
	}
}