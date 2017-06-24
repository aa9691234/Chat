import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by 변성호 on 2017-06-13.
 */
public class    Main {
    public static ArrayList<PrintWriter> ChatStic;


    public static void main(String[] args) {
            ChatStic = new ArrayList<PrintWriter>();
            try {
            ServerSocket Soc = new ServerSocket(5001);
            while(true) {
                Socket SK = Soc.accept();

                Start Send = new Start();
                Send.getSoc(SK);
                ChatStic.add(new PrintWriter(SK.getOutputStream()));

                Send.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


