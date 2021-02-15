package com.wartono.my.Activity.Konsumen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wartono.my.Model.Data.ModelData;
import com.wartono.my.R;
import com.wartono.my.SessionManager;

import java.util.List;

public class DetilActivity extends AppCompatActivity {
    SessionManager session;
    private RecyclerView revData;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lmData;
    private List<ModelData> detail;
    ProgressBar loading;

    String vid_pesan , vnama_pemesan , valamat_pemesan,
            vkota_administrasi, vtanggal_pesanan, vjenis_pesanan;
    TextView tvid_pesan , tvnama_pemesan , tvalamat_pemesan,tvstatus_pesanan,
            tvkota_administrasi, tvtanggal_pesanan, tvjenis_pesanan;

    Button btndelete, btnupdate, btnback;

    String status_pesanan;

        public static final String DATA_DETIL ="string_extra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil);

        btndelete = findViewById(R.id.btndelete);
        btnupdate = findViewById(R.id.btnupdate);
        btnback = findViewById(R.id.btnback);
        tvid_pesan = findViewById(R.id.tvid_pesan);
        tvnama_pemesan = findViewById(R.id.tvnama_pemesan);
        tvalamat_pemesan = findViewById(R.id.tvalamat_pemesan);
        tvkota_administrasi = findViewById(R.id.tvkota_adminitrasi);
        tvtanggal_pesanan = findViewById(R.id.tvtanggal_pesanan);
        tvjenis_pesanan = findViewById(R.id.tvjenis_pesanan);
        tvstatus_pesanan = findViewById(R.id.tvstatus_pesanan);




    }
}