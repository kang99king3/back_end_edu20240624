package hk.edu20240710.day09;

public class Util {

	//배열안에 중복값 확인하는 기능
	public static boolean isSame(int[] a, int b) {
		boolean isS=false;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==b) {
				isS=true;
				break;
			}
		}
		return isS;
	}
}
