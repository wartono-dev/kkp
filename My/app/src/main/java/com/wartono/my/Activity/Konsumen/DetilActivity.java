package com.wartono.my.Activity.Konsumen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wartono.my.API.APIClient;
import com.wartono.my.API.APIInterface;
import com.wartono.my.Model.Data.ModelData;
import com.wartono.my.Model.Data.ResponseData;
import com.wartono.my.R;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetilActivity extends AppCompatActivity {

    String vid_pesan , vnama_pemesan , valamat_pemesan, vnomer_kontak_pemesan,
            vkota_administrasi, vtanggal_pesanan, vjenis_pesanan, vstatus_pesanan, vnama_teknisi, vnomer_kontak;
    TextView tvid_pesan , tvnama_pemesan , tvalamat_pemesan, tvnomer_kontak_pemesan, tvstatus_pesanan,
            tvkota_administrasi, tvtanggal_pesanan, tvjenis_pesanan, tvnama_teknisi, tvnomer_kontak;
    Button btncancel, btneditdata;

    public static final String DATA_DETAIL ="string_extra";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil);

        btncancel = findViewById(R.id.btncancel);
        btneditdata = findViewById(R.id.btneditdata);


        tvid_pesan = findViewById(R.id.id_pesan);
        tvnama_pemesan = findViewById(R.id.nama);
        tvalamat_pemesan = findViewById(R.id.alamat);
        tvnomer_kontak_pemesan = findViewById(R.id.nomer_kontak_pemesan);
        tvkota_administrasi = findViewById(R.id.kota);
        tvtanggal_pesanan = findViewById(R.id.tanggal);
        tvjenis_pesanan = findViewById(R.id.jenis_pesanan);
        tvstatus_pesanan = findViewById(R.id.status);
        tvnama_teknisi = findViewById(R.id.nama_teknisi);
        tvnomer_kontak = findViewById(R.id.nomer_kontak);

        ModelData modelData = getIntent().getParcelableExtra(DATA_DETAIL);
        vid_pesan = modelData.getIdPesan();
        vnama_pemesan = modelData.getNamaPemesan();
        valamat_pemesan = modelData.getAlamatPemesan();
        vnomer_kontak_pemesan = modelData.getNomerKontakPemesan();
        vkota_administrasi = modelData.getKotaAdministrasi();
        vtanggal_pesanan = modelData.getTanggalPesanan();
        vjenis_pesanan = modelData.getJenisPesanan();
        vstatus_pesanan = modelData.getStatusPesanan();
        vnama_teknisi = modelData.getNamaTeknisi();
        vnomer_kontak = modelData.getNomerKontak();

        tvid_pesan.setText(vid_pesan);
        tvnama_pemesan.setText(vnama_pemesan);
        tvalamat_pemesan.setText(valamat_pemesan);
        tvnomer_kontak_pemesan.setText(vnomer_kontak_pemesan);
        tvkota_administrasi.setText(vkota_administrasi);
        tvtanggal_pesanan.setText(vtanggal_pesanan);
        tvjenis_pesanan.setText(vjenis_pesanan);
        tvstatus_pesanan.setText(vstatus_pesanan);
        tvnama_teknisi.setText(vnama_teknisi);
        tvnomer_kontak.setText(vnomer_kontak);

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(DetilActivity.this);
                pesan.setMessage("Apakah Anda Yakin Ingin Membatalkan Pesanan Ini?");
                pesan.setTitle("PERHATIAN !");
                pesan.setCancelable(true);

                pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvid_pesan.getText().toString();
                        deleteData();

                        Intent hapus = new Intent(DetilActivity.this, MainActivity.class);
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

            private void deleteData() {
                APIInterface ardData = APIClient.getClient().create(APIInterface.class);
                Call<ResponseData> hapusData = ardData.hapusData(vid_pesan);

                hapusData.enqueue(new Callback<ResponseData>() {
                    @Override
                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                        int kode = response.body().getKode();
                        String pesan = response.body().getMessage();

                        Toast.makeText(DetilActivity.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseData> call, Throwable t) {

                    }
                });

            }
        });
        btneditdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DetilActivity.this, EditKonsumen.class);
                startActivity(a);
            }
        });
}
}
