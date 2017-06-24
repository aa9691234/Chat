import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
/**
 * Created by 변성호 on 2017-06-24.
 */
public class Client {
        public static String ID;
    public static void main(String[] args) {
        try {
           Socket SK = new Socket(InetAddress.getLocalHost(),5001);

            ClientRe Send = new ClientRe();
            Send.getSoc(SK);
            ClientCont Re = new ClientCont();
            Re.getSoc(SK);



            Re.start();
            Send.start();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
