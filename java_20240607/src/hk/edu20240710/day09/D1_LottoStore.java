package hk.edu20240710.day09;

public class D1_LottoStore {

	//Lotto 객체 여러개를 저장해줄 배열 선언
	public D1_Lotto[] lottoObj; // {new Lotto,new Lotto,new Lotto,....}
	
	//2차원배열{{1,2,3,4,5,6},{1,2,3,45,6,7}...}
	public D1_Lotto[][] lotsArray; //여기서는 2차원배열을 사용안함....
	public D1_LottoStore(int m, int n) {
		this.lotsArray=new D1_Lotto[m][n];
	}
	
	public D1_LottoStore() {
		lottoObj=new D1_Lotto[5];// 기본 5장 구매
		makeLotto();
	}
	
	public D1_LottoStore(int n) {
		lottoObj=new D1_Lotto[n];// 원하는 수량 구매
		makeLotto();
	}
	
	public void makeLotto() {
		for (int i = 0; i < lottoObj.length; i++) {
			lottoObj[i]=new D1_Lotto();
		}
	}
	
}





