import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localHost", 6500);

            InputStream in = s.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(in);
            final String message = (String) ois.readObject();
            System.out.println("Nom du client = " + message);

            s.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        


    }
}
