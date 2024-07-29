package hk.edu20240729.day14;

public class D2_ThreadMain {

	public static void main(String[] args) {
		//스레드를 생성하는 방법 2가지
		
		//1.Runable을 구현하는 방법 
		Runnable runObj=new D2_RunableTest();
		Thread tr=new Thread(runObj);
		tr.setPriority(10);//priority 우선순위 설정 1~10까지..
		tr.start();
		
		//2.Thread 클래스 상속받는 방법
		Thread thr=new D2_ThreadInheritance();
		thr.setPriority(Thread.MIN_PRIORITY);//가장 하위의 순위(MIN...)
		thr.start();
		
		//메인스레드
		for (int i = 0; i < 5; i++) {
			System.out.println("나는 메인 스레드야");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}






