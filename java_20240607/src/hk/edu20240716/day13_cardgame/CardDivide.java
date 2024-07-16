package hk.edu20240716.day13_cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class CardDivide {

	public ArrayList<Player> players;// 플레이어들을 담는 리스트
	public final int cardNum=2;//플레이어에게 나눠줄 카드 장수 
	public CardDivide() {
		players=new ArrayList<Player>();
		numPlayer();//플레이어 명수를 정한다.
		cardDivide(cardNum);// 카드를 cardNum만큼 플레이어에게 나눠준다.
	}
	
	//플레이어 수를 결정한다.
	public void numPlayer(){
		Scanner scan=new Scanner(System.in);
		System.out.print("플레어 할 인원 수를 입력하세요 : ");
		int pNum=scan.nextInt();
		for (int i = 0; i < pNum; i++) {
			Player p=new Player();
			players.add(p);
		}
	}
	//카드를 플레이어들에게 나눠주는 메서드
	public void cardDivide(int n){
		CardDeck deck=new CardDeck();
		ArrayList<Card> cardCase=deck.getCard();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < players.size(); j++) {
				//카드를 한장씩 플레이어에게 나눠준다.
				players.get(j).getPlayer().add(cardCase.get(0));
				cardCase.remove(0);//나눠준 카드는 case에서 지운다.
			}//for
		}//for	
		deck.print();
	}//cardDivide
	
	public void playerPrint(){
		for (int i = 0; i < players.size(); i++) {
			System.out.print("플레이어 "+(i+1)+": ");
			for (int j = 0; j < cardNum; j++) {
				System.out.print(players.get(i).getPlayer().get(j)+"\t");
			}
			System.out.println();
		}
	}
	
	//두 장의 카드의 점수를 환산한다.
	public int check(Player pUser){
		String c1=pUser.getPlayer().get(0).getCard();
		String c2=pUser.getPlayer().get(1).getCard();
		int a=change(c1.charAt(1));
		int b=change(c2.charAt(1));	
		String tot=null;
		if(a==b){//두카드의 숫자가 같다면 땡이다
			tot=String.valueOf(changeSame(a));//땡을 점수로 환산하여 tot에 저장
		}else{
			//카드 두장에 합을 구한다
		    tot=""+(change(c1.charAt(1))+change(c2.charAt(1)));
			if(tot=="10"){ //합이 10이면 
				tot="0"; //0으로 값을 바꾼다
			}else if(tot.length()==2){//10이 아니면서 길이 값이 2자리숫자이면
				tot=tot.substring(1);//뒷자리만 잘라서 저장한다.
			}
		}
		
		return Integer.parseInt(tot); //만들어진 문자열 숫자를 정수타입으로 변환
	}
	//두장의 카드의 숫자가 같다면 땡이고, 몇땡인지에 대한 점수를 환산하는 메서드
	public int changeSame(int a){
		int num=0;
		switch (a) {
		case 10: num=100; break;
		case 9: num=90;  break;
		case 8: num=80;  break;
		case 7: num=70;  break;
		case 6:num=60;  break;
		case 5: num=50; break;
		case 4:num=40;  break;
		case 3: num=30; break;
		case 2:num=20;  break;
		case 1:num=10;  break;
		}
		return num;
	}
	//숫자를 제외한 영문으로 된 카드들을 숫자로 변환시킨다.
	public int change(char c){
		int a=0;
		switch (c) {
		case 'A': a=1; break;
		case 'T': a=10; break;
		default: a=c-'0';//char타입이기때문에 int형으로 변환시켜 저장한다.
			break;
		}
		return a;
	}
	
	public void cardCompare(){
		int n=players.size();
		int [] cardNum=new int[n];// 비교하기 위해 환산된 점수 저장
		int [] result=new int[n]; //비교한 결과 값 저장
		int count=0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < cardNum.length; j++) {
				cardNum[i]=check(players.get(i));//두장의 카드를 점수로 환산하여 저장
			}
		}
		for (int i = 0; i < cardNum.length; i++) {
			for (int j = 0; j < cardNum.length; j++) {
				if(i!=j&&cardNum[i]>cardNum[j]){
					count++;    // 서로 비교해서 크면 카운트를 올린다
				}
			}
			result[i]=count;    //각각의 플레이어의 카운트를 저장하고
			count=0;			//카운트 초기화
		}
		for (int i = 0; i < result.length; i++) {
			if(result[i]==n-1){ //count가 n-1이면 가장 큰 값을 가진다.
				if(cardNum[i]>=10){
				System.out.println((i+1)+"번 player가 이겼습니다. :"
				+((""+cardNum[i]).charAt(0))+"땡");
				}else{
					System.out.println((i+1)+"번 player가 이겼습니다. :"+cardNum[i]+"끗");
				}
				
			}
		}
		//count가 0인경우는 유저들의 카드의 점수가 같다
		//result에 값들이 모두 0이면 비김
		boolean draw=true;
		for (int i = 0; i < result.length; i++) {
			if(result[i]!=0) {
				draw=false;
				break;
			}
		}
		if(draw){
			System.out.println("비겼습니다. 승부를 결정지으려면 다시 시작하세요");
		}
	}
}//class








