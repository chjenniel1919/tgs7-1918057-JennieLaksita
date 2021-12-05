package com.example.prak7_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_daftardokter";
    private static final String tb_dokter = "tb_dokter";
    private static final String tb_dokter_id = "id";
    private static final String tb_dokter_id_dokter = "id_dokter";
    private static final String tb_dokter_nama = "nama";
    private static final String tb_dokter_spesialis = "spesialis";
    private static final String CREATE_TABLE_DOKTER = "CREATE TABLE " +
            tb_dokter + "("
            + tb_dokter_id + " INTEGER PRIMARY KEY ,"
            + tb_dokter_id_dokter + " TEXT,"
            + tb_dokter_nama + " TEXT,"
            + tb_dokter_spesialis + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DOKTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateDaftarDokter (Dokter sfNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_dokter_id, sfNotif.get_id());
        values.put(tb_dokter_id_dokter, sfNotif.get_id_dokter());
        values.put(tb_dokter_nama, sfNotif.get_nama());
        values.put(tb_dokter_spesialis, sfNotif.get_spesialis());
        db.insert(tb_dokter, null, values);
        db.close();
    }

    public List<Dokter> ReadDokter() {
        List<Dokter> daftarDokterList = new ArrayList<Dokter>();
        String selectQuery = "SELECT * FROM " + tb_dokter;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Dokter sfKontak = new Dokter();
                sfKontak.set_id(cursor.getString(0));
                sfKontak.set_id_dokter(cursor.getString(1));
                sfKontak.set_nama(cursor.getString(2));
                sfKontak.set_spesialis(cursor.getString(3));
                daftarDokterList.add(sfKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return daftarDokterList;
    }
    public int UpdateDokter (Dokter sfNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_dokter_id_dokter, sfNotif.get_id_dokter());
        values.put(tb_dokter_nama, sfNotif.get_nama());
        values.put(tb_dokter_spesialis, sfNotif.get_spesialis());
        return db.update(tb_dokter, values, tb_dokter_id + " = ?",
                new String[] { String.valueOf(sfNotif.get_id())});
    }

    public void DeleteDokter (Dokter sfNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_dokter, tb_dokter_id+ " = ?",
                new String[]{String.valueOf(sfNotif.get_id())});
        db.close();
    }
}

