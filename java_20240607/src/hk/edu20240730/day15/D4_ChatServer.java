package hk.edu20240730.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class D4_ChatServer {
	
	private static final int PORT = 12345;
	private static Set<PrintWriter> clients = new HashSet<>();
	
	public static void main(String[] args) {
	    System.out.println("--채팅 서버 시작--");
	    ServerSocket serverSocket = null;
	
	    try {
	    	//서버소켓 생성
	        serverSocket = new ServerSocket(PORT);
	
	        while (true) {
	        	//클라이언트의 요청을 확인하고 연결하여 클라이언트 소켓 생성
	            Socket clientSocket = serverSocket.accept();
	            //클라이언트 소켓 스레드 생성 및 실행
	            new ClientHandler(clientSocket).start();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (serverSocket != null && !serverSocket.isClosed()) {
	            try {
	                serverSocket.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        //클라이언트 소켓 객체 초기화
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
            	//클라이언트 소켓에서 읽어들일 inputStream객체 생성
            	//char(2byte)단위로 문자를 읽어 줄 inputStreamReader 객체 생성
            	//필터 BufferedReader객체 생성: 읽어들인 데이터를 모아서 라인단위로 읽어들이기 위해 사용
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //클라이언트 소켓에 출력을 위한 OutputStream객체 생성
                //클라이언트로 출력할 PrintWriter객체 생성
                out = new PrintWriter(socket.getOutputStream(), true);

                //client로 출력할 객체 PrinterWriter를 clients에 저장
                //동시적으로 접근하면 오류가 발생될 여지가 있으므로 동기화 블럭 설정
                synchronized (clients) {
                	clients.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("받은 메시지: " + message);
                    //clients에 동시적으로 접근하지 못하도록 동기화 블럭 설정
                    synchronized (clients) {
                    	//채팅 참가자들 모두에게 메시지 전달
                        for (PrintWriter writer : clients) {//Set은 Iterator 패턴으로 꺼낼 수 있다.
                            writer.println(message);        //향상된 for문-iterator 패턴 사용
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    synchronized (clients) {
                    	clients.remove(out);
                    }
                }
                if (socket != null && !socket.isClosed()) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
