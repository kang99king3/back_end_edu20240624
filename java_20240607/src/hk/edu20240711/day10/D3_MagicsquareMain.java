package hk.edu20240711.day10;

public class D3_MagicsquareMain {

	public static void main(String[] args) {
//		D3_MagicSquare oddMagicSquare=new D3_OddMagicSquare2(5);
//		oddMagicSquare.make();
//		oddMagicSquare.magicPrint();
//		
//		D3_MagicSquare evenMagicSquare = new D3_EvenMagicSquare2(8);
//		evenMagicSquare.make();
//		evenMagicSquare.magicPrint();
//		
//		D3_MagicSquare sixMagicSquare = new D3_SixMagicSquare2(10);
//		sixMagicSquare.make();
//		sixMagicSquare.magicPrint();
		
		D3_MagicFactory fac=D3_MagicFactory.getInstance();
		D3_Interface_Magic magic;
		
		while(true) {
			try {
				magic=fac.factory();
				//절차대로 메서드를 실행해야 되는 코드--> 템플릿 개념
//				magic.make();
//				magic.magicPrint();
				
				// 실행코드가 항상 동일하기 때문에 객체생성을 계속 할 필요가 없음
//				D3_MagicUtil util=new D3_MagicUtil();
//				util.magicRun(magic);
				
				//magicRun()이라는 템플릿 메서드를 따로 클래스에 만들어 구현함 
				D3_MagicUtil.magicRun(magic);
				break;
			} catch (NoMatchException e) {
				e.printStackTrace();
			}
			
		}
	}

}
