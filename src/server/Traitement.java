package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import model.Compte;

public class Traitement  extends Thread{
    Socket socket;

    public Traitement(Socket s) {
        this.socket=s;
    }
    public void run() {
        try {
            BufferedReader bf= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter  print= new PrintWriter(socket.getOutputStream(),true);
            while(true) {
                boolean x = false;
                String msg=bf.readLine();
                Compte cp=null;
                if(msg.startsWith("CREATION")) {
                    String nom=msg.split(" ")[1];
                    for(Compte c:Server.comptes) {
                        if(msg.equals(c.getNomCl())) {
                            x=true;
                            cp=c;
                            String error="Compte existe deja !";
                            print.println(error);
                            break;
                        }
                    }
                    if(!x) {
                        cp=new Compte(0,nom);
                        Server.comptes.add(cp);
                        String error="Compte créé avec Succes !";
                        print.println(error);
                    }
                    while(true) {
                        String m=bf.readLine();
                        if(m.startsWith("CREDIT")) {
                            float solde=Float.parseFloat(m.split(" ")[1]);
                            cp.setSolde(cp.getSolde()+solde);
                            String error="Compte Credité avec succés !";
                            print.println(error);
                        }else if(m.startsWith("DEBIT")) {
                            float solde=Float.parseFloat(m.split(" ")[1]);
                            if(cp.getSolde()>=solde) {
                                cp.setSolde(cp.getSolde()-solde);
                                String error="Compte débité avec succés !";
                                print.println(error);
                            }else {
                                String error="Solde insuffisant !";
                                print.println(error);
                            }
                        }else if(m.startsWith("SOLDE")) {
                            String error="Solde = "+ cp.getSolde() +" DT";
                            print.println(error);
                        }
                    }
                }else {
                    String error="Le compte n'existe pas !";
                    print.println(error);
                }

            }
        } catch (Exception e) {}
    }
}