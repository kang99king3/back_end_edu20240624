package hk.edu20240711.day10;

public class D1_MagicSquareMain {

	public static void main(String[] args) {
		
		D1_OddMagicSquare odd=new D1_OddMagicSquare(3);
		odd.make();
		odd.magicPrint();
		
		D1_EvenMagicSquare evenMagic=new D1_EvenMagicSquare();
		evenMagic.make();
		evenMagic.magicPrint();
		
		D1_SixMagicSquare sixMagic=new D1_SixMagicSquare();
		sixMagic.make();
		sixMagic.magicPrint();
		
//		for (int i = 0; i < odd.magic.length; i++) {
//			System.out.println(odd.sumCol(i));	
//			System.out.println(odd.sumRow(i));
//		}
//			System.out.println(odd.sumDia());
//			System.out.println(odd.sumRevDia());
//			System.out.println(odd.isCheck());
		
		
	}

}






