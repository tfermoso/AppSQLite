package com.spinoffpyme.appsqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import DBHELPER.sqlite;

public class CrearActivity extends AppCompatActivity {
    private EditText nombre,apellidos,edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        nombre=(EditText) findViewById(R.id.txtNombre);
        apellidos=(EditText) findViewById(R.id.txtApellidos);
        edad=(EditText) findViewById(R.id.txtEdad);

    }

    public void guardarUsuario(View view) {

        if(comprobarCampos()){
            String nom,ape;
            int ed;
            nom=nombre.getText().toString();
            ape=apellidos.getText().toString();
            ed=Integer.parseInt(edad.getText().toString());

            sqlite db=new sqlite(this,"usuarios",null,1);
            if(db!=null){
                SQLiteDatabase data=db.getWritableDatabase();
                ContentValues con=new ContentValues();
                con.put("nombre",nom);
                con.put("apellidos",ape);
                con.put("edad",ed);
                long resultado=data.insert("usuarios",null,con);
                if(resultado>0){
                    Toast.makeText(this,"Usuario guardado",Toast.LENGTH_LONG).show();
                    nombre.setText("");
                    apellidos.setText("");
                    edad.setText("");
                }else {

                    Toast.makeText(this,"No se ha podido guardar el usuario",Toast.LENGTH_LONG).show();
                }
            }

        }else{
            Toast.makeText(this,"Hay Campos vacios",Toast.LENGTH_LONG).show();
        }


    }

    private boolean comprobarCampos() {
        if(nombre.getText().toString().isEmpty()||apellidos.getText().toString().isEmpty()||edad.getText().toString().isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
