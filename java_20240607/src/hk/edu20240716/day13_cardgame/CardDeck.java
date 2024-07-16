package hk.edu20240716.day13_cardgame;


import java.util.ArrayList;

public class CardDeck {
	private static final int CDCOUND=Card.IM.length*Card.NUM.length;
	private ArrayList<Card> card;
	
	public CardDeck() {
		card=new ArrayList<Card>();
		make();
	}
	public void make(){
		int count=0;
		while(true){
			Card cd=new Card();
			if(!isSame(card, cd)){
				card.add(cd);
				count++;
			}
			if(count==CDCOUND){
				break;
			}
		}
	}
	public ArrayList<Card> getCard() {
		return card;
	}
	public boolean isSame(ArrayList<Card> cd,Card ca){
		boolean isS=false;
		if(cd.contains(ca)){
			isS=true;
		}
		return isS;
	}
	public void print(){
		for (int i = 0; i < card.size(); i++) {
			System.out.print(card.get(i)+"\t");
			if((i+1)%10==0){
				System.out.println();
			}
		}
		System.out.println("DECK: "+card.size()+"��");
		System.out.println("\n=========================================================================");
	}
	
}
