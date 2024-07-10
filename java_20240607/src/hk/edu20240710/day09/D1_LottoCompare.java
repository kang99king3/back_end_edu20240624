package hk.edu20240710.day09;

//구매한 로또를 당첨번호와 비교해서 결과를 보여줄 클래스
public class D1_LottoCompare {

	//당첨번호
	public D1_Lotto lottoBall;
	
	//구매한 로또의 번호들
	public D1_LottoStore userBall;
	
	public D1_LottoCompare() {
		this.lottoBall=new D1_Lotto();
		this.userBall=new D1_LottoStore();//기본 5장 구매
	}
	
	public D1_LottoCompare(int n) {
		this.lottoBall=new D1_Lotto();
		this.userBall=new D1_LottoStore(n);//원하는 수량 구매
	}
	
	//당첨번호를 비교하는 메서드
	
	
	//배열에 중복 숫자가 있는지 확인하는 메서드: 반환타입 boolean
	//배열하고, 숫자하나에 대한 비교
	public boolean isSame(int[] a, int b) {
		boolean isS=false;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==b) {
				isS=true;
				break;
			}
		}
		return isS;
	}
	
	//당첨개수를 확인해서 등수를 출력하는 기능
	//6개:1등 5:2등 ...... 
}










