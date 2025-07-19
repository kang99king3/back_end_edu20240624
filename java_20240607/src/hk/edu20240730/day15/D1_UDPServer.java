package hk.edu20240730.day15;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//에코서버 구현: 데이터를 보내면 다시 되돌려 주는 서버로 테스트용도로 쓰인다.
public class D1_UDPServer {
	public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(5000)) {
            byte[] buffer = new byte[512];
            //수신용 패킷 생성
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Server is listening on port 5000");
            while (true) {
            	//클라이언트에서 보낸 데이터가 소켓으로 전달되고, 데이터를 패킷으로 받는다.
                socket.receive(packet);
                //받은 패킷에서 데이터와 패킷 길이를 구해서 문자열로 변환한다.
                String received = new String(packet.getData(), 0, packet.getLength());
                //전달받은 데이터를 출력한다.
                System.out.println("Received: " + received);
                
                //------서버에서 받은 데이터를 클라이언트에게 다시 보낸다.
                //패킷으로 부터 주소를 얻어온다.-> 주소정보를 담고 있는 InetAddress객체 반환
                InetAddress address = packet.getAddress();
                //패킷으로 부터 포트 정보 얻어온다.
                int port = packet.getPort();
                System.out.println("address:"+address.getHostAddress()
                							 +" port:"+port+"로 패킷 전송");
                packet = new DatagramPacket(buffer, buffer.length, address, port);
                socket.send(packet);//서버에서 클라이언트로 보낸다
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
