package hk.edu20240716.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class D3_IOTest {

	public static void main(String[] args) {

//		test01();
//		test02();
		test02_1();
	}

	//파일을 읽고 출력하기
	public static void test01() {
		InputStream in=null;//입력파이프 선언
		OutputStream out=null;//출력파이프 선언
		
		try {
			in=new FileInputStream("C:\\Users\\user\\Hello.java");
			out=new FileOutputStream("C:\\Users\\user\\output_Hello.txt");
			
			int i=0;//byte단위로 읽어서 데이터(실제값)를 저장할 변수
			while((i=in.read())!=-1) {//더이상 읽으들일 데이터가 없으면 -1 리턴
				System.out.println((char)i);
				out.write(i);//파일출력하는 코드
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();//마지막에 실행된 객체부터 닫아준다.
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//filter: 보조스트림을 이용해서 출력하기
	public static void test02() {
		OutputStream out=null;//출력 파이프 준비
		OutputStreamWriter ow=null;
		BufferedWriter bw=null;
		String s="파일을 기록합니다.";
		
		try {
			out=new FileOutputStream("C:\\Users\\user\\output_data.java");
			ow=new OutputStreamWriter(out);
			bw=new BufferedWriter(ow);
			bw.write(s);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
//				ds.close();
				bw.close();
				ow.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//filter : 보조스트림을 이용해서 출력하기
	public static void test02_1() {
		OutputStream out=null;//출력을 위한 파이프 준비
		DataOutputStream ds=null;//보조 스트림(filter), 단독으로 사용못함
		
		String s="파일을 기록합니다.";
		try {
			out=new FileOutputStream("C:\\Users\\user\\output_data.txt");
			ds=new DataOutputStream(out);//보조스트림 사용
//				ds.writeUTF(s);//UTF-8형식으로 인코딩된 문자열을 출력해 준다.
			               //문자열을 자동으로 byte로 나눠서 처리
			ds.writeChars(s);
			//보조스트림 미사용시
//				byte [] b=s.getBytes();//문자열을 byte단위로 변환하여 배열로 반환
//				out.write(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ds.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}













