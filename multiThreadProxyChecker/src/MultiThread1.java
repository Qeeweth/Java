import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class MultiThread1 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C://java/ip.txt");
            int i;
            String proxy = "";
            while ((i = fis.read()) != -1) {
                if (i == 13) continue;
                else if (i == 10) {
                    String ip = proxy.split(":")[0];
                    String port = proxy.split(":")[1];
                    InetSocketAddress ism = new InetSocketAddress(ip, Integer.parseInt(port));
                    Thread thread1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Proxy proxy = new Proxy(Proxy.Type.HTTP, ism);
                                URL url = new URL("https://vozhzhaev.ru/test.php");
                                URLConnection urlConnection = url.openConnection(proxy);
                                InputStream is = urlConnection.getInputStream();
                                InputStreamReader reader = new InputStreamReader(is);
                                int i;
                                StringBuilder result = new StringBuilder();
                                while ((i = reader.read()) != -1) {
                                    StringBuilder append = result.append((char) i);
                                }
                                System.out.println(result);
                                FileOutputStream fos = new FileOutputStream("C://java/good_ip.txt", true);
                                fos.write(result.toString().getBytes());
                                byte[] colon = {58};
                                fos.write(colon);
                                fos.write(port.getBytes());
                                byte[] nextLine = {13, 10};
                                fos.write(nextLine);
                            } catch (IOException exception) {
                                System.out.println(ip + " - не работает!");
                            }
                        }
                    });
                    thread1.start();
                    proxy = "";
                } else if (i != 9) {
                    proxy += (char) i;
                } else {
                    proxy += ":";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

