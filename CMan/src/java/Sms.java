    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.OutputStream;
    import java.net.HttpURLConnection;
    import java.net.URL;
    import org.apache.commons.codec.binary.Base64;
    public class Sms {
        
        public void send(String phoneNumber){
            try {
                //String phoneNumber = "+919656734609";
                String appKey = "1301486f-3ac0-492b-9cdb-11255d1af822";
                String appSecret = "X0Esu8d8wUKlt8RCiopd6w==";
                String message = "Your order has been delivered! \nPlease log on to www.abc.com for more details!";
                URL url = new URL("https://messagingapi.sinch.com/v1/sms/" + phoneNumber);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                String userCredentials = "application\\" + appKey + ":" + appSecret;
                byte[] encoded = Base64.encodeBase64(userCredentials.getBytes());
                String basicAuth = "Basic " + new String(encoded);
                connection.setRequestProperty("Authorization", basicAuth);
                String postData = "{\"Message\":\"" + message + "\"}";
                OutputStream os = connection.getOutputStream();
                os.write(postData.getBytes());
                StringBuilder response = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ( (line = br.readLine()) != null)
                    response.append(line);
                br.close();
                os.close();
                System.out.println(response.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void main(String[] args) {
            Sms s = new Sms();
            //s.send();
        }
    }