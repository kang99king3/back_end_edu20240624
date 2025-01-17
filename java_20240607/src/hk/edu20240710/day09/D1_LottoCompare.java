package hk.edu20240710.day09;

import java.util.Arrays;

//구매한 로또를 당첨번호와 비교해서 결과를 보여줄 클래스
public class D1_LottoCompare {

	//당첨번호
	public static final D1_Lotto lottoBall = new D1_Lotto();
	
	//구매한 로또의 번호들
	public D1_LottoStore userBall;
	
	public D1_LottoCompare() {
//		this.lottoBall=new D1_Lotto();
		this.userBall=new D1_LottoStore();//기본 5장 구매
	}
	
	public D1_LottoCompare(int n) {
//		this.lottoBall=new D1_Lotto();
		this.userBall=new D1_LottoStore(n);//원하는 수량 구매
	}
	
	//당첨번호를 비교하는 메서드
	public void compareBall() {
		//당첨번호 출력
		System.out.println("당첨번호");
		int[] lots=lottoBall.getLots();//Lotto객체 안에 로또번호 가져오기
		Arrays.sort(lots);//정렬하기
		System.out.println(Arrays.toString(lots));
		
		//사용자 구매번호 출력
		System.out.println("사용자 구매번호");
		D1_Lotto[] userLots=userBall.lottoObj;//사용자가 구매한 로또 번호
		for (int i = 0; i < userLots.length; i++) {
			Arrays.sort(userLots[i].getLots());
			System.out.println(Arrays.toString(userLots[i].getLots()));
		}
		
		//당첨번호 비교하기
		System.out.println("당첨번호 확인하기");
		for (int i = 0; i < userLots.length; i++) {
			int count=0;//당첨번호개수
			System.out.println(Arrays.toString(userLots[i].getLots()));//사용자 로또
			for (int j = 0; j < lots.length; j++) {
				//           사용자로또 배열      , 당첨번호에 숫자한개씩 전달
				if(Util.isSame(userLots[i].getLots(), lots[j])) {
					System.out.print(lots[j]+" ");//당첨번호 출력
					count++;
				}
			}
			System.out.println("당첨번호 개수:"+count);
			lottoResult(count);
			System.out.println("-------------------------");
		}
	}
	//당첨개수를 확인해서 등수를 출력하는 기능
	//6개:1등 5:2등 ...... 
	public void lottoResult(int count) {
		switch(count) {
			case 6 : System.out.println("1등"); break;
			case 5 : System.out.println("2등"); break;
			case 4 : System.out.println("3등"); break; 
			case 3 : System.out.println("4등"); break; 
			case 2 : System.out.println("5등"); break; 
			default : System.out.println("다음기회에!!"); break;
		}
	}
	
	//배열에 중복 숫자가 있는지 확인하는 메서드: 반환타입 boolean
	//배열하고, 숫자하나에 대한 비교
//	public boolean isSame(int[] a, int b) {
//		boolean isS=false;
//		for (int i = 0; i < a.length; i++) {
//			if(a[i]==b) {
//				isS=true;
//				break;
//			}
//		}
//		return isS;
//	}
	
}










