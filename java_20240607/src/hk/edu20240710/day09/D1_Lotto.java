package hk.edu20240710.day09;

//Lotto클래스 ---> 로또한장
public class D1_Lotto {

	//6개의 번호를 저장할 배열
	private int [] lots;//배열선언
	
	//생성자: 클래스 맴버필드를 초기화
	public D1_Lotto() {
		lots=new int [6];
		makeLotto();
	}
	
	//생성자 오버로딩
	public D1_Lotto(int n) {
		lots=new int [n];
		makeLotto();
	}
	
	//1~45까지의 숫자를 랜덤하게 생성하는 기능
	public int makeBall() {
		//Math클래스에 random()메서드를 활용
		//0부터 1사이의 실수를 반환 : 0.0000000...1 ~ 0.9999999....
		//0.99999 *45 ----> 1*45 --> 44.99999 ---> 0~44  + 1 = 1~45
		return (int)(Math.random()*45)+1;
	}
	
	//1~45 사이의 숫자를 배열에 넣어주는 메서드 
	public void makeLotto() {
//		for (int i = 0; i < this.lots.length; i++) {
//			lots[i]=makeBall();//중복된 숫자가 포함되어 있는지 판별이 필요
//		}
		
		int count=0;
		while(count<lots.length) {
			int b=makeBall();//랜덤숫자 생성
			if(!Util.isSame(lots, b)) {//중복숫자가 없다면
				lots[count++]=b;//배열에 숫자 저장
			}
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
	
	//배열lots가 private으로 선언되어 있어
	//메서드를 통해서 가져올 수 있도록한다.
	public int[] getLots() {
		return lots;
	}


	
	
}









