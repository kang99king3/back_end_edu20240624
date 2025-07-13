package hk.edu20240709.day08;

// Cloneable 인터페이스에는 아무 기능이 선언되어 있지 않지만 반드시 구현해야 한다.
// --> 표식을 나타내는 인터페이스로 사용됨(java에서 그렇게 만들어 놨음)
public class D3_Person implements Cloneable{
	
	String name;

    public D3_Person(String name) {
        this.name = name;
    }

    //부모의 메서드를 자식이 구현함--> 부모의 메서드를 호출해도 자식이 불림..
    @Override
    public D3_Person clone() {
        try {
        	//Object(super)의 clone()메서드임-> D3_Person으로 형변환해야 함
            return (D3_Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
}
