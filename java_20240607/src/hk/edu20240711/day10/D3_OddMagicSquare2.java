package hk.edu20240711.day10;

import java.util.Iterator;

//홀수마방진
public class D3_OddMagicSquare2 extends D3_MagicSquare{
	
	public D3_OddMagicSquare2() {
		super(3);
	}
	
	public D3_OddMagicSquare2(int n) {
		super(n);
	}
	
	//부모의 메서드를 자식이 재정의한다.
	@Override
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
	
	
	
	
}







