package hk.edu20240715.day12;

import java.util.Calendar;

public class D2_ComputerTest {

	public static void main(String[] args) {
		//추상클래스는 객체생성을 할 수 없다(new사용해서)
//		D2_Computer computer=new D2_Computer();//오류발생
//		Calendar cal=new Calendar();//추상클래스라서 객체생성(new)못함
//		Calendar cal=Calendar.getInstance();
		
		D2_Computer c1=new D2_DeskTop();
		c1.turnOn();
		c1.display();
		c1.typing();
		c1.turnOff();
		
//		D2_Computer c2=new D2_NoteBook();
		D2_Computer c2=new D2_MyNoteBook();
		c2.turnOn();
		c2.display();
		c2.typing();
		c2.turnOff();
	}
}



