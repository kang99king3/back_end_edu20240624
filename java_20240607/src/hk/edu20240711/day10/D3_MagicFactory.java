package hk.edu20240711.day10;

import java.util.Scanner;

public class D3_MagicFactory {

	//Singleton pattern: 객체를 한번만 생성해서 사용하기
	private static D3_MagicFactory magicFactory;
	private D3_MagicFactory() {
		// TODO Auto-generated constructor stub
	}
	public static D3_MagicFactory getInstance() {
		if(magicFactory==null) {
			magicFactory=new D3_MagicFactory();
		}
		return magicFactory;
	}
	
	public D3_Interface_Magic factory() throws NoMatchException {
		D3_Interface_Magic magic=null;
		System.out.println("원하는 마방진을 입력하세요");
		
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		
		if(num<3) {
			throw new NoMatchException();
		}else if(num%2==1) {
			magic=new D3_OddMagicSquare2(num);
		}else if(num%4==0) {
			magic=new D3_EvenMagicSquare2(num);
		}else if(num%4==2) {
			magic=new D3_SixMagicSquare2(num);
		}
		
		return magic;
	}
	
}
