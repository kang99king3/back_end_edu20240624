package hk.edu20240711.day10;

public class D3_EvenMagicSquare2 extends D3_MagicSquare{

	public D3_EvenMagicSquare2() {
		super(4);
	}
	
	public D3_EvenMagicSquare2(int n) {
		super(n);
	}
	
	@Override
	public void make() {
		makeA();
		makeB();
	}
	
	public void makeA() {
		int n=magic.length;
		for (int i = 0; i < n*n; i++) {
			magic[i/n][i%n]=i+1;// 1차원 배열-->2차원배열 변환 원리
		}
	}
	
	public void makeB() {
		int n = magic.length;
		
		// 16~1 순으로 입력되게 만들어보기
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
////				magic[i][j]=i*n+j;// 0~15가 순차적으로 입력됨
//				magic[i][j]=(n*n)-(i*n+j);// 역순으로 입력하려면 16에서 빼주자
//			}
//		}
		
		// 위 실행결과를 원하는 배열의 위치에서만 실행되게 조건을 주면
		// 마방진을 증명할 수 있게 된다
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if((i>=0&&i<n/4)||(i>=n/4*3&&i<n)) { // i 인덱스 조건
					if(j>=n/4&&j<n/4*3) { //j 인덱스 조건
						magic[i][j]=n*n-(i*n+j);
					}
				}else if(j>=0 && j<n/4 || j>=n/4*3 && j<n) {//j 인덱스 조건
					magic[i][j]=n*n-(i*n+j);
				}
			}
		}
	}
	
}
