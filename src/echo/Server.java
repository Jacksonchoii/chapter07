package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 서버 소켓 객체 생성
		ServerSocket serverSocket = new ServerSocket();

		// 바인드 192.168.0.5 , 10001
		serverSocket.bind(new InetSocketAddress("192.168.0.5", 10001));

		System.out.println("<서버시작>");
		System.out.println("=========================================");
		System.out.println("[연결을 기다리고 있습니다.]");

		while (true) {
			// accept
			Socket socket = serverSocket.accept();
			System.out.println("[클라이언트가 연결되었습니다.]");
			
			// 출장 보내기 .start();
			Thread thread = new ServerThread(socket);
			thread.start();
		
						
		}
		/* 반복문이 무한루프라 꿑냐눈 로직 추가 안함
		System.out.println("================================");
		System.out.println("<서버종료>");
		serverSocket.close();
		*/
	}

}
