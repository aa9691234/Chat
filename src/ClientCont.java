import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by 변성호 on 2017-06-24.
 */
public class ClientCont  extends Thread{

    private Socket SK;// Socket
    public void run(){
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter Writ = new PrintWriter(SK.getOutputStream());

            String send;

            System.out.println("Write you ID : ");
            Client.ID = buf.readLine();
            Writ.println("ID:" + Client.ID);
            Writ.flush();
            while(true){
                send = buf.readLine();
                Writ.println(send);
                Writ.flush();
            }






        }catch (IOException e){

            System.out.println("Server Error");
        }
    }
    public void getSoc(Socket SK){
        this.SK = SK;
    }


}
