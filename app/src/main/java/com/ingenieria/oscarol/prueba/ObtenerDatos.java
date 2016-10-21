package com.ingenieria.oscarol.prueba;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Denissebr on 20/10/2016.
 */
public class ObtenerDatos {

    public void obtenerDatosRegistro(long dpi, String nombre, String mail, String dept, String pass, String fecha, String user, boolean estado ){
        JSONObject jsonRegistrar =  new JSONObject();
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

        Log.i("JSON",":"+jsonRegistrar);
    }
}
