package hk.edu20240711.day10;

public class D1_EvenMagicSquare {
	
	public int [][] magic;

	public void setMagic(int[][] magic) {
		this.magic = magic;
	}

	public D1_EvenMagicSquare() {
		this.magic=new int [4][4];
	}
	
	public D1_EvenMagicSquare(int n) {
		this.magic=new int [n][n];
	}
	
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
	
	//마방진 출력하기
		public void magicPrint() {
			int n=magic.length;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(magic[i][j]+"\t");
				}
				System.out.print(sumCol(i));
				System.out.println();
			}
			for (int i = 0; i < magic.length; i++) {
				System.out.print(sumRow(i)+"\t");
			}
			
			System.out.println("\n대각선의 합:"+sumDia()+","+sumRevDia());
			System.out.println("마방진 확인:"+isCheck());
		}
		
		//--마방진 증명 확인하기-- 
		//가로의 합,  [0][0 -> 1 -> 2] 
		public int sumCol(int j) {
			int tot=0;
			for (int i = 0; i < magic.length; i++) {
					tot+=magic[j][i];
			}
			return tot;
		}
		//세로의 합, [0 -> 1 -> 2][0]
		public int sumRow(int j) {
			int tot=0;
			for (int i = 0; i < magic.length; i++) {
					tot+=magic[i][j];
			}
			return tot;
		}
		//대각선(왼쪽)합
		public int sumDia() {
			int tot=0;
			for (int i = 0; i < magic.length; i++) {
				tot+=magic[i][i];
			}
			return tot;
		}
		//대각선(오른쪽)합, 
		public int sumRevDia() {
			int tot=0;
			for (int i = 0; i < magic.length; i++) {
				tot+=magic[i][magic.length-1-i];
			}
			return tot;
		}
		//각각의 합의 결과값들이 같은지 비교 ---> 합의 결과가 모두 같다면 마방진이 맞음
		public boolean isCheck() {
			boolean isC=true;
			
			int n=magic.length;
			int [] ma=new int[n*2+2];//가로,세로,대각선 합을 저장할 배열정의
			
			for (int i = 0; i < n; i++) {
				ma[i]=sumRow(i);// 0 1 2
				ma[i+n]=sumCol(i);  //   3 4 5
			}
			ma[2*n]=sumDia();// 6
			ma[2*n+1]=sumRevDia();// 7      --> ma배열에 모든 합을 저장
			
			for (int i = 1; i < ma.length; i++) {
				if(ma[0]!=ma[i]) {
					isC=false;
					break;
				}
			}
			
			return isC;
		}
}
