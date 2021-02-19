package com.wartono.my.Activity.Konsumen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wartono.my.AlertDialogManager;
import com.wartono.my.ListHarga;
import com.wartono.my.Profil;
import com.wartono.my.R;
import com.wartono.my.SessionManager;

public class MainActivity extends AppCompatActivity {


    AlertDialogManager alert = new AlertDialogManager();
    SessionManager session;
    Button btnPesanSekarang, btnProfil, btnListHarga, btnHistoriPesanan, btnLogout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());
        session.checkLogin();

        btnProfil = findViewById(R.id.btnProfil);
        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Profil = new Intent(MainActivity.this, Profil.class);
                startActivity(Profil);

            }
        });

        btnListHarga = findViewById(R.id.btnListHarga);
        btnListHarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ListHarga = new Intent(MainActivity.this,ListHarga.class);
                startActivity(ListHarga);

            }
        });

        btnPesanSekarang = findViewById(R.id.btnPesanSekarang);
        btnPesanSekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PesanSekarang = new Intent(MainActivity.this,FormActivity.class);
                startActivity(PesanSekarang);

            }
        });

        btnHistoriPesanan = findViewById(R.id.btnHistoriPesanan);
        btnHistoriPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent HistoriPesanan = new Intent(MainActivity.this, DetilActivity.class);
                startActivity(HistoriPesanan);

            }
        });

        btnLogout = findViewById(R.id.out);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Anda yakin ingin keluar ?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                session.logoutUser();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .create();
                dialog.show();
            }
        });
    }
}