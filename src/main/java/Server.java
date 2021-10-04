import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {

    private ServerSocket server;

    public Server(int port) throws IOException {
        server = new ServerSocket(port);
        server.setSoTimeout(100000);
    }

    public void server_run() throws IOException {
        while(true){
            System.out.println("Warten auf Client in " + server.getLocalPort());
            Socket client = server.accept();
            DataInputStream input = new DataInputStream(client.getInputStream());
            System.out.println(input.readUTF());
            System.out.println(client.getRemoteSocketAddress());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            output.writeUTF("Heyho Client");
            client.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Server s = new Server(1092);
        s.server_run();
    }
}
