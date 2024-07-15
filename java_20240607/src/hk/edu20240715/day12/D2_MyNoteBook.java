package hk.edu20240715.day12;

public class D2_MyNoteBook extends D2_NoteBook{

	//모든 추상메서드를 구현하게 되면 상위에 모든 메서드를 사용할 수 있게됨
	@Override
	public void typing() {
		System.out.println("MyNoteBook typing");
	}

}
