package hk.edu20240716.day13;

import java.util.List;

public class CardMain {

	public static void main(String[] args) {
//		Card card=new Card();
//		
//		System.out.println(card);

		CardCase cardCase=new CardCase();
//		cardCase.shuffle();
		List<Card> cards=cardCase.getCards();//52장의 카드 가져옴
		
		for (int i = 0; i < cards.size(); i++) {
			System.out.print(cards.get(i)+"\t");
			//10장씩 줄바꿔서 출력해보자
			if((i+1)%10==0) {
				System.out.println();
			}
		}
	}

}







