package Game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;



public class TCPClient {
    private ObjectInputStream inObject;
    private ObjectOutputStream outObject;
    private Socket client;
    private int jogada;
    private int jogadaServidor;

    public TCPClient() {
        this.jogada = -1;
        this.jogadaServidor = -1;
    }

    public void conectarServidor() {
        new Thread() {

            @Override
            public void run() {
                int i = 0;
                boolean checkConexao;

                while (true) {
                    //System.out.println(i);
                    try {
                        if(i == 0){
                            InetAddress server = InetAddress.getLocalHost();
                            client = new Socket(server, 16868);
                            outObject = new ObjectOutputStream(client.getOutputStream());
                            inObject = new ObjectInputStream(client.getInputStream());
                            Main.setStatus(Status.GAME);
                            i++;
                        }/* else if(i == 1){

                               // Main.setStatus(Status.GAME);
                                i++;
                        }*/
                        jogadaServidor = inObject.read();   // ele le algo diferente de -1
                        if(jogadaServidor != -1 && jogada != -1){
                            Main.setStatus(Status.ROUNDRESULT);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }


    public ObjectInputStream getInObject() {
        return inObject;
    }

    public void setInObject(ObjectInputStream inObject) {
        this.inObject = inObject;
    }

    public ObjectOutputStream getOutObject() {
        return outObject;
    }

    public void setOutObject(ObjectOutputStream outObject) {
        this.outObject = outObject;
    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public int getJogada() {
        return jogada;
    }

    public void setJogada(int jogada) {
        this.jogada = jogada;
    }

    public int getJogadaServidor() {
        return jogadaServidor;
    }

    public void setJogadaServidor(int jogadaServidor) {
        this.jogadaServidor = jogadaServidor;
    }
}
