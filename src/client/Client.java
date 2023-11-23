package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main (String[] args){
        try{
            Socket socket=new Socket("127.0.0.1",4000);
            BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out =new PrintWriter(socket.getOutputStream() , true);
            BufferedReader in_cl=new BufferedReader(new InputStreamReader( System.in ) );
            while(true) {
                String msg = in_cl.readLine();
                out.println(msg);
                String msg2 = in.readLine();
                System.out.println(msg2);
            }
        }catch (Exception e){}
    }




}
