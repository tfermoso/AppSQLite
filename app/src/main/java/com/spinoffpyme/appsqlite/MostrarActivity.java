package com.spinoffpyme.appsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import DBHELPER.Usuario;
import DBHELPER.sqlite;

public class MostrarActivity extends AppCompatActivity {
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    ListView lvUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        lvUsuarios = (ListView) findViewById(R.id.lvUsuarios);
        //Leo los usuarios de la DB
        sqlite db = new sqlite(this, "usuarios", null, 1);
        Cursor c = null;
        if (db != null) {
            SQLiteDatabase data = db.getReadableDatabase();
            c = data.rawQuery("SELECT * FROM usuarios", null);
            if (c.moveToFirst()) {
                do {
                    listaUsuarios.add(new Usuario(c.getInt(c.getColumnIndex("idusuario")), c.getInt(c.getColumnIndex("edad")), c.getString(c.getColumnIndex("nombre")), c.getString(c.getColumnIndex("apellidos"))));
                } while (c.moveToNext());
            }

            //Utilizando simple_list_item_1
            String[] nombres = new String[listaUsuarios.size()];
            for (int i = 0;i<nombres.length;i++){
                nombres[i] = listaUsuarios.get(i).getNombre();
            }
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(MostrarActivity.this,android.R.layout.simple_list_item_1,nombres);
            lvUsuarios.setAdapter(adaptador);



        }

    }
}
