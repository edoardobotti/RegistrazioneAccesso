/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java 
to edit this template
 */
package server;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 *
 * @author edoar
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Scanner tastiera = new Scanner (System.in);
            String scelta;
            boolean continuaUno = true;
            boolean utenteInserito = true;
            boolean continuaDue = true;
            boolean passwordInsert = true;
            String user = null;
            String password = null;
            String nu = null;
            String pu = null;
            char [] utenteVero = new char[50];
            char [] passwordVera = new char[50];
            char [] utenteIn = new char [50];
            char [] passwordIn = new char [50];
            out.println("inserire cosa si desidera fare");
            scelta = tastiera.next();
            if(scelta.equals("reg")){
                //registrazione
                try{
                    out.println("inserire il nome utente");
                    user=tastiera.next();
                    File nomeUtente = new File(user);
                    nomeUtente.createNewFile();
                    FileWriter fw = new FileWriter(nomeUtente);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(user);
                    bw.flush();
                    bw.close();
                    out.println("inseire la password");
                    password = tastiera.next();
                    File passwordUtente = new File(password);
                    passwordUtente.createNewFile();
                    FileWriter fp = new FileWriter(passwordUtente);
                    BufferedWriter bp = new BufferedWriter (fp);
                    bp.write(password);
                    bp.flush();
                    bp.close();
                    FileReader luv = new FileReader(nomeUtente);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }else{
                //accesso
                try{
                    out.println("inserie il proprio nome utente");
                    nu = tastiera.next();
                    File userInserito = new File(nu);
                    userInserito.createNewFile();
                    FileWriter fz = new FileWriter(nu);
                    BufferedWriter bz = new BufferedWriter(fz);
                    bz.write(nu);
                    bz.flush();
                    bz.close();
                    out.println("inserie la propria password");
                    pu = tastiera.next();
                    File passwordInserita = new File(pu);
                    passwordInserita.createNewFile();
                    FileWriter kz = new FileWriter(passwordInserita);
                    BufferedWriter pz = new BufferedWriter (kz);
                    pz.write(pu);
                    pz.flush();
                    pz.close();
                    FileReader lui = new FileReader(userInserito);
                    BufferedReader  luip = new BufferedReader (lui);
                    luip.read(utenteIn);
                    luip.close();
                    FileReader lpu = new FileReader(passwordInserita);
                    BufferedReader lpup = new BufferedReader (lpu);
                    lpup.read(passwordIn);
                    luip.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
                //comparazione
                //https://www.html.it/articoli/creazione-eliminazione-lettura-e-scrittura-di-file-di-testo/
                while (continuaUno=true){
                    for(int i = 0; i<50; i++){
                        if (utenteIn[i]==utenteVero[i]){
                            utenteInserito = true;
                            continuaUno = true;
                        }else{
                            utenteInserito = false;
                            continuaUno = false;
                        }
                    }
                }
                while (continuaDue = true){
                    for (int i = 0; i<50; i++){
                        if (passwordIn[i]==passwordVera[i]){
                            passwordInsert = true;
                            continuaDue = true;
                        }else{
                            passwordInsert = false;
                            continuaDue = false;
                        }
                    }
                }
                if (utenteInserito = true){
                    if (passwordInsert = true){
                        out.println("accesso riuscito con successo");
                    }
                }
                if (utenteInserito = false){
                    if (passwordInsert = false){
                        out.println("accesso negato");
                    }
                }
            }
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
