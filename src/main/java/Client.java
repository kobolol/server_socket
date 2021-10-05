import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("192.168.178.43", 1092);
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        output.writeUTF("IP: " + client.getLocalAddress() + System.getProperty("line.separator") + "Hallo Server");

        DataInputStream input = new DataInputStream(client.getInputStream());
        System.out.println(input.readUTF());
        client.close();
    }
}
