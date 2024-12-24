package hk.edu20240711.day10;

import java.util.Iterator;

public class D3_SixMagicSquare2 extends D3_MagicSquare{
	
	public D3_SixMagicSquare2() {
		super(6);
	}
	
	public D3_SixMagicSquare2(int n) {
		super(n);
	}
	
	@Override
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
	
}
