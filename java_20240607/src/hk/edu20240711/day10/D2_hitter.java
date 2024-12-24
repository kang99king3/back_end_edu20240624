package hk.edu20240711.day10;

import java.util.Arrays;

public class D2_hitter {

	private int[] hitterNums;
	
	public D2_hitter() {
		this.hitterNums=new int [3];
	}

	//타자가 입력한 숫자 3개를 배열에 저장한다.
	public void makeHitter(String nums) {
		//입력받은 값은 문자열로 받아서 int형으로 변환하여 저장한다.
		for (int i = 0; i < hitterNums.length; i++) {
			//숫자형의 문자열을 정수형으로 변환하는 parseInt() 활용
			//charAt()은 문자열에서 문자하나를 추출할 수 있다.
			hitterNums[i]=Integer.parseInt(nums.charAt(i)+"");
		}
		hitterPrint();
	}
	
	public void hitterPrint() {
		System.out.println("타자 입력값:"+Arrays.toString(hitterNums));
	}
	
	public int[] getHitterNums() {
		return hitterNums;
	}

	public void setHitterNums(int[] hitterNums) {
		this.hitterNums = hitterNums;
	}
	
	
	
	
}
