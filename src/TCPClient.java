import java.io.*;
import java.net.*;

    public class TCPClient extends TCPServer {

        public static void main (String[] argv) throws Exception {
            String ModifiedSentence;
            String Sentence;
            BufferedReader inFromUser = new BufferedReader(
                    new InputStreamReader(System.in));
            Socket clientSocket = new Socket("hostname", 6789);
            DataOutputStream OutToServer = new DataOutputStream(
                    clientSocket.getOutputStream());
            BufferedReader inFromServer =
                    new BufferedReader(new InputStreamReader(
                            clientSocket.getInputStream()));
            Sentence = inFromUser.readLine();
            OutToServer.writeBytes(Sentence + '\n');
            ModifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + ModifiedSentence);
            clientSocket.close();
        }
    }

