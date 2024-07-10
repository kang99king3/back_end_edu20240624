package hk.edu20240709.day08;

import java.util.Arrays;

public class D3_ArrayTest {

	//생성자를 통해서 배열 초기화
	public int [] test;
	public int [][] test2;
	
	public D3_ArrayTest() { //default생성자
		test=new int[3];
		test2=new int[3][3];
	}
	
	public D3_ArrayTest(int n) {//생성자 오버로딩
		test=new int[n];
		test2=new int[n][n];
	}
	
	public D3_ArrayTest(int m,int n) {//생성자 오버로딩
		test=new int[n];
		test2=new int[m][n];
	}
	
	public static void main(String[] args) {
		//선언 방법
		//1.리터럴 방식: 기본타입처럼 선언하는 방법
		//            변수 선언과 값을 동시에 정의
		int[] a= {1,2,3,4,5,6};
		int[] b;//선언
//		b= {1,2,3,4,5};// (X) 따로 값만 정의하는 경우
			b=a;// 복사
			System.out.println(b[1]);
		
		//값을 가져오는 방법: 인덱스를 통해 가져온다.
		int val=a[0];//값 가져오기
		a[0]=10; //값을 저장하기
		a[1]=3;
		
		//2. new를 사용해서 정의한다.
		int[] b2;
		b2=new int[] {1,3,2,4,5};
		
		int[] b3=new int[5];//선언,정의
		b3[0]=1; b3[1]=2;
		
		//출력 
		for (int i = 0; i < b3.length; i++) {
			System.out.println(b3[i]);
		}
		
		//Arrays클래스
		System.out.println(Arrays.toString(b3));
		//- 배열의 값을 정렬
		Arrays.sort(b2);//배열안에 값을 정렬(mutable)
		System.out.println(Arrays.toString(b2));
		
		String s="aa";
		s=s.replace("a", "b");//값이 변경안됨(immutable) 반드시 대입을 해줘야한다.
		
		//shallow copy(얕은 복사:주소 복사)
		int[] c= {1,2,3,4,5};
		int[] d=c;// c주소--->d에 복사
		d[0]=10;
		System.out.println(Arrays.toString(c));
		
		//deep copy(깊은 복사:값을 복사)
		int[] e=new int [5];
		for (int i = 0; i < c.length; i++) {
			e[i]=c[i];
		}
		
		e[1]=50;
		System.out.println(Arrays.toString(c));
		
		//깊은복사 기능을 제공하는 메서드
		//System.arraycopy(원본배열,복사할시작인덱스,복사해줄배열,복사시작인덱스,길이)
		int[]f=new int[5];
		System.arraycopy(c, 0, f, 0, f.length);
		f[3]=80;
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(f));
		
	
		//2차원배열
		int [][] aa= {{1,2,3},{4,5,6}};
		int [][] bb=new int[][] {{1,2,3},{4,5,6}};
		int [][] cc=new int[2][3];//선언만 할 경우 저장공간까지는 정의
		
		//배열의 길이값
		System.out.println("aa배열의 길이:"+aa.length);
		System.out.println("aa배열의 내부 배열 길이:"+aa[0].length);
		
		for (int i = 0; i < aa.length; i++) {
			for (int j = 0; j < aa[0].length; j++) {
				System.out.print(aa[i][j]+" ");				
			}
			System.out.println();
		}
		
		//배열에서 값 가져오기 예시
		int aaV=aa[0][0];//int형의 기본타입 값을 가져옴
		aa[0][1]=10;
		int [] aaA=aa[0];//int형의 배열을 가져옴
		
		//배열 변환
		//2차원 --> 1차원 변환
		int [][] dd=new int[][] {{1,2,3},{4,5,6}};
		int [] d1= new int[dd.length*dd[0].length];//2차원배열의 값의 개수만큼 길이구하기
		//공식: i*col+j = 0*3+0 = 0     "col은 2차원배열의 내부 배열길이"
		//     i*col+j = 0*3+1 = 1
		//	   i*col+j = 0*3+2 = 2
		//	   i*col+j = 1*3+0 = 3
		//	   i*col+j = 1*3+1 = 4
		//	   i*col+j = 1*3+2 = 5

		for (int i = 0; i < dd.length; i++) {
			for (int j = 0; j < dd[0].length; j++) {
				d1[i*dd[0].length+j]=dd[i][j];
			}
		}
		
		System.out.println(Arrays.toString(d1));
		
		//1차원 --> 2차원 변환
		//[i/col][i%col]
		//[0/3][0%3] [1/3][1%3] [2/3][2%3] [3/3][3%3] ....
		//  0    0     0    1     0    2     1    0     1   1   1   2
		int [][] ddd=new int [2][3];
		int col=ddd[0].length;
		for (int i = 0; i < d1.length; i++) {
			ddd[i/col][i%col]=d1[i];
		}
		System.out.println(Arrays.toString(ddd));
		System.out.println(Arrays.toString(ddd[0]));
		System.out.println(Arrays.toString(ddd[1]));
	}
	

}















