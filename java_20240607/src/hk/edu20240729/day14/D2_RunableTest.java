package hk.edu20240729.day14;

public class D2_RunableTest implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("나는 Runable을 구현한 스레드야");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
