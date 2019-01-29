package beyondtechnology.indicemassa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodrigo on 08/12/2017.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE = "imc";
    private static final int VERSION = 1;

    public DatabaseHandler(Context context){
        super(context,DATABASE,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE HISTORICO(DATATEMPO TEXT,PESO REAL,ALTURA REAL,RESULTADO REAL)";
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addHistorico(String datatempo,double peso,double altura, double resultado){
        SQLiteDatabase dt = this.getWritableDatabase();

        ContentValues ct = new ContentValues();

        ct.put("DATATEMPO", datatempo);
        ct.put("PESO", peso);
        ct.put("ALTURA", altura);
        ct.put("RESULTADO", resultado);

        dt.insert("HISTORICO",null,ct);
        dt.close();
    }

    public List<Historico> getHistoricos(){
        String sql = "SELECT datatempo, peso, altura,resultado FROM HISTORICO ORDER BY DATATEMPO DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        ArrayList<Historico> ret = new ArrayList<Historico>();

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Historico contact = new Historico();
                contact.setDatatempo(cursor.getString(0));
                contact.setPeso(cursor.getDouble(1));
                contact.setResultado(UtilHelper.roundNumber(cursor.getDouble(3)));

                ret.add(contact);
            } while (cursor.moveToNext());
        }

        return ret;
    }
}
