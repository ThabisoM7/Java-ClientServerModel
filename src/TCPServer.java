import java.io.*;
import java.net.*;
public class TCPServer
{
    public static void main(String[] argv) throws Exception{
        String ClientSentence;
        String CapitalizedSentence;
        ServerSocket welcomeSocket = new Socket(6789);

        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(
                    connectionSocket.getInputStream()));
            DataOutputStream OutToClient =
                    new DataOutputStream(
                            connectionSocket.getOutputStream());
            ClientSentence = inFromClient.readLine();
            CapitalizedSentence = ClientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(CapitalizedSentence);
        }
    }
}