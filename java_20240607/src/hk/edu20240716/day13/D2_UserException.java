package hk.edu20240716.day13;

//내가 exception클래스를 구현하려면 Exception클래스를 상속받아야 한다.
public class D2_UserException extends Exception{

	public D2_UserException() {
		this("UserException 오류입니다.");
	}
	
	public D2_UserException(String msg) {
		super(msg);//부모생성자한테 메시지 전달
	}
}
