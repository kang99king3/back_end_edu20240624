package hk.edu20240710.day09;

import java.util.Arrays;

public class D1_LottoMain {

	public static void main(String[] args) {
		
//		D1_Lotto lotto=new D1_Lotto();
		
//		System.out.println(lotto.makeBall());
		
//		lotto.makeLotto();//6개생성해서 배열에 담는다
//		System.out.println(Arrays.toString(lotto.getLots()));
		
//		D1_LottoStore lottoStore=new D1_LottoStore(2);
//		System.out.println(Arrays.toString(lottoStore.lottoObj));
//		System.out.println(Arrays.toString(lottoStore.lottoObj[0].getLots()));
	
		D1_LottoCompare lottoCompare=new D1_LottoCompare(10);
	
		D1_LottoCompare lottoCompare2=new D1_LottoCompare(5);
		
		
		System.out.println(Arrays.toString(lottoCompare.lottoBall.getLots()));
		
		lottoCompare.compareBall();
//		
//		System.out.println(Arrays.toString(lottoCompare2.lottoBall.getLots()));
		
//		System.out.println(
//				Arrays.toString(lottoCompare.userBall.lottoObj[0].getLots()));
	}

}





