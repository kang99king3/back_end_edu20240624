package hk.edu20240711.day10;

// 사용자 정의 Exception 
public class NoMatchException extends Exception{

	private static final long serialVersionUID = 4669097051403428672L;

	public NoMatchException() {
		this("1과 2는 마장진이 될 수 없습니다.");
	}
	
	public NoMatchException(String message) {
		super(message);
	}

}
