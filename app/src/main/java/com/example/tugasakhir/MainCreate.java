package com.example.tugasakhir;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugasakhir.Anime;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Ejudul, Edurasi, Erating, Erated;
    private String Sjudul, Sdurasi, Srating, Srated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ejudul = (EditText) findViewById(R.id.create_judul);
        Edurasi = (EditText) findViewById(R.id.create_durasi);
        Erating = (EditText) findViewById(R.id.create_rating);
        Erated = (EditText) findViewById(R.id.create_rated);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Sdurasi = String.valueOf(Edurasi.getText());
                Srating = String.valueOf(Erating.getText());
                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi judul",
                            Toast.LENGTH_SHORT).show();
                } else if (Sdurasi.equals("")){
                    Edurasi.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi durasi",
                            Toast.LENGTH_SHORT).show();
                } else if (Srating.equals("")){
                    Erating.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi rating",
                            Toast.LENGTH_SHORT).show();
                }else if (Srated.equals("")) {
                    Erated.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi rated",
                            Toast.LENGTH_SHORT).show();
                }else{
                        Ejudul.setText("");
                        Edurasi.setText("");
                        Erating.setText("");
                        Erated.setText("");
                        Toast.makeText(MainCreate.this, "Data telah ditambah",
                                Toast.LENGTH_SHORT).show();
                        db.CreateAnime(new Anime(null, Sjudul, Sdurasi, Srating, Srated));
                        Intent a = new Intent(MainCreate.this, MainActivity.class);
                        startActivity(a);
                    }
                }
            });
        }
    }