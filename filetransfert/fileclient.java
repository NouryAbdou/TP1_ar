import java.io.IOException;
import java.io.*;
import java.net.*;

public class fileclient {
    public static void main(String[] args) throws IOException {
        int port=9999;

        try {
            Socket s = new Socket("localHost", port);
            OutputStream out = s.getOutputStream();

            String fileName = "readme.txt";

            ObjectOutputStream os = new ObjectOutputStream (out);
            os.writeObject(fileName);

            byte [] b = new byte [100];
            InputStream in = s.getInputStream();
            FileOutputStream fo = new FileOutputStream("fork.txt");
            in.read(b);
            fo.write(b);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
