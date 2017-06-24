import java.io.*;
import java.net.Socket;



/**
 * Created by 변성호 on 2017-06-13.
 */
public class Start extends Thread{
    private Socket SK;// Socket
    private String Name;
    public void run(){

        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(SK.getInputStream()));
            String send;
            String[] Read;

            while(true){

                send = buf.readLine();
                Read = send.split(":");
                if(Read.length == 2 && Read[0].equals("ID")){
                    Name = Read[1];
                    System.out.println("ID : " + Name);
                }
                for(int i = 0; i < Main.ChatStic.size(); ++i){
                    Main.ChatStic.get(i).println(Name + ": " +send);
                    Main.ChatStic.get(i).flush();
                }
            }

        }catch (IOException e){

            System.out.println("Server Error");
        }
    }
    public void getSoc(Socket SK){
        this.SK = SK;
    }
}


//    ServerSocket Server = null;
//        try {
//                Server = new ServerSocket();
//                Server.bind(new InetSocketAddress(InetAddress.getLocalHost(),5001));
//
//                while(true){
//                System.out.println("연결 기다림 :::");
//                Socket socket = Server.accept();
//                InetSocketAddress is = (InetSocketAddress) socket.getRemoteSocketAddress(); // 내아이피만 접속 허용
//                System.out.println("연결 완료 :)");
//
//                ArrayList<Byte> by = new ArrayList<Byte>();
//        String mess = null;
//
//        InputStream ip = socket.getInputStream(); //읽기 기초
//        int read = ip.read(by);
//        mess = new String(by,0,read,"UTF-8"); // 0번쨰부터 끝까지 읽기.
//
//
//        OutputStream os = socket.getOutputStream();
//        by = mess.getBytes("UTF-8");// 이형식으로 출력
//        os.write(by);// 써주기
//        os.flush(); // 자워 풀어주기
//        System.out.println(" 발신 데이터  : "  + mess);// 서버에서출력
//
//        ip.close();
//        os.close();
//        socket.close();
//
//
//        }
//
//
//
//        } catch (IOException e) {
//        try {
//        Server.close();
//        } catch (IOException e1) {
//        e1.printStackTrace();
//        }
//        System.out.println(" 연결 취소");
//        }