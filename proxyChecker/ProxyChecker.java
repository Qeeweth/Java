import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;


public class ProxyChecker {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C://java/ip.txt");
            FileOutputStream fos = new FileOutputStream("C://java/good_ip.txt");
            int i;
            String proxy = "";
            while ((i = fis.read()) != -1) {
                if (i == 13) continue;
                else if (i == 10) {
                    String ip = proxy.split(":")[0];
                    String port = proxy.split(":")[1];
                    if (checkProxy(ip, port)) {
                        boolean isCheck = checkProxy(ip, port);
                        String text = ip + ":" + port + " - работает!" + "\n";
                        byte[] buf = text.getBytes();
                        fos.write(buf);
                        System.out.println(ip + ":" + port + " - работает!");
                    } else {
                        System.out.println(ip + ":" + port + " - не работает!");
                    }
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


    public static boolean checkProxy(String ip, String port) {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, Integer.parseInt(port)));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
            conn.connect();
            if (conn.getResponseCode() == 200) {
                return true;
            }
        } catch (IOException exception) {
            return false;
        }
        return false;
    }
}










