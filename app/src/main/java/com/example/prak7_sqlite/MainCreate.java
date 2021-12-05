package com.example.prak7_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Eiddokter, Enama, Espesialis;
    private String Siddokter, Snama, Sspesialis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Eiddokter = (EditText) findViewById(R.id.create_id_dokter);
        Enama = (EditText) findViewById(R.id.create_nama);
        Espesialis = (EditText) findViewById(R.id.create_spesialis);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Siddokter = String.valueOf(Eiddokter.getText());
                Snama = String.valueOf(Enama.getText());
                Sspesialis = String.valueOf(Espesialis.getText());
                if (Siddokter.equals("")){
                    Eiddokter.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi ID",
                            Toast.LENGTH_SHORT).show();
                } else if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sspesialis.equals("")){
                    Espesialis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Spesialis",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Eiddokter.setText("");
                    Enama.setText("");
                    Espesialis.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateDaftarDokter(new Dokter(null, Siddokter, Snama, Sspesialis));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

