package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";

    private static ServerController svr = null;

    private ServerController() {}

    public static ServerController shared() {
        if (svr == null)
        svr = new ServerController();

    return svr;
}

    public String getUrl(String url) throws IOException {
        URL obj = new URL(rootURL +"/"+ url);
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
    
    
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            }
            in .close();
            return response.toString();
        } 
        return "";
    }

    public String postUrl(String url, String payload) throws IOException {
        URL obj = new URL(rootURL +"/"+ url);
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Content-Type", "application/json");

        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(payload.getBytes());
        os.flush();
        os.close();

        int responseCode = postConnection.getResponseCode();
    
        if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            return response.toString();
        }
        return "";
    }
    public String putUrl(String url, String payload) throws IOException {
        URL obj = new URL(rootURL +"/"+ url);
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("PUT");
        postConnection.setRequestProperty("Content-Type", "application/json");

        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(payload.getBytes());
        os.flush();
        os.close();

        int responseCode = postConnection.getResponseCode();
    
        if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            return response.toString();
        }
        return "";
    }


}

// ServerController.shared.doGet()