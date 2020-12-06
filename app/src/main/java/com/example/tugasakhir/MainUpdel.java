package com.example.tugasakhir;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugasakhir.Anime;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sjudul, Sdurasi, Srating, Srated;
    private EditText Ejudul, Edurasi, Erating, Erated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjudul = i.getStringExtra("Ijudul");
        Sdurasi = i.getStringExtra("Idurasi");
        Srating = i.getStringExtra("Irating");
        Srated = i.getStringExtra("Irated");
        Ejudul = (EditText) findViewById(R.id.updel_judul);
        Edurasi = (EditText) findViewById(R.id.updel_durasi);
        Erating = (EditText) findViewById(R.id.updel_rating);
        Erated = (EditText) findViewById(R.id.updel_rated);
        Ejudul.setText(Sjudul);
        Edurasi.setText(Sdurasi);
        Erating.setText(Srating);
        Erated.setText(Srated);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Sdurasi = String.valueOf(Edurasi.getText());
                Srating = String.valueOf(Erating.getText());
                Srated = String.valueOf(Erated.getText());
                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi judul",
                            Toast.LENGTH_SHORT).show();
                } else if (Sdurasi.equals("")){
                    Edurasi.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi durasi",
                            Toast.LENGTH_SHORT).show();
                } else if (Srating.equals("")){
                    Erating.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi rating",
                            Toast.LENGTH_SHORT).show();
                } else if (Srated.equals("")) {
                    Erated.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi rated",
                            Toast.LENGTH_SHORT).show();
                }else {
                        db.UpdateAnime(new Anime(Sid, Sjudul, Sdurasi, Srating, Srated));
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
                    db.DeleteAnime(new Anime(Sid, Sjudul, Sdurasi, Srating, Srated));
                    Toast.makeText(MainUpdel.this, "Data telah dihapus",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    }