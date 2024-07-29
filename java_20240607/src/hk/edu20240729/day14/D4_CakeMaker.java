package hk.edu20240729.day14;

public class D4_CakeMaker implements Runnable{

	private D4_CakePlate cake;
	
	public D4_CakeMaker() {
		
	}
	
	public D4_CakeMaker(D4_CakePlate cake) {
		this.cake=cake;
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			cake.makeBread();
		}
		
	}
}
