package hk.edu20240711.day10;

import java.util.Iterator;

public class D1_SixMagicSquare {
	
	public int [][] magic;
	
	public D1_SixMagicSquare() {
		magic=new int[6][6];
	}
	
	public D1_SixMagicSquare(int n) {
		magic=new int[n][n];
	}
	
	public void make() {
		makeA();
		makeB();
		makeCD();
		multi();
		makeAdd();
	}
	
	// A영역에 n/4영역을 3으로 채우는 메서드
	public void makeA() {
		int n=magic.length;
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/4; j++) {
				if(i==n/4) {
					magic[i][j+1]=3;					
				}else {
					magic[i][j]=3;
				}
			}
		}
	}
	
	// B역역에 2로 채우고 마지막 열에 1로 채우는 메서드
	// 6마방진--> 1로 채우는 열:0, 10마방진--> 1로 채우는 열:1, 14마방진-->1로 채우는 열:2 ...
	// 값을 2로 채우다가 1로 채우는 방법이 어려우니 먼저 1로 모두 채운뒤에 해당영역에 2로 채운다.
	public void makeB() {
		int n=magic.length;
		//1을 먼저 B영역에 모두 채운다
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				magic[i][j+n/2]=1;
			}
		}
		//2를 해당 부분에 채운다. 
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2-(n/4-1); j++) {
				magic[i][j+n/2]=2;
			}
		}
		//결론은 22221 이런식으로 마지막에 1이 채워지게 됨
	}
	
	// A영역 --> C영역 값 반전,  B역역 --> D영역 값 반전
	public void makeCD() {
		int n=magic.length;
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				if(magic[i][j]==3) {
					magic[i+n/2][j]=0;
				}else {
					magic[i+n/2][j]=3;
				}
				if(magic[i][j+n/2]==1) {
					magic[i+n/2][j+n/2]=2;
				}else {
					magic[i+n/2][j+n/2]=1;
				}
			}
		}
	}
	
	// 각 영역에 값에 (n/2)*(n/2) 값을 곱한다.
	public void multi() {
		int n=magic.length;
		int m=(n/2)*(n/2);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[i][j]*=m;
			}
		}
	}
	// 각각의 영역에 홀수마방진 값을 더한다
	public void makeAdd() {
		int n=magic.length;
		D1_OddMagicSquare odd=new D1_OddMagicSquare(n/2);
		odd.make();
		int [][] oddMagic=odd.magic;
		
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				magic[i][j]+=oddMagic[i][j];
				magic[i][j+n/2]+=oddMagic[i][j];
				magic[i+n/2][j]+=oddMagic[i][j];
				magic[i+n/2][j+n/2]+=oddMagic[i][j];
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
