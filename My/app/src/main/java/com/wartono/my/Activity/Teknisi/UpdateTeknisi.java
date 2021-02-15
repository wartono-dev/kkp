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

public class UpdateTeknisi extends AppCompatActivity {
    public static String DATA_DETIL;
    String vid;
    String vnama, valamat, vnomer_kontak_pemesan, vkota, vtanggal, vjenis, vnama_teknisi, vnomer_kontak;
    EditText etstatus;
    TextView tvid, tvnama, tvalamat, tvnomer_kontak_pemesan, tvkota, tvtanggal, tvjenis, tvstatus,
    tvnama_teknisi, tvnomer_kontak;
    Button btnupdate;

    String status;
    public static final String DATA_DETAIL = "string_extra";
    ModelData modelData;
    private ModelData getModelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_teknisi);
        btnupdate = findViewById(R.id.btnupdate);
        tvid = findViewById(R.id.tv_id_pesan);
        tvnama = findViewById(R.id.tvnama_pemesan);
        tvalamat = findViewById(R.id.tvalamat_pemesan);
        tvnomer_kontak_pemesan = findViewById(R.id.tvnomer_kontak_pemesan);
        tvkota = findViewById(R.id.tvkota_adminitrasi);
        tvtanggal = findViewById(R.id.tvtanggal_pesanan);
        tvjenis = findViewById(R.id.tvjenis_pesanan);
        tvstatus = findViewById(R.id.tvstatus_pesanan);
        tvnama_teknisi = findViewById(R.id.tvnama_teknisi);
        tvnomer_kontak = findViewById(R.id.tvnomer_kontak);

        modelData = getIntent().getParcelableExtra(DATA_DETAIL);
        vid = modelData .getIdPesan();
        vnama = modelData .getNamaPemesan();
        valamat = modelData .getAlamatPemesan();
        vnomer_kontak_pemesan = modelData .getNomerKontakPemesan();
        vkota = modelData .getKotaAdministrasi();
        vtanggal = modelData .getTanggalPesanan();
        vjenis = modelData .getJenisPesanan();
        vnama_teknisi = modelData .getNamaTeknisi();
        vnomer_kontak = modelData .getNomerKontak();
        status = modelData .getStatusPesanan();

        tvid.setText(vid);
        tvnama.setText(vnama);
        tvalamat.setText(valamat);
        tvnomer_kontak_pemesan.setText(vnomer_kontak_pemesan);
        tvkota.setText(vkota);
        tvtanggal.setText(vtanggal);
        tvjenis.setText(vjenis);
        tvstatus.setText(status);
        tvnama_teknisi.setText(vnama_teknisi);
        tvnomer_kontak.setText(vnomer_kontak);
        etstatus.setText(status);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(UpdateTeknisi.this);
                pesan.setMessage("Apakah Anda Yakin Ingin Menyimpan DataLogin Ini?");
                pesan.setTitle("PERHATIAN !");
                pesan.setCancelable(true);

                pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvid.getText().toString();
                        status = etstatus.getText().toString();
                        if (etstatus.equals("")) {
                            etstatus.setError("Tidak Boleh Kosong");
                        } else {
                            UpdateData();
                        }
                    }

                    private void UpdateData() {
                        APIInterface ardData = APIClient.getClient().create(APIInterface.class);
                        Call<ResponseData> Update_data = ardData.EditData(vid, status);
                        Update_data.enqueue(new Callback<ResponseData>() {
                            @Override
                            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                                int kode = response.body().getKode();
                                String message = response.body().getMessage();
                                Log.d("SERVER_KODE", String.valueOf(kode));
                                Log.d("SERVER_PESAN", String.valueOf(message));
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