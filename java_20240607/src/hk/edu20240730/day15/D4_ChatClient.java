package hk.edu20240730.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class D4_ChatClient {
	private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedReader stIn = null;

        try {
        	//클라이언트 소켓 생성
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            //클라이언트 소켓으로 전달된 메시지 읽어들일 객체 생성
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //클라이언트 소켓으로 메시지를 출력할 객체 생성
            out = new PrintWriter(socket.getOutputStream(), true);
            //키보드로 입력된 메시지를 읽어들일 객체 생성
            stIn = new BufferedReader(new InputStreamReader(System.in));
            //소켓으로 전달된 메시지를 읽으들일 in객체를 스레드로 생성하여 실행: 서버에서 여러 메시지가 전달되므로 동시적으로 처리하기 위함
            new Thread(new IncomingMessagesHandler(in)).start();

            String userInput;
            while ((userInput = stIn.readLine()) != null) {
                out.println(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (stIn != null) stIn.close();
                if (socket != null && !socket.isClosed()) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class IncomingMessagesHandler implements Runnable {
        private BufferedReader in;

        public IncomingMessagesHandler(BufferedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            String serverMessage;
            try {
                while ((serverMessage = in.readLine()) != null) {
                    System.out.println("서버 메시지: " + serverMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
