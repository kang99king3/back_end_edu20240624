package hk.edu20240711.day10;

import java.util.Arrays;
import java.util.Iterator;

public class D2_pitcher {

	private int [] pitcherNums;
	
	//투수배열 정의
	public D2_pitcher() {
		this.pitcherNums=new int[3];
		makePitcher();
		pitcherPrint();
	}
	
	//랜덤 숫자 생성
	public int makeNum() {
		return (int)(Math.random()*9)+1; 
	}
	
	
	public void makePitcher() {
		int i=0;
		while(i<3) {
			int num=makeNum();
			if(!isSameNum(num)) { // 배열에 중복숫자가 없다면 실행
				pitcherNums[i++]=num;
			}
		}
	}
	
	//배열에 중복 숫자가 있는지 판별하는 메서드
	public boolean isSameNum(int num) {
		boolean isS=false;
		
		for (int i = 0; i < pitcherNums.length; i++) {
			if(pitcherNums[i]==num) {
				isS=true;
				break;
			}
		}
		
		return isS;
	}

	public void pitcherPrint() {
		System.out.println("투수입력값:"+Arrays.toString(pitcherNums));
	}
	
	public int[] getPitcherNums() {
		return pitcherNums;
	}

	public void setPitcherNums(int[] pitcherNums) {
		this.pitcherNums = pitcherNums;
	}
	
	
	
}
