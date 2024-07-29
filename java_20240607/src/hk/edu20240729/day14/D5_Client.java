package hk.edu20240729.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class D5_Client {

	public static void main(String[] args) {
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;//서버에서 전달된 메시지를 읽어들일 객체
		BufferedReader userInput = null;//사용자가 키보드로 입력하는 메시지를 읽어들일 객체
		
		try {
//		socket=new Socket("192.168.22.81",9595);
			socket=new Socket("localhost",9595);
			System.out.println("Client:Connection to server...");
			out=new PrintWriter(socket.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			userInput=new BufferedReader(new InputStreamReader(System.in));
		
			String inputLine="";
			while ((inputLine=userInput.readLine())!=null) {
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









