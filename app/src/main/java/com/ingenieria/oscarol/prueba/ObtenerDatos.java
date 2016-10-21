package com.ingenieria.oscarol.prueba;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Denissebr on 20/10/2016.
 */
public class ObtenerDatos {
    private Socket client;
    public void obtenerDatosRegistro(long dpi, String nombre, String mail, String dept, String pass, String fecha, String user, boolean estado ){
        final JSONObject jsonRegistrar =  new JSONObject();
        try {
            jsonRegistrar.put("dpi",dpi);
            jsonRegistrar.put("nombre",nombre);
            jsonRegistrar.put("e-mail",mail);
            jsonRegistrar.put("departamento",dept);
            jsonRegistrar.put("Password",pass);
            jsonRegistrar.put("fecha",fecha);
            jsonRegistrar.put("usuario",user);
            if(estado==true){
                jsonRegistrar.put("Estado","Online");
            }else{
                jsonRegistrar.put("Estado","Offline");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    client = new Socket("192.168.1.2",2222);

                    PrintWriter printWriter = new PrintWriter(client.getOutputStream());
                    printWriter.write("{Registro:[{"+String.valueOf(jsonRegistrar)+"}]}");
                    printWriter.flush();
                    printWriter.close();
                    client.close();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();






        //Log.i("JSON",":"+jsonRegistrar);
    }
}
