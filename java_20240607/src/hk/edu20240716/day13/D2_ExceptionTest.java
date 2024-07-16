package hk.edu20240716.day13;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class D2_ExceptionTest {
	public static void main(String[] args){
//		exTest("123");
		
		try {
			userExceptionTest(12);
		} catch (D2_UserException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void exTest(String s) {
		int i=0;
		String ss="";
		int [] array= {1,2,3,4,5};
		
		try {
			ss=s.substring(0,2);
			i=Integer.parseInt(ss);//<--- "5" 숫자형태의 문자열을 받아야한다.
			int a=array[5];//인덱스의 범위를 벗어나는 경우
			System.out.println(i+4);
		}catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();//예외 발생 내용을 출력해주는 기능
			System.out.println("문자열의 길이를 확인하세요");
		}catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("숫자형태인지 확인하세요");
		}catch(ArrayIndexOutOfBoundsException ee) {
			ee.printStackTrace();
			System.out.println("배열의 인덱스를 확인하세요");
		}catch(Exception ee) {
			ee.printStackTrace();
		}finally {
			System.out.println("예외와 상관없이 반드시 처리해야 할 코드");
		}
	}
	
	//사용자 예외처리: 예외를 던지기로 구현
	public static void userExceptionTest(int a) throws D2_UserException {
		//a는 1~10까지의 숫자만 전달받을 수 있다.
		if(!(a>0&&a<11)) {// 1~10의 범위를 벗어난 숫자를 받았을 경우
			throw new D2_UserException("1부터 10까지의 숫자만 입력하세요");
		}
	}
	
	//java.io에 있는 클래스를 사용할때 무조건 예외처리하기 
	public void test01() throws IOException {
		InputStreamReader in=new InputStreamReader(null);
		in.read();
	}
	//예외를 던지면 사용하는 쪽에서 반드시 처리하거나, 또 던지거나...
	public void test02() throws IOException {
		test01();
	}
}















