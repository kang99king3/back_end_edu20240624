package hk.edu20240710.day09;

import java.util.Arrays;

public class D1_LottoMain {

	public static void main(String[] args) {
		
		D1_Lotto lotto=new D1_Lotto();
		
//		System.out.println(lotto.makeBall());
		
//		lotto.makeLotto();//6개생성해서 배열에 담는다
		System.out.println(Arrays.toString(lotto.getLots()));
	}

}
