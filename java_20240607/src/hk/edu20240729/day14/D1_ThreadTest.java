package hk.edu20240729.day14;

public class D1_ThreadTest {

	public static void main(String[] args) {
		//"안" , "녕"을 번갈아 가며 출력해보자
		for (int i = 0; i < 5; i++) {
			System.out.println("안");
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("녕");
		}
		
		//작업단위 하나
		Thread t1=new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("안");
					try {
						Thread.sleep(500);//지연시간 설정(일시정지)
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		//작업단위 둘
		Thread t2=new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("녕");
					try {
						Thread.sleep(500);//지연시간 설정(일시정지)
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		//스레드의 run()을 실행해주는 메서드: start()
		t1.start();
		t2.start();
		
		//내부클래스에 경우 부모 클래스를 객체생성한 후에 사용할 수 있다.
		Thread t3=new D1_ThreadTest().new ThreadObj();
		t3.start();
	}//main종료
	
	//1.Thread클래스를 상속받은 Thread클래스를 정의할 수 있다.
	class ThreadObj extends Thread{
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println("ThreadTest:"+i);
			}
		}
	}
}











