package hk.edu20240715.day12;

//추상클래스가 됨 --> 하위 클래스에서도 일부만 구현되는 상황--> 추상클래스로 만들고 
// --> 다음 하위 클래스에서 구현해야 한다.
public abstract class D2_NoteBook extends D2_Computer{

	@Override
	public void display() {
		System.out.println("NoteBook display");
	}

	//typing() 기능을 구현 못함.(구현못하는 상황이라면)
	@Override
	public abstract void typing();

}
