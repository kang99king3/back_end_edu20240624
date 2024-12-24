package hk.edu20240711.day10;

import java.util.Iterator;
import java.util.Scanner;

public class D2_CompareNumbers {

	private int [] pitcher;
	private int [] hitter;
	
	public D2_CompareNumbers() {
		// TODO Auto-generated constructor stub
	}
	
	public void compareBaseBall() {
		D2_pitcher d2_pitcher=new D2_pitcher();
		pitcher=d2_pitcher.getPitcherNums();
		
		D2_hitter d2_hitter=new D2_hitter();
		hitter=d2_hitter.getHitterNums();
		
		Scanner scan=new Scanner(System.in);
		
		int count=1;
		while(count<=10) {
			//초기화
			int strike=0;
			int ball=0;
			String out="";
			
			//입력값 받기
			String nums = scan.next();
			
			if(nums.indexOf("0")==-1&&nums.length()<=3) {
				d2_hitter.makeHitter(nums);
				
				for (int i = 0; i < pitcher.length; i++) {
					for (int j = 0; j < hitter.length; j++) {
						if(i==j && pitcher[i]==hitter[j]) {//자릿수, 숫자 모두 일차한다면 
							strike++; //strike 증가
						}else if(i!=j && pitcher[i]==hitter[j]) {// 자릿수는 다르면서 숫자가 일치하면 
							ball++;    //ball 증가
						}
					}
				}
				if(strike==0&&ball==0) {
					out="out";
				}
				
			}else {
				System.out.println("입력값은 0을 포함할 수 없으며,\n 숫자는 3개까지만 입력 가능합니다.");
			}
			
			//중간 결과 출력하기
			System.out.printf("Strike:%d Ball:%d %s",strike,ball,out);
			
			//스트라이크 3개면 모두 일치이므로 타자 승리 및 게임 종료
			if(strike==3) {
				System.out.println("모두 일치!! 타자 승리!!");
				break;
			}

			//시도 횟수 10번까지 타자가 못 맞추면 투수 승리
			if(count==10) {
				System.out.println("투수 승리!!");
				break;
			}
			
			System.out.println("시도횟수:"+(count++));

		}
	}
	
	
	
	public int[] getPitcher() {
		return pitcher;
	}
	public void setPitcher(int[] pitcher) {
		this.pitcher = pitcher;
	}
	public int[] getHitter() {
		return hitter;
	}
	public void setHitter(int[] hitter) {
		this.hitter = hitter;
	}
	
	
	
}
