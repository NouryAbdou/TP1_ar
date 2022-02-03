import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;

public class server {
    
    public static void main(String[] args) {
        int port = 6500;
        //int backlog = 3;
        try {
            ServerSocket s = new ServerSocket(port);
            while(true){
                Socket client = s.accept();
                String clientName = client.getInetAddress().getHostName();

                String message = new String(clientName);

                OutputStream out = client.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(out);

                oos.writeObject(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
