package hk.edu20240711.day10;

public abstract class D3_MagicSquare implements D3_Interface_Magic{

	protected int [][] magic;
	
	public D3_MagicSquare(int n) {
		this.magic=new int[n][n];
	}
	
	public abstract void make();//추상메서드
	
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
