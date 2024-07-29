package hk.edu20240729.day14;

public class D4_CakePlate {

	private int breadCount=0;
	
	public synchronized void makeBread() {
		if(breadCount>=10) {
			System.out.println("빵이 남는다");
			try {
				wait();//일시정지
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		breadCount++;
		System.out.println("빵을 1개 더 만듦 총:"+breadCount+"개");
		//모든 스레드 실행대기--> wait()로 일시정지된 스레드를 실행 대기상태로 만든다.
		this.notifyAll();
	}
	
	public synchronized void eatBread() {
		if(breadCount<1) {
			System.out.println("빵이 모자라 기다림");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//일시정지
		}
		breadCount--;
		System.out.println("빵을 1개 먹음 총:"+breadCount+"개");
		this.notifyAll();//모든 스레드를 실행대기 --> 스케쥴러에 의해 실행됨
	}
}










