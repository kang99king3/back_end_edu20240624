package hk.edu20240729.day14;

public class D3_ThreadSync {

	//내부클래스
	class ShareObject{
		public synchronized void print(String title) {
			for (int i = 0; i < 10; i++) {
				System.out.println(title);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//공유객체 생성
		ShareObject so=new D3_ThreadSync().new ShareObject();
		
		//A와B 스레드가 동시적으로 접근한다.
		//동기화 설정하기: A스레드의 작업이 종료되기까지 B스레드는 대기한다.
		//설정방법 2가지: synchronized 메서드, 
		//             동기화 블록 synchronized(공유객체){}
		Thread trA=new Thread() {
			@Override
			public void run() {
				so.print("공");
			}
		};
		
		Thread trB=new Thread() {
			@Override
			public void run() {
				so.print("유");
			}
		};
//		trA.start();
//		trB.start();
		
		//-----------------------------
		D3_ThreadSync d3=new D3_ThreadSync();
		
		Thread trC=new Thread(){
			@Override
			public void run() {
				d3.sbTest("건");
			}
		};
		
		Thread trD=new Thread(){
			@Override
			public void run() {
				d3.sbTest("양");
			}
		};
		
		trC.start(); trD.start();
		
	}//main종료
	
	//멀티스레드환경에서 동기화를 제공하지 않으면 문자열이 깨져서 저장될 수 도 있다. "ㅁㅁ"
	//자체 동기화 제공 O, 속도는 느리다. 안정적O
//	public static StringBuffer sb=new StringBuffer();
	//자체 동기화 제공 X, 속도는 빠르다. 안정적X
	public static StringBuilder sb=new StringBuilder();
	
	public void sbTest(String s) {
		
		synchronized (sb) {
			sb.append(s);
			System.out.println(sb.toString());			
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}










