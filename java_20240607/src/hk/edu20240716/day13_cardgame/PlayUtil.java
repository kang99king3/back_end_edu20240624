package hk.edu20240716.day13_cardgame;

import java.util.Scanner;

public class PlayUtil {

	public PlayUtil() {
		
	}
	
	public void playGame(){
			Scanner scan=new Scanner(System.in); 
			String n;
			String yes="y";
			String no="n";
		do{
			CardDivide play=new CardDivide();
			play.playerPrint();
			play.cardCompare();
			System.out.println("게임을 다시 시작하겠습니까?(y/n)");
			
			while (true) {
					n = scan.next();
					if(n.equals(yes)||n.equals(no)){
						break;
					}else{
						System.out.println("y또는 n으로 입력하세요~~!!");
					}
			}
			
		}while(n.equalsIgnoreCase("y"));
		System.out.println("게임을 종료 합니다.");
	}
}
