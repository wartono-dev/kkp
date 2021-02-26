package com.wartono.my.Activity.Teknisi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wartono.my.API.APIClient;
import com.wartono.my.API.APIInterface;
import com.wartono.my.Model.Data.ModelData;
import com.wartono.my.Model.Data.ResponseData;
import com.wartono.my.R;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.wartono.my.R.id.id_pesan;
import static com.wartono.my.R.id.jenis_pesanan;

public class UpdateTeknisi extends AppCompatActivity {
    public static String DATA_DETIL;
    String  vid_pesan , vnama_pemesan , valamat_pemesan, vnomer_kontak_pemesan,
            vkota_administrasi, vtanggal_pesanan, vjenis_pesanan,vnama_teknisi, vnomer_kontak;
    String status_pesanan;
    EditText etstatus_pesanan;
    TextView tvid_pesan , tvnama_pemesan , tvalamat_pemesan, tvnomer_kontak_pemesan,
            tvkota_administrasi, tvtanggal_pesanan, tvjenis_pesanan,tvnama_teknisi, tvnomer_kontak;
    Button btnupdate;


    public static final String DATA_DETAIL = "string_extra";
    ModelData modelData;
    private ModelData getModelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_teknisi);

        btnupdate = findViewById(R.id.btnupdate);

        tvid_pesan = findViewById(id_pesan);
        tvnama_pemesan = findViewById(R.id.nama);
        tvalamat_pemesan = findViewById(R.id.alamat);
        tvnomer_kontak_pemesan = findViewById(R.id.nomer_kontak_pemesan);
        tvkota_administrasi = findViewById(R.id.kota);
        tvtanggal_pesanan = findViewById(R.id.tanggal);
        tvjenis_pesanan = findViewById(jenis_pesanan);
        etstatus_pesanan = findViewById(R.id.status);
        tvnama_teknisi = findViewById(R.id.nama_teknisi);
        tvnomer_kontak = findViewById(R.id.nomer_kontak);

        modelData = getIntent().getParcelableExtra(DATA_DETAIL);
        vid_pesan = modelData.getIdPesan();
        vnama_pemesan = modelData.getNamaPemesan();
        valamat_pemesan = modelData.getAlamatPemesan();
        vnomer_kontak_pemesan = modelData.getNomerKontakPemesan();
        vkota_administrasi = modelData.getKotaAdministrasi();
        vtanggal_pesanan = modelData.getTanggalPesanan();
        vjenis_pesanan = modelData.getJenisPesanan();
        status_pesanan = modelData.getStatusPesanan();
        vnama_teknisi = modelData.getNamaTeknisi();
        vnomer_kontak = modelData.getNomerKontak();


        tvid_pesan.setText(vid_pesan);
        tvnama_pemesan.setText(vnama_pemesan);
        tvalamat_pemesan.setText(valamat_pemesan);
        tvnomer_kontak_pemesan.setText(vnomer_kontak_pemesan);
        tvkota_administrasi.setText(vkota_administrasi);
        tvtanggal_pesanan.setText(vtanggal_pesanan);
        tvjenis_pesanan.setText(vjenis_pesanan);
        etstatus_pesanan.setText(status_pesanan);
        tvnama_teknisi.setText(vnama_teknisi);
        tvnomer_kontak.setText(vnomer_kontak);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(UpdateTeknisi.this);
                pesan.setMessage("Apakah Anda Yakin Ingin Menyimpan Data Ini?");
                pesan.setTitle("PERHATIAN !");
                pesan.setCancelable(true);

                pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvid_pesan.getText().toString();
                        status_pesanan = etstatus_pesanan.getText().toString();
                        if (etstatus_pesanan.equals("")) {
                            etstatus_pesanan.setError("Tidak Boleh Kosong");
                        } else {
                            UpdateTeknisi();
                        }
                    }

                    private void UpdateTeknisi() {
                        APIInterface ardData = APIClient.getClient().create(APIInterface.class);
                        Call<ResponseData> UpdateTeknisi = ardData.updateTeknisi(vid_pesan, status_pesanan);
                        UpdateTeknisi.enqueue(new Callback<ResponseData>() {
                            @Override
                            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                                int kode = response.body().getKode();
                                String message = response.body().getMessage();
                                Log.d("SERVER_KODE", String.valueOf(kode));
                                Log.d("SERVER_PESAN", String.valueOf(message));
                                Log.d("SERVER_STATUS", modelData.getStatusPesanan());
                                finish();
                            }

                            @Override
                            public void onFailure(Call<ResponseData> call, Throwable t) {
                                Log.d("SERVER_PESAN", t.getMessage());
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
        });

    }
}