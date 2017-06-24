import com.sun.org.apache.regexp.internal.RE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by 변성호 on 2017-06-24.
 */
public class ClientRe extends Thread{
    private Socket SK;// Socket
    public void run(){
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(SK.getInputStream()));
            String Recive;
            String[] split;
            while(true){
                Recive = buf.readLine();
                split = Recive.split(":");
                if(split.length >= 2 && split[0].equals(Client.ID)){
                    continue;
                }
                System.out.println(Recive);
            }

        }catch (IOException e){

            System.out.println("Server Error");
        }
    }
    public void getSoc(Socket SK){
        this.SK = SK;
    }
}
