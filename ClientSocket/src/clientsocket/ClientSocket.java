/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientsocket;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edoar
 */
public class ClientSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try{
            Socket clientSocket = new Socket("127.0.1", 5000);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Scanner tastiera = new Scanner(System.in); 
            String scelta = null;
            String user = null;
            String nu = null;
            String pu = null;
            String a = "accesso riuscito con successo";
            String r = null;
            String password = null;
            scelta = in.readLine();
            if(scelta.equals("reg")){
                out.println("nome utente inserito");
                user = in.readLine();
                out.println("password inserita");
                password = in.readLine();
            }else{
                //accesso
                out.println("nome utente inserito");
                nu = in.readLine();
                out.println("password inserita");
                pu = in.readLine();
                out.println("verifica delle credenziali");
                r = in.readLine();
                if (r.equals(a)){
                    out.println("accesso riuscito");
                }else{
                    out.println("ritentare l'accesso");
                }
            }
            in.close();
            out.close();
            clientSocket.close();
        }catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
