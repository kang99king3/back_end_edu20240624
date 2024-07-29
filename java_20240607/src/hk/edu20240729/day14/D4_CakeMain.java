package hk.edu20240729.day14;

public class D4_CakeMain {

	public static void main(String[] args) {
		
		//스레드들이 공유할 객체
		D4_CakePlate cake=new D4_CakePlate();
		
		//스레드 객체들
		D4_CakeEater eater=new D4_CakeEater(cake);
		D4_CakeMaker maker=new D4_CakeMaker(cake);
		
		//스레드 객체생성
		Thread t1=new Thread(eater);
		Thread t2=new Thread(maker);
		
		t2.setPriority(10);//스레드 실행의 우선순위 설정
		t1.setPriority(1);
		
		t2.start();
		t1.start();
	}

}
