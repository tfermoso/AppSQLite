package DBHELPER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;

import java.util.List;

/**
 * Created by Tomás on 20/10/2017.
 */

public class sqlite extends SQLiteOpenHelper {
    public String usuarios = "CREATE TABLE usuarios(idusuario INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,apellidos TEXT," +
            "edad INTEGER)";

    public sqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(usuarios);
        List<Pair<String,String>> bds=db.getAttachedDbs();
        System.out.printf(bds.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
