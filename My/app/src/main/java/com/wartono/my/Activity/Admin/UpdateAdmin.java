package com.wartono.my.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wartono.my.API.APIClient;
import com.wartono.my.API.APIInterface;
import com.wartono.my.Activity.Konsumen.MainActivity;
import com.wartono.my.Model.Data.ModelData;
import com.wartono.my.Model.Data.ResponseData;
import com.wartono.my.R;
import com.wartono.my.SessionManager;

import java.util.List;

import static com.wartono.my.Activity.Teknisi.UpdateTeknisi.DATA_DETAIL;
import static com.wartono.my.R.id.id_pesan;
import static com.wartono.my.R.id.jenis_pesanan;

public class UpdateAdmin extends AppCompatActivity {

    SessionManager session;
    private RecyclerView revData;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lmData;
    private List<ModelData> detail;
    private Parcelable ModelData;
    private ModelData modelData;
    ProgressBar loading;

    String vid_pesan , vnama_pemesan , valamat_pemesan, vnomer_kontak_pemesan,
            vkota_administrasi, vtanggal_pesanan, vjenis_pesanan;
    EditText etstatus_pesanan,etnama_teknisi, etnomer_kontak;
    TextView tvid_pesan , tvnama_pemesan , tvalamat_pemesan, tvnomer_kontak_pemesan, tvstatus_pesanan,
            tvkota_administrasi, tvtanggal_pesanan, tvjenis_pesanan, tvnama_teknisi, tvnomer_kontak;
    Button btndelete, btnupdate, btnback;
    String status_pesanan, nama_teknisi, nomer_kontak;

    public static final String DATA_DETIL ="string_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_admin);

        btndelete = findViewById(R.id.btndelete);
        btnupdate = findViewById(R.id.btnupdate);
        btnback = findViewById(R.id.btnback);
        tvid_pesan = findViewById(id_pesan);
        tvnama_pemesan = findViewById(R.id.nama);
        tvalamat_pemesan = findViewById(R.id.alamat);
        tvnomer_kontak_pemesan = findViewById(R.id.nomer_kontak_pemesan);
        tvkota_administrasi = findViewById(R.id.kota);
        tvtanggal_pesanan = findViewById(R.id.tanggal);
        tvjenis_pesanan = findViewById(jenis_pesanan);
        etstatus_pesanan = findViewById(R.id.status);
        etnama_teknisi = findViewById(R.id.nama_teknisi);
        etnomer_kontak = findViewById(R.id.nomer_kontak);

        modelData = getIntent().getParcelableExtra(DATA_DETAIL);
        vid_pesan = modelData.getIdPesan();
        vnama_pemesan = modelData.getNamaPemesan();
        valamat_pemesan = modelData.getAlamatPemesan();
        vnomer_kontak_pemesan = modelData.getNomerKontakPemesan();
        vkota_administrasi = modelData.getKotaAdministrasi();
        vtanggal_pesanan = modelData.getTanggalPesanan();
        vjenis_pesanan = modelData.getJenisPesanan();
        status_pesanan = modelData.getStatusPesanan();
        nama_teknisi = modelData.getNamaTeknisi();
        nomer_kontak = modelData.getNomerKontak();

        tvid_pesan.setText(vid_pesan);
        tvnama_pemesan.setText(vnama_pemesan);
        tvalamat_pemesan.setText(valamat_pemesan);
        tvnomer_kontak_pemesan.setText(vnomer_kontak_pemesan);
        tvkota_administrasi.setText(vkota_administrasi);
        tvtanggal_pesanan.setText(vtanggal_pesanan);
        tvjenis_pesanan.setText(vjenis_pesanan);
        etstatus_pesanan.setText(status_pesanan);
        etnama_teknisi.setText(nama_teknisi);
        etnomer_kontak.setText(nomer_kontak);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali = new Intent(UpdateAdmin.this, MainAdmin.class);
                startActivity(kembali);
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(UpdateAdmin.this);
                pesan.setMessage("Apakah Anda Yakin Ingin Menyimpan DataLogin Ini?");
                pesan.setTitle("PERHATIAN !");
                pesan.setCancelable(true);

                pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvid_pesan.getText().toString();
                        status_pesanan = etstatus_pesanan.getText().toString();
                        nama_teknisi = etnama_teknisi.getText().toString();
                        nomer_kontak = etnomer_kontak.getText().toString();
                        if (etstatus_pesanan.equals("")) {
                            etstatus_pesanan.setError("Tidak Boleh Kosong");
                        } else
                        if  (etnama_teknisi.equals("")) {
                                etnama_teknisi.setError("Tidak Boleh Kosong");
                            }else
                         if (etnomer_kontak.equals("")){
                                    etnomer_kontak.setError("Tidak Boleh Kosong");
                        }
                        else{
                            updateData();
                        }
                    }
                });
                pesan.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                pesan.show();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(UpdateAdmin.this);
                pesan.setMessage("Apakah Anda Yakin Ingin Menghapus DataLogin Ini?");
                pesan.setTitle("PERHATIAN !");
                pesan.setCancelable(true);

                pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvid_pesan.getText().toString();
                        deleteData();

                        Intent hapus = new Intent(UpdateAdmin.this, MainActivity.class);
                        startActivity(hapus);
                    }
                });
                pesan.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                pesan.show();
            }
        });
    }



    private void updateData(){
        APIInterface ardupdate = APIClient.getClient().create(APIInterface.class);
        Call<ResponseData> updateData = ardupdate.updateData( vid_pesan, status_pesanan, nama_teknisi, nomer_kontak);

        updateData.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> Call, Response<ResponseData> response) {
                int kode = response.body().getKode();
                String pesan= response.body().getMessage();
                Log.d("SERVER_KODE",String.valueOf(kode));
                Log.d("SERVER_PESAN",pesan);

//                Toast.makeText(UbahActivity.this, "DataLogin Berhasil Diubah", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.d("SERVER_PESAN",t.getMessage());
            }
        });
    }
    private void deleteData(){
        APIInterface ardData = APIClient.getClient().create(APIInterface.class);
        Call<ResponseData> hapusData = ardData.hapusData(vid_pesan);

        hapusData.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getMessage();

                Toast.makeText(UpdateAdmin.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(UpdateAdmin.this, "Gagal Menghubungi Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }); }
}