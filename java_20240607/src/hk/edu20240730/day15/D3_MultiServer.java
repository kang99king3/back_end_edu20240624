package hk.edu20240730.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class D3_MultiServer {

	public static void main(String[] args) {
		Socket clientSocket = null;//클라이언트 소켓
		
		
		try {
			//서버 소켓 생성
			ServerSocket serverSocket=new ServerSocket(9595);
			System.out.println("Server is running.....");
			
			while(true) {
				//클라이언트로부터 요청을 승인(연결확인)후 클라이언트 소켓 얻어옴 --> TCP방식
				clientSocket = serverSocket.accept();
				//클라이언트 호스트 이름 가져오기: 정보 가져오기
				System.out.println("클라이언트 연결됨:"
							     +clientSocket.getInetAddress().getHostName());
				
				//스레드를 이용해서 여러 클라이언트를 동시에 처리한다.
				//스레드로 구현하지 않으면 serverSocket.accept()에서 먼저 요청된 클라이언트 처리작업이 
				//완료되기 전까지 새로운 클라이언트 요청은 대기하게 된다.(지연 및 동시작업X)
				new D3_MultiServer().new ServerThread(clientSocket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(clientSocket!=null) {
					clientSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//main메서드 종료
	
	//직접 스레드를 상속받아 구현 방법
	class ServerThread extends Thread{
		//연결된 클라이언트 소켓객체를 저장할 맴버필드
		Socket clientSocket;
		
		public ServerThread() { }
		
		public ServerThread(Socket clientSocket) {
			this.clientSocket=clientSocket;
		}
		
		@Override
		public void run() {
			PrintWriter out = null; // 클라이어트로 출력할때 사용할 객체
			BufferedReader in = null;// 서버로 읽어들일때 사용할 객체
			
			try {
				//클라이언트 소켓으로 보낼 outputstream객체 생성하고, printWriter로 생성
				out = new PrintWriter(clientSocket.getOutputStream(),true);
				//클라이언트 소켓으로부터 읽어들일 inputstream객체 생성
				in = new BufferedReader(
						                new InputStreamReader(
								                   clientSocket.getInputStream()
								                   )
						               );
				String inputLine;
				while((inputLine=in.readLine())!=null) {
					System.out.println("클라이언트로부터 전달되는 메시지:"+inputLine);
					//클라이언트로 보낼 메시지
					out.println("니가 보낸 메시지:"+inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(out!=null) {
						out.close();
					}
					if(in!=null) {
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}





















