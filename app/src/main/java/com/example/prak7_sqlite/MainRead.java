package com.example.prak7_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Dokter> ListDaftarDokter = new ArrayList<Dokter>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListDaftarDokter );
        mListView = (ListView) findViewById(R.id.list_dokter);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListDaftarDokter.clear();
        List<Dokter> contacts = db.ReadDokter();
        for (Dokter cn : contacts) {
            Dokter daftarDokter = new Dokter();
            daftarDokter.set_id(cn.get_id());
            daftarDokter.set_id_dokter(cn.get_id_dokter());
            daftarDokter.set_nama(cn.get_nama());
            daftarDokter.set_spesialis(cn.get_spesialis());
            ListDaftarDokter.add(daftarDokter);
            if ((ListDaftarDokter.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Dokter obj_itemDetails = (Dokter) o;
        String Sid = obj_itemDetails.get_id();
        String Siddokter = obj_itemDetails.get_id_dokter();
        String Snama = obj_itemDetails.get_nama();
        String Sspesialis = obj_itemDetails.get_spesialis();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Iiddokter", Siddokter);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ispesialis", Sspesialis);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListDaftarDokter.clear();
        mListView.setAdapter(adapter_off);
        List<Dokter> contacts = db.ReadDokter();
        for (Dokter cn : contacts) {
            Dokter daftarDokter = new Dokter();
            daftarDokter.set_id(cn.get_id());
            daftarDokter.set_id_dokter(cn.get_id_dokter());
            daftarDokter.set_nama(cn.get_nama());
            daftarDokter.set_spesialis(cn.get_spesialis());
            ListDaftarDokter.add(daftarDokter);
            if ((ListDaftarDokter.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
