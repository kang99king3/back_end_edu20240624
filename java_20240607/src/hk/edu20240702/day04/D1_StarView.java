package hk.edu20240702.day04;

public class D1_StarView {

	public static void main(String[] args) {
		/*                             a1 + (n-1)*d
			0★       0 + 1  = 1        1  + (0)*1    자바에서는 이미 0부터시작하니깐
		    1★★      1 + 1  = 2        1  + (1)*1    자릿수에서 -1을 할필요없음
		 	2★★★                       1  + (2)*1
		 	3★★★★
		 	4★★★★★                    ---> 1+i*1 --> 1+i 일반항을 만들 수 있음
		 */
		for (int i = 0; i < 5; i++) { //i는 자릿수
			for (int j = 0; j < 1+i; j++) { // j는 값
				System.out.print("★");
			}
			System.out.println();//줄바꿈만 해줌
		}
		
//		for (int i = 0; i < 5; i++) { //i는 자릿수
//			for (int j = 0; j < 1+i*2; j++) { // j는 값
//				System.out.print("★");
//			}
//			System.out.println();//줄바꿈만 해줌
//		}
		
		/* 2.오른쪽 삼각형            a1+n*d 
		  ☆☆☆☆★                   4+i*-1 = 4-i  공백을 구하는 일반항 
		  ☆☆☆★★
		  ☆☆★★★                   1+i*1 = 1+i   별을 출력할 일반항
		  ☆★★★★
		  ★★★★★
		 */
		System.out.println("==========================");
		int num=10;
		 for (int i = 0; i < num; i++) {
			for (int j = 0; j < num-1-i; j++) { //공백
				System.out.print("☆");
			}
			for (int j = 0; j < 1+i; j++) { // 별
				System.out.print("★");
			}
			System.out.println();
		}
		
		/* 3.정삼각형
		  ☆☆☆☆★                    4+i*-1 = 4-i  공백을 구하는 일반항 
		  ☆☆☆★★★
		  ☆☆★★★★★                  1+i*2   별을 출력하는 일반항
		  ☆★★★★★★★
		  ★★★★★★★★★
		 */
		 System.out.println("=========================");
		 for (int i = 0; i < num; i++) {
			for (int j = 0; j < num-1-i; j++) {
				System.out.print("☆");
			}
			for (int j = 0; j < 1+i*2; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		 
		/*  4.아래방향 정삼각형
		  	★★★★★★★★★            공백출력: 0 1 2 3 4     0 + i*1 = i
		  	☆★★★★★★★             별출력 :  9 7 5 3 1     9 + i*-2 = 9-(i*2) 
		  	☆☆★★★★★ 
		  	☆☆☆★★★
		  	☆☆☆☆★
		 */
		 System.out.println("=====================");
		 int num2=10;
		 for (int i = 0; i < num2; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("☆");
			}
			for (int j = 0; j < (num2*2-1)-(i*2); j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		 
		 
		 /* 5.아래방향 직삼각형
		  	★★★★★             5-i
		  	★★★★
		  	★★★ 
		  	★★
		  	★
		 */
		 for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5-i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		 /* 6.마름모
	  			☆☆☆☆★                   
		  		☆☆☆★★★
		  		☆☆★★★★★                 
		  		☆★★★★★★★
		  		★★★★★★★★★
		  		☆★★★★★★★
		  		☆☆★★★★★ 
		  		☆☆☆★★★
		  		☆☆☆☆★
		  */
		 System.out.println("=========================");
		 //위쪽방향 정삼각형
		 for (int i = 0; i < num; i++) {
			for (int j = 0; j < num-1-i; j++) {
				System.out.print("☆");
			}
			for (int j = 0; j < 1+i*2; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		 //아래쪽방향 정삼각형
		 for (int i = 0; i < num-1; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("☆");
			}
			for (int j = 0; j < ((num-1)*2-1)-(i*2); j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		 
		//절대값 이용해서 출력
		  int aa=9;
	      for (int i = 0; i < aa; i++) {
//		         System.out.println(i);
	         for (int j = 0; j < Math.abs(aa/2-i); j++) { // 4 3 2 1 0 1 2 3 4
	            System.out.print(" ");
	         }
	         for (int j = 0; j < aa-Math.abs(aa-1-i*2); j++) {  //1 3 5 7 9  7  5  3  1
	            System.out.print("*");                          //8 6 4 2 0 -2 -4 -6 -8
	         }
	         System.out.println();
	      }
	}
}















