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


    // [Inicia conexao com servidor]
    public void conectarServidor() {

        new  Thread() {

            @Override
            public void run() {
                int i = 0;

                while (true) {
                    try {
                        if(i == 0){
                            InetAddress server = InetAddress.getByName("0.0.0.0");  // [Aqui deve ficar o ip do computador que sera o servidor]
                            client = new Socket(server, 16868);
                            outObject = new ObjectOutputStream(client.getOutputStream());
                            inObject = new ObjectInputStream(client.getInputStream());
                            i++;
                        }
                        System.out.println("lendo servidor...");
                        jogadaServidor = inObject.read();

                        // [Receber 5 significa servidor desligado]
                        if(jogadaServidor == 5){

                            // [Encerra conexao]
                            client.close();
                            // [Thread interrompida]
                            this.interrupt();
                            // [Exibe tela de GameOver apos receber 5 do server]
                            Main.setStatus(Status.GAMEOVER);
                            break;
                        } else {
                            System.out.println("jogada servidor: " + jogadaServidor);

                            // [Tela de jogo eh desenhada apos receber jogada do servidor != 5]
                            Main.setStatus(Status.GAME);
                            if (jogadaServidor > 0 && jogada > 0) {
                                Main.setStatus(Status.ROUNDRESULT);
                                // [Reinicia a jogada]
                                setJogada(0);
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    // [Getters e setters]
    public ObjectOutputStream getOutObject() {
        return outObject;
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
}
