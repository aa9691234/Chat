

import java.io.*;
import java.net.Socket;

/**
 * Created by 변성호 on 2017-06-13.
 */
public class Support extends Thread{

    private Socket SK;// Socket
    public void run(){
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(SK.getInputStream()   ));
            String Recive;

            while(true){
                Recive = buf.readLine();

                if(Recive == null){
                    System.out.print("Nope Reeive Anser");
                    break;
                }else{
                    System.out.println("OtherPlayer : " + Recive);
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

