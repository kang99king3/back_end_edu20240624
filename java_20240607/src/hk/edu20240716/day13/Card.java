package hk.edu20240716.day13;

//Card 클래스는 카드 한장을 의미한다.
public class Card {
	
	//카드를 만들기 위한 필드를 선언하자...
	public static final String[] DECK = {"♠","◆","♥","♣"};
	public static final String[] STECK
		= {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	
	//카드 한장의 대한 정보[그림+숫자]
	private String card;// "◆9" 이런식의 형태로 값이 저장될거임...

	public Card() {
		init();//Card 객체가 생성되면 init()메서드 실행
	}

	//은닉화: 메서드를 통해 접근
	public String getCard() {
		return this.card;
	}
	
	//카드 한장 만드는 기능
	public void init() {
		int a=(int)(Math.random()*DECK.length) ;//0~3까지 숫자를 랜덤하게 생성해서 저장: DECK의 인덱스를 의미
		int b=(int)(Math.random()*STECK.length);//0~12까지 숫자를 랜덤하게 생성해서 저장: STECK의 인덱스를 의미
		card=DECK[a]+STECK[b];
	}
	
	//Object클래스의 메서드를 오버라이딩함
	//Card객체를 출력하면 아래 메서드가 실행
	@Override
	public String toString() {
		return "["+card+"]";
	}
	
	// Card객체 내부에 card멤버필드끼리 비교하는 기능으로 재정의
	@Override
	public boolean equals(Object obj) {
		boolean isS=false;
		Card ca=(Card)obj;//Card --> Object --> Card 형변환
		if(card.equals(ca.getCard())) {
			isS=true;
		}
		return isS;
	}
	//equals오버라이딩하면 hashcode도 오버라이딩해야 됨
	@Override
	public int hashCode() {
		return card.hashCode()+137;
	}
}









