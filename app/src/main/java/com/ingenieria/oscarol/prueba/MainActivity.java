package com.ingenieria.oscarol.prueba;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Creamos un socket de servicio cliente
    private Socket client;

    private PrintWriter printWriter;

    //Variables que tomaran el puerto ip y el mensaje
    EditText etPuerto, etip, etmensaje;

    //Boton para enviar mensaje
    Button btnP;

    //Variable para setear el mensaje tipo string
    private String message;

    //Iniciar el puerto en 0
    int port = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaracion de puerto en la vista
        etPuerto = (EditText) findViewById(R.id.etPort);


        //declaracion de ip en la vista
        etip = (EditText) findViewById(R.id.etIp);

        //declaracion de mensaje en la vista
        etmensaje = (EditText) findViewById(R.id.etMensaje);

        //declaracion de boton en la vista
        btnP = (Button) findViewById(R.id.btnPrueba);

        // pasarle el metodo de lectura al boton de conectar
        btnP.setOnClickListener(this);

    }

    /**
     * Metodo general de lectura de click en esta vista
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPrueba:
                // hilo que ejecutara la consulta
                accion();
                break;

        }
    }

    private void accion() {

        message = etmensaje.getText().toString();
        etmensaje.setText("");
        port = Integer.parseInt(etPuerto.getText().toString());


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    client = new Socket(etip.getText().toString(),port);

                    printWriter = new PrintWriter(client.getOutputStream());
                    printWriter.write(message);
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


    }



}