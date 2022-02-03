import java.io.*;
import java.net.*;

public class fileserver {
    public static void main(String[] args) throws IOException {
        int port = 9999;

        try {
            ServerSocket s = new ServerSocket(port);
            while(true){
                Socket client = s.accept();
    

                InputStream in = client.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(in);
                String chemin = (String) ois.readObject();
                String fileName = "./filetransfert\\"+chemin;
                
                System.out.println("fileName = "+fileName);

                FileInputStream file  = new FileInputStream(fileName);
                byte[] b = new byte[1000];
                file.read(b);
                OutputStream os = client.getOutputStream();
                os.write(b);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
