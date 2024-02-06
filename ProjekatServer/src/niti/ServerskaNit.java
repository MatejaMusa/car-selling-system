package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerskaNit extends Thread{
        private ServerSocket serverSocket;
        List<ObradaKlijentskihZahteva> korisnici;

    public ServerskaNit() throws IOException {
        serverSocket=new ServerSocket(9000);
        korisnici=new ArrayList<>();
    }
    
    
    
    @Override
    public void run() {
        while(!serverSocket.isClosed()){
            System.out.println("waiting...");
            try {
                Socket socket=serverSocket.accept();
                ObradaKlijentskihZahteva korisnik=new ObradaKlijentskihZahteva(socket);
                korisnik.start();
                korisnici.add(korisnik);
                System.out.println("Korisnik konektovan!");
            } catch (IOException ex) {
                System.out.println("Server je zatvoren!");
            }
            
        }
        zaustaviObradu();
        
    }
    
    public  void zaustaviServerskuNit() throws IOException{
        serverSocket.close();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
    private void zaustaviObradu(){
        for (ObradaKlijentskihZahteva korisnik : korisnici) {
            try {
                korisnik.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
