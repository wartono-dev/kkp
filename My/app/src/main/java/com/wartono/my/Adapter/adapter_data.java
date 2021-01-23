package com.wartono.my.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.wartono.my.Activity.DetilActivity;
import com.wartono.my.Model.Data.ModelData;
import com.wartono.my.R;

import java.util.List;

public class adapter_data extends RecyclerView.Adapter<adapter_data.HolderData> {
    private Context context;
    private List<ModelData> list_data;
    public adapter_data (Context context, List<ModelData>list_data){
        this.context = context;
        this.list_data = list_data;
    }
    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        final ModelData dm = list_data.get(position);
        holder.tv_id_card.setText(dm.getIdPesan());
        holder.tv_nama.setText(dm.getNamaPemesan());
        holder.tv_alamat.setText(dm.getAlamatPemesan());
        holder.tv_kota.setText(dm.getKotaAdministrasi());
        holder.tv_tanggal.setText(dm.getTanggalPesanan());
        holder.tv_status.setText(dm.getStatusPesanan());
        holder.tv_jenis.setText(dm.getJenisPesanan());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetilActivity.class);
                i.putExtra(DetilActivity.DATA_DETIL, dm);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }
    //menghandle data yang ada didalem cardview list
    public class HolderData extends RecyclerView.ViewHolder{
        TextView tv_nama, tv_id_card,tv_alamat, tv_jenis, tv_kota, tv_status, tv_tanggal;
        CardView cardview;
        public HolderData(@NonNull View itemView) {
            super(itemView);
            cardview = itemView.findViewById(R.id.layoutlist);
            tv_nama = itemView.findViewById(R.id.tv_listnama);
            tv_id_card = itemView.findViewById(R.id.id_item);
            tv_alamat = itemView.findViewById(R.id.alamat);
            tv_jenis = (TextView) itemView.findViewById(R.id.jenis_pesanan);
            tv_kota = (TextView) itemView.findViewById(R.id.kota);
            tv_status = (TextView) itemView.findViewById(R.id.list_status);
            tv_tanggal = (TextView) itemView.findViewById(R.id.tgl);

        }
    }
}
