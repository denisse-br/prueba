package com.ingenieria.oscarol.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    EditText dpi, nombre,mail,pass,fecha,dept,user;
    Switch estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iniciarVar();



    }
    String userDef="";
    String[] userTemp;
    private void iniciarVar() {
        dpi= (EditText)findViewById(R.id.dpi);
        nombre=(EditText)findViewById(R.id.nombre);
        mail=(EditText)findViewById(R.id.correo);
        pass=(EditText)findViewById(R.id.pass);
        fecha=(EditText)findViewById(R.id.date);
        user=(EditText)findViewById(R.id.user);
        dept=(EditText)findViewById(R.id.dept);
        estado=(Switch) findViewById(R.id.switch1);
        SimpleDateFormat ss = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String currentdate= ss.format(date);
        fecha.setText(currentdate);
        nombre.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                if(nombre.getText().toString().isEmpty()){
                    return  false;
                }else{
                    userTemp=nombre.getText().toString().split(" ");
                    userDef=userTemp[0];
                    user.setText(userDef);

                    return true;
                }
            }
        });

        //



    }


    public void registrar(View view) {


        if(dpi.getText().length()==0||nombre.getText().length()==0||mail.getText().length()==0||pass.getText().length()==0||fecha.getText().length()==0||user.getText().length()==0||dept.getText().length()==0){
            Toast.makeText(getApplicationContext(),"Ningun campo puede quedar vacio",Toast.LENGTH_LONG).show();
        }else{

            ObtenerDatos od = new ObtenerDatos();
            od.obtenerDatosRegistro( Long.parseLong(dpi.getText().toString()),nombre.getText().toString(),
                    mail.getText().toString(),dept.getText().toString(),
                    pass.getText().toString(),fecha.getText().toString(),user.getText().toString(),estado.isChecked());
            boolean si = estado.isChecked();
            Log.i("info",""+si);

        }





    }
}
