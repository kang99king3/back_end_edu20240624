package hk.edu20240716.day13;

import java.util.ArrayList;
import java.util.List;

//Card 52장을 나타내는 클래스
public class CardCase {

	//카드 52장을 저장할 맴버필드
	private List<Card> cards;
	
	//카드의 총 장수를 구하자
	private static final int NUMOFCARDS=Card.DECK.length*Card.STECK.length;
	
	public CardCase() {
		cards=new ArrayList<Card>();
		shuffle();//초기화-->카드52장 생성 실행
	}
	
	//카드객체를 생성해서 cards에 담아줄 메서드
	public void shuffle() {
		int i=0;
		while(true) {
			Card cc=new Card();//카드한장 만들어짐
			if(!cards.contains(cc)) {
				cards.add(cc);//카드 한장 넣기
				i++;				
			}
			
			if(i==NUMOFCARDS) {
				break;
			}
		}
	}
	
	public List<Card> getCards(){
		return cards;
	}
}








