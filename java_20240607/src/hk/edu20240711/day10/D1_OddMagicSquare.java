package hk.edu20240711.day10;

import java.util.Iterator;

//홀수마방진
public class D1_OddMagicSquare {

	public int [][] magic;
	
	public D1_OddMagicSquare() {
		this.magic=new int[3][3];//기본 구성 3X3 생성
	}
	
	public D1_OddMagicSquare(int n) {
		this.magic=new int[n][n];
	}
	
	public void make() {
		int n=magic.length;
		// 1의 값은 첫번째 배열의 중간 인덱스에 저장하고 시작
		int x=0;
		int y=n/2;// 3*3 --> 1 , 5*5 --> 2  : 배열의 중간 인덱스를 구할 수 있다.
		magic[x][y]=1;//중간에 1을 넣고 시작한다. --> 규칙임
		
		//2~9까지 숫자를 배열에 넣기
		for (int i = 2; i <= n*n; i++) { // 여기서 변수 i는 입력될 값으로 쓰임
			//변경전 값을 저장해둠
			int tempX=x;//값을 복사해서 전달
			int tempY=y;//값을 복사해서 전달
			
			if(x-1<0) {
				x=n-1;//인덱스 최대값을 저장
			}else {
				x--;
			}
			
			if(y-1<0) {
				y=n-1;//인덱스의 최대값을 저장
			}else {
				y--;
			}
			
			if(magic[x][y]!=0) {//이동한 위치에 값이 있다면..
				x=tempX+1;// 원래 위치로 돌아오고 x+1을 한다.
				y=tempY;//원래 위치로 돌아온다.
			}
			magic[x][y]=i;//최종 이동한 위치에 증가된 값을 저장한다.
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







