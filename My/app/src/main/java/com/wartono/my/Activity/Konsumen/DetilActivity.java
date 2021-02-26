package com.wartono.my.Activity.Konsumen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.wartono.my.Model.Data.ModelData;
import com.wartono.my.R;

import androidx.appcompat.app.AppCompatActivity;

public class DetilActivity extends AppCompatActivity {

    String vid_pesan , vnama_pemesan , valamat_pemesan, vnomer_kontak_pemesan,
            vkota_administrasi, vtanggal_pesanan, vjenis_pesanan, vstatus_pesanan, vnama_teknisi, vnomer_kontak;
    TextView tvid_pesan , tvnama_pemesan , tvalamat_pemesan, tvnomer_kontak_pemesan, tvstatus_pesanan,
            tvkota_administrasi, tvtanggal_pesanan, tvjenis_pesanan, tvnama_teknisi, tvnomer_kontak;
    Button btnback;

    public static final String DATA_DETAIL ="string_extra";

    public DetilActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil);

        btnback = findViewById(R.id.btnback);

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

        btnback.setOnClickListener(v -> {
            Intent kembali = new Intent(DetilActivity.this, MainActivity.class);
            startActivity(kembali);
        });
        }}