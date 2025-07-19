package hk.edu20240730.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class D1_UDPClient {
	 public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (DatagramSocket socket = new DatagramSocket()) {
        	//hostname: hankyung.com --> getByName을 사용하면 ip주소를 담은 InetAddress객체를 반환해줌
            InetAddress address = InetAddress.getByName(hostname);
            
            byte[] buffer = new byte[512];

            //키보드로 입력된 내용을 읽어 들이기 위한 설정 System.in 은 키보드로 입력된 데이터
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String text="";
            while (true) {
                System.out.print("Enter text: ");
                text = reader.readLine();//키보드로 입력된 정보를 한라인씩 읽어 들인다.
                buffer = text.getBytes();//읽어 들인 문자열을 바이트로 변환해서 배열에 저장
                //전송할 데이터를 패킷으로 생성한다. packet은 네트워크계층에서 전송단위이다.
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);//전송용패킷
                socket.send(packet);//데이터그램 패킷을 소캣으로 전송한다.

                //서버에서 전송한 데이터를 수신할 패킷생성
                packet = new DatagramPacket(buffer, buffer.length);//수신용패킷
                socket.receive(packet);
                //byte 배열을 0번째부터 해당 길이까지 문자열로 변환(byte배열 --> 문자열)
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
