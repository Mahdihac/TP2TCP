package server;

import server.Traitement;
import model.Compte;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Compte> comptes;





    public static void main(String[] args) {
        try{
            comptes=new ArrayList<Compte>();
            ServerSocket sc= new ServerSocket(4000);
            while (true){
                Socket s=sc.accept();
                Traitement t=new Traitement(s);
                t.start();
            }
        }catch (Exception e){}


    }

}
