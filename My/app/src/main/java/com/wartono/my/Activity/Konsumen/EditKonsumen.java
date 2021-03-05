package com.wartono.my.Activity.Konsumen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wartono.my.API.APIClient;
import com.wartono.my.API.APIInterface;
import com.wartono.my.Model.Data.ModelData;
import com.wartono.my.Model.Data.ResponseData;
import com.wartono.my.R;
import com.wartono.my.SessionManager;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.wartono.my.Activity.Teknisi.UpdateTeknisi.DATA_DETAIL;
import static com.wartono.my.R.id.id_pesan;
import static com.wartono.my.R.id.jenis_pesanan;

public class EditKonsumen extends AppCompatActivity {

    SessionManager session;
    private RecyclerView revData;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lmData;
    private List<com.wartono.my.Model.Data.ModelData> detail;
    private Parcelable ModelData;
    private ModelData modelData;
    ProgressBar loading;

    String vid_pesan , vnama_pemesan , valamat_pemesan, vnomer_kontak_pemesan,
            vkota_administrasi, vtanggal_pesanan, vjenis_pesanan;
    EditText etid_pesan , etnama_pemesan , etalamat_pemesan, etnomer_kontak_pemesan,
            etkota_administrasi, ettanggal_pesanan, etjenis_pesanan;
    TextView tvid_pesan , tvnama_pemesan , tvalamat_pemesan, tvnomer_kontak_pemesan, tvkota_administrasi,
            tvtanggal_pesanan, tvjenis_pesanan, tvstatus_pesanan, tvnama_teknisi,tvnomer_kontak;
    Button  btnupdate;
    String vstatus_pesanan, vnama_teknisi, vnomer_kontak;

    public static final String DATA_DETIL ="string_extra";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_konsumen);

        btnupdate = findViewById(R.id.btnupdate);

        tvid_pesan = findViewById(id_pesan);
        etnama_pemesan = findViewById(R.id.nama);
        etalamat_pemesan = findViewById(R.id.alamat);
        etnomer_kontak_pemesan = findViewById(R.id.nomer_kontak_pemesan);
        etkota_administrasi = findViewById(R.id.kota);
        ettanggal_pesanan = findViewById(R.id.tanggal);
        etjenis_pesanan = findViewById(jenis_pesanan);
        tvstatus_pesanan = findViewById(R.id.status);
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
        vstatus_pesanan = modelData.getStatusPesanan();
        vnama_teknisi = modelData.getNamaTeknisi();
        vnomer_kontak = modelData.getNomerKontak();

        tvid_pesan.setText(vid_pesan);
        etnama_pemesan.setText(vnama_pemesan);
        etalamat_pemesan.setText(valamat_pemesan);
        etnomer_kontak_pemesan.setText(vnomer_kontak_pemesan);
        etkota_administrasi.setText(vkota_administrasi);
        ettanggal_pesanan.setText(vtanggal_pesanan);
        etjenis_pesanan.setText(vjenis_pesanan);
        tvstatus_pesanan.setText(vstatus_pesanan);
        tvnama_teknisi.setText(vnama_teknisi);
        tvnomer_kontak.setText(vnomer_kontak);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(EditKonsumen.this);
                pesan.setMessage("Apakah Anda Yakin Ingin Menyimpan DataLogin Ini?");
                pesan.setTitle("PERHATIAN !");
                pesan.setCancelable(true);

                pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvid_pesan.getText().toString();
                        vnama_pemesan = etnama_pemesan.getText().toString();
                        valamat_pemesan = etalamat_pemesan.getText().toString();
                        vnomer_kontak_pemesan = etnomer_kontak_pemesan.getText().toString();
                        vkota_administrasi = etkota_administrasi.getText().toString();
                        vtanggal_pesanan = ettanggal_pesanan.getText().toString();
                        vjenis_pesanan = etjenis_pesanan.getText().toString();
                        if (etnama_pemesan.equals("")) {
                            etnama_pemesan.setError("Tidak Boleh Kosong");
                        } else
                        if  (etalamat_pemesan.equals("")) {
                            etalamat_pemesan.setError("Tidak Boleh Kosong");
                        }else
                        if (etnomer_kontak_pemesan.equals("")){
                            etnomer_kontak_pemesan.setError("Tidak Boleh Kosong");
                        } else
                        if (etkota_administrasi.equals("")) {
                                etkota_administrasi.setError("Tidak Boleh Kosong");
                        } else
                        if  (ettanggal_pesanan.equals("")) {
                                ettanggal_pesanan.setError("Tidak Boleh Kosong");
                        }else
                        if (etjenis_pesanan.equals("")){
                                etjenis_pesanan.setError("Tidak Boleh Kosong");
                        } else{
                                EditData();
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

            private void EditData() {
                APIInterface ardData = APIClient.getClient().create(APIInterface.class);
                Call<ResponseData> EditData = ardData.EditData(vid_pesan, vnama_pemesan, valamat_pemesan,
                        vnomer_kontak_pemesan, vkota_administrasi, vtanggal_pesanan, vjenis_pesanan);

                EditData.enqueue(new Callback<ResponseData>() {
                    @Override
                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                        int kode = response.body().getKode();
                        String pesan= response.body().getMessage();
                        Log.d("SERVER_KODE",String.valueOf(kode));
                        Log.d("SERVER_PESAN",pesan);
                        Log.d("SERVER_ID" , modelData.getIdPesan());
                        Log.d("SERVER_STATUS", modelData.getNamaPemesan());
                        Log.d("SERVER_TEKNISI", modelData.getAlamatPemesan());
                        Log.d("SERVER_NOMER", modelData.getNomerKontakPemesan());
                        Log.d("SERVER_ID" , modelData.getKotaAdministrasi());
                        Log.d("SERVER_STATUS", modelData.getTanggalPesanan());
                        Log.d("SERVER_TEKNISI", modelData.getJenisPesanan());

                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseData> call, Throwable t) {
                        Log.d("SERVER_PESAN",t.getMessage());

                    }
                });
            }
        });
    }
}