package com.wartono.my.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import com.wartono.my.API.APIClient;
import com.wartono.my.API.APIInterface;
import com.wartono.my.LoginActivity;
import com.wartono.my.Model.Data.ResponseData;
import com.wartono.my.R;
import com.wartono.my.RegisterActivity;

public class FormActivity extends AppCompatActivity  {

    private EditText etnama_pemesan, etalamat_pemesan, etkota_administrasi, etstatus_pesanan, ettanggal_pesanan, etjenis_pesanan;
    private Button btnPesanan;
    private String nama_pemesan, alamat_pemesan, kota_administrasi, status_pesanan, tanggal_pesanan, jenis_pesanan;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        progressDialog = new ProgressDialog(FormActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Tunggu konfirmasi  ...");

        etnama_pemesan = findViewById(R.id.etnama_pemesan);
        etalamat_pemesan = findViewById(R.id.etalamat_pemesan);
        etkota_administrasi = findViewById(R.id.etkota_administrasi);
        ettanggal_pesanan = findViewById(R.id.ettanggal_pesanan);
        etjenis_pesanan = findViewById(R.id.etjenis_pesanan);

        btnPesanan =findViewById(R.id.btnPesan);
        btnPesanan.setOnClickListener(v -> {
            nama_pemesan = etnama_pemesan.getText().toString();
            alamat_pemesan = etalamat_pemesan.getText().toString();
            kota_administrasi = etkota_administrasi.getText().toString();
            tanggal_pesanan = ettanggal_pesanan.getText().toString();
            jenis_pesanan = etjenis_pesanan.getText().toString();

            if(nama_pemesan.trim().equals("")){
                etnama_pemesan.setError("Nama harus diisi");
            }
            else if(alamat_pemesan.trim().equals("")){
                etalamat_pemesan.setError("Alamat alamat harus diisi");
            }
            else if(kota_administrasi.trim().equals("")){
                etkota_administrasi.setError("kota harus diisi");
            }
            else if(tanggal_pesanan.trim().equals("")){
                ettanggal_pesanan.setError("tanggal harus diisi");
            }
            else if(jenis_pesanan.trim().equals("")){
                etjenis_pesanan.setError("jenis harus diisi");
            }
            else{
                Read_data();
            }

        });
    }

    private void Read_data() {
        APIInterface ardData = APIClient.getClient().create(APIInterface.class);
        Call<ResponseData> SimpanData = ardData.Insert_data(nama_pemesan, alamat_pemesan, kota_administrasi, status_pesanan, tanggal_pesanan, jenis_pesanan);
        Intent Intent = new Intent (FormActivity.this,MainActivity.class);
        startActivity(Intent);

        SimpanData.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getMessage();

                Log.d("SERVER_KODE", String.valueOf(kode));
                Log.d("SERVER_PESAN", String.valueOf(pesan));

                Toast.makeText(FormActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                finish();

            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.d("SERVER_PESAN","Gagal Menghubungi Server");

            }
        });


    }}