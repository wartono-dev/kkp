package com.wartono.my.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.wartono.my.API.APIClient;
import com.wartono.my.API.APIInterface;
import com.wartono.my.Adapter.adapter_data;
import com.wartono.my.LoginActivity;
import com.wartono.my.Model.Data.ModelData;
import com.wartono.my.Model.Data.ResponseData;
import com.wartono.my.R;
import com.wartono.my.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainAdmin extends AppCompatActivity {
    SessionManager session;
    private RecyclerView revData;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lmData;
    ProgressBar loading;
    private List<ModelData> list = new ArrayList<>();
    String id_pesan = "id_pesan", nama_pemesan = "nama_pemesan", alamat_pemesan = "alamat_pemesan", koda_administrasi = "kota_administras",
            status_pesanan = "status_pesanan", tanggal_pesanan = "tanggal_pesanan", jenis_pesanan = "jenis_pesanan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        session = new SessionManager(getApplicationContext());
        session.checkLogin();
        revData = findViewById(R.id.rv_data);
        loading = new ProgressBar(MainAdmin.this);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        revData.setLayoutManager(lmData);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ambil_data();
    }

    public void ambil_data () {
        APIInterface AI_Data = APIClient.getClient().create(APIInterface.class);
        Call<ResponseData>
                tampil_data = AI_Data.Read_data(id_pesan, nama_pemesan, alamat_pemesan,koda_administrasi,status_pesanan,tanggal_pesanan,jenis_pesanan);
        tampil_data.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                assert response.body() != null;
                list = response.body().getData();
                adapter = new adapter_data(MainAdmin.this, list);
                revData.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.d("SERVER_PESAN","Gagal Menghubungi Server");
            }
        });
    }

    @Override
    public void onBackPressed() {
        androidx.appcompat.app.AlertDialog dialog = new androidx.appcompat.app.AlertDialog.Builder(MainAdmin.this)
                .setTitle("Anda Yakin Ingin Logout ?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        session.logoutSession();
                        session.destroyCurrentUser(); // ini buat clear user yg lg login
                        Intent i = new Intent(MainAdmin.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .setNegativeButton("Tidak", null)
                .create();
        dialog.show();
    }
}