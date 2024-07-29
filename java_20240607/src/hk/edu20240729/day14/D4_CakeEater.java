package hk.edu20240729.day14;

public class D4_CakeEater implements Runnable{
	
	private D4_CakePlate cake;
	
	public D4_CakeEater() {
	
	}
	
	public D4_CakeEater(D4_CakePlate cake) {
		this.cake=cake;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			cake.eatBread();
		}
		
	}

}
