package mx.itesm.actividad21ca;

import android.os.Message;
import android.os.Handler;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Request extends Thread{
    private String url;
    private Handler handler;

    public Request(String url, Handler handler){
        this.url = url;
        this.handler = handler;
    }
    public void run(){
        try{
            URL address = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) address.openConnection();

            int code = connection.getResponseCode();

            if(code == HttpURLConnection.HTTP_OK){
                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                StringBuilder builder = new StringBuilder();
                String currentLine;

                while((currentLine = br.readLine()) != null){
                    builder.append(currentLine);
                }
                String result = builder.toString();
                Log.wtf("Request", result);

                Message msg = new Message();
                msg.obj = result; //problemas a veces con abstractción

                handler.sendMessage(msg); //checar el import que sea os

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
