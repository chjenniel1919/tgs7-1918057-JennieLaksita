package com.example.prak7_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Siddokter, Snama, Sspesialis;
    private EditText Eiddokter, Enama, Espesialis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Siddokter = i.getStringExtra("Iiddokter");
        Snama = i.getStringExtra("Inama");
        Sspesialis = i.getStringExtra("Ispesialis");
        Eiddokter = (EditText) findViewById(R.id.updel_id_dokter);
        Enama = (EditText) findViewById(R.id.updel_nama);
        Espesialis = (EditText) findViewById(R.id.updel_spesialis);
        Eiddokter.setText(Siddokter);
        Enama.setText(Snama);
        Espesialis.setText(Sspesialis);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Siddokter = String.valueOf(Eiddokter.getText());
                Snama = String.valueOf(Enama.getText());
                Sspesialis = String.valueOf(Espesialis.getText());
                if (Siddokter.equals("")){
                    Eiddokter.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi ID",
                            Toast.LENGTH_SHORT).show();
                } else if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sspesialis.equals("")){
                    Espesialis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Spesialis",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateDokter(new Dokter(Sid, Siddokter, Snama, Sspesialis));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteDokter(new Dokter(Sid, Siddokter, Snama, Sspesialis));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

