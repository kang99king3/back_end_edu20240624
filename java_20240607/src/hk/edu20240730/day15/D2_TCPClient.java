package hk.edu20240730.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class D2_TCPClient {

	public static void main(String[] args) {
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;//서버에서 전달된 메시지를 읽어들일 객체
		BufferedReader userInput = null;//사용자가 키보드로 입력하는 메시지를 읽어들일 객체
		
		try {
//		socket=new Socket("192.168.22.81",9595);
			socket=new Socket("localhost",9595);// (접속하려는 서버 주소, 접속하려는 서버 포트)
			System.out.println("Client:Connection to server...");
			out=new PrintWriter(socket.getOutputStream(),true);//true는 자동 flush설정임
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//소켓으로 부터 읽어 들이기
			userInput=new BufferedReader(new InputStreamReader(System.in));//키보드로 입력받은 값 읽어 들이기
		
			String inputLine="";
			while ((inputLine=userInput.readLine())!=null) {//키보드로 입력한 내용이 있다면
				out.println(inputLine);//키보드로 입력된 내용을 소켓으로 출력
				System.out.println(in.readLine());//서버에서 전달된 메시지를 읽고 출력하기
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(out!=null) {
					out.close();
				}
				if(in!=null) {
					in.close();
				}
				if(userInput!=null) {
					userInput.close();
				}
				if(socket!=null) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}









