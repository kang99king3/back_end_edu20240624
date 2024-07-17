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
				// 객체가 null일때 close()를 실행하면 오류발생될 수 있어서..
				if(out!=null) {
					out.close();//마지막에 실행된 객체부터 닫아준다.					
				}
				if(in!=null) {
					in.close();					
				}
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
				if(bw!=null) {
					bw.close();					
				}
				if(ow!=null) {
					ow.close();				
				}
				if(out!=null) {
					out.close();				
				}
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
				if(ds!=null) {
					ds.close();					
				}
				if(out!=null) {
					out.close();			
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//한번에 읽을때 크기를 설정해서 읽고 쓰기
	public static void test03() {
		InputStream in=null;
		OutputStream out=null;
		
		try {
			in=new FileInputStream("C:\\Users\\user\\test_IMG.png");
			out=new FileOutputStream("C:\\Users\\user\\test_IMG_copy.png");
			
			//10byte 단위 읽기
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}













