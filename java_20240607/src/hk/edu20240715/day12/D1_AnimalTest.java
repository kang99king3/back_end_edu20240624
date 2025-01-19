package hk.edu20240715.day12;

public class D1_AnimalTest {

	public static void main(String[] args) {
		D1_Animal human=new D1_Human();
		human.move();
		
		D1_Human humanChild=(D1_Human)human;
//		human.test();//부모에 공개된 메서드만 사용가능하다.
		humanChild.move();
		humanChild.test();
		
		System.out.println("============================");
		//다형성 발생원리 3가지
		//1.부모의 타입으로 자식을 생성한다.
		D1_Animal animal1=new D1_Human();
		D1_Animal animal2=new D1_Tiger();
		D1_Animal animal3=new D1_Eagle();
		
		//2.부모의 타입으로 자식을 참조한다.
		D1_Human human1=new D1_Human();//자식객체 생성해서
		D1_Animal animal4=human1;//부모타입으로 참조한다.
		
		D1_AnimalTest aTest=new D1_AnimalTest();
		aTest.moveAnimal(animal1);
		aTest.moveAnimal(animal2);
		aTest.moveAnimal(animal3);
	}
	
	// 자식타입의 서로 다른 여러 객체들을 참조할 수 있다.(파라미터에 선언된 부모타입으로..)
	public void moveAnimal(D1_Animal animal) {
		//메서드 오버라이딩: 부모의 메서드를 오버라이딩해야 한다.
		animal.move();//하나의 부모타입으로 여러 형태를 나타낼 수 있다.(다형성)
		
		//오버라이딩 안된 경우에 메서드를 사용한다면...
		//특정 클래스 또는 하위클래스를 비교한다.
		if(animal instanceof D1_Human ) {
			D1_Human human2=(D1_Human)animal;
			human2.test();
		}else if(animal instanceof D1_Eagle) {
			D1_Eagle human2=(D1_Eagle)animal;
			human2.test();
		}
		
	}
	
	//다형성을 사용하지 않는다면
	public void moveAnimal(D1_Human human) {
		human.move();
	}
	public void moveAnimal(D1_Tiger tiger) {
		tiger.move();
	}
	public void moveAnimal(D1_Eagle eagle) {
		eagle.move();
	}
	

}












