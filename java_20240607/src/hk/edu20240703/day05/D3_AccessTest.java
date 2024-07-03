package hk.edu20240703.day05;

public class D3_AccessTest {

	//맴버필드
	public  int a;//모두 접근가능
		    int b;//패키지 내부에서만
	private int c;//클래스 내부에서만	
	
	//메서드
	public void aa() {
		
	}
	void bb() {
		
	}
	private void cc() {
		
	}
	
	public int getC(int code) {
//		if(code==3) {
//			return c;
//		}
		return c;//클래스 내부에서 접근하기 때문에 가져올 수 있다.
	}
}







