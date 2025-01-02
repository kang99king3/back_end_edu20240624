package hk.edu20240711.day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class D2_CompareNumbers {

	private int [] pitcher;
	private int [] hitter;
	
	public D2_CompareNumbers() {
		// TODO Auto-generated constructor stub
	}
	
	public void compareBaseBall() {
		
		D2_pitcher d2_pitcher=new D2_pitcher();//투수객체생성
		pitcher=d2_pitcher.getPitcherNums();//투수숫자3개가 저장된 배열 저장
		
		D2_hitter d2_hitter=new D2_hitter();//타자객체생성
		hitter=d2_hitter.getHitterNums();//타자숫자 저장할 배열 저장
		
		Scanner scan=new Scanner(System.in);
		
		int count=1;
		while(count<=10) {
			//초기화
			int strike=0;
			int ball=0;
			String out="";
			
			//입력값 받기
			String nums = scan.next();
			
			if(!isSame(nums)) {//중복숫자를 입력하지 않았다면
				//0을 제외하고, 3자리까지 입력했다면
				if(nums.indexOf("0")==-1&&nums.length()==3) {
					d2_hitter.makeHitter(nums);//입력된 숫자를 타자배열에 저장
					
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
				}else {
					System.out.println("입력값은 0을 포함할 수 없으며,\n 숫자는 3개까지만 입력 가능합니다.");
				}
			}else {
				System.out.println("중복숫자는 입력할 수 없습니다.");
			}

		}
	}
	//중복숫자 체크
	public boolean isSame(String str) {
	//Set을 사용하면 간단히 해결할 수 있다.set은 중복값을 허용하지 않는다.
//		Set<Character> set=new HashSet<>();
//		for (Character character : str.toCharArray()) {
//			if(!set.add(character)) {
//				isS=true;
//				break;
//			}
//		}
		char[] nums=str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			char c=str.charAt(i);
			int count=0;
			//문자열 str에서 문자하나 추출해서 
			//char배열에 중복되는 문자가 있는지 확인하여 중복문자가 있다면 count증가
			for (int j = 0; j < str.length(); j++) {
				if(nums[j]==c) {
					count++;
				}
			}
			//문자하나에 대해 확인후 중복되는 문자가 있으면 count는 2이상이됨
			//자신의 수가 포함되어 있어 기본값 count는 1이 되고 
			//중복하는 문자가 있다면 count는 2이상이 됨
			if(count>1) {
				return true;
			}
		}
		return false;
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
