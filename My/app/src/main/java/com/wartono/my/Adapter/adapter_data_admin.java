package com.wartono.my.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wartono.my.Activity.Admin.UpdateAdmin;
import com.wartono.my.Model.Data.ModelData;
import com.wartono.my.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;



    public class adapter_data_admin extends RecyclerView.Adapter<adapter_data_admin.HolderData> {
        private Context context;
        private List<ModelData> list_data;
        public adapter_data_admin (Context context, List<ModelData>list_data){
            this.context = context;
            this.list_data = list_data;
        }
        @NonNull
        @Override
        public adapter_data_admin.HolderData onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
            adapter_data_admin.HolderData holder = new adapter_data_admin.HolderData(layout);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull adapter_data_admin.HolderData holder, int position) {
            final ModelData dm = list_data.get(position);
            holder.tv_id_card.setText(dm.getIdPesan());
            holder.tv_nama.setText(dm.getNamaPemesan());
            holder.tv_alamat.setText(dm.getAlamatPemesan());
            holder.tv_nomer_kontak_pemesan.setText(dm.getNomerKontakPemesan());
            holder.tv_kota.setText(dm.getKotaAdministrasi());
            holder.tv_tanggal.setText(dm.getTanggalPesanan());
            holder.tv_status.setText(dm.getStatusPesanan());
            holder.tv_jenis.setText(dm.getJenisPesanan());
            holder.tv_nama_teknisi.setText(dm.getNamaTeknisi());
            holder.tv_nomer_kontak.setText(dm.getNomerKontak());

            holder.cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, UpdateAdmin.class);
                    i.putExtra(UpdateAdmin.DATA_DETIL, (Parcelable) dm);
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
            TextView tv_nama, tv_id_card,tv_alamat, tv_nomer_kontak_pemesan, tv_jenis, tv_kota,
                    tv_status, tv_tanggal, tv_nama_teknisi, tv_nomer_kontak;
            CardView cardview;
            public HolderData(@NonNull View itemView) {
                super(itemView);
                cardview = itemView.findViewById(R.id.layoutlist);
                tv_nama = itemView.findViewById(R.id.tv_listnama);
                tv_id_card = itemView.findViewById(R.id.id_item);
                tv_alamat = itemView.findViewById(R.id.alamat);
                tv_nama_teknisi = itemView.findViewById(R.id.nama_teknisi);
                tv_nomer_kontak = itemView.findViewById(R.id.nomer_kontak);
                tv_nomer_kontak_pemesan = (TextView) itemView.findViewById(R.id.nomer_kontak_pemesan);
                tv_jenis = (TextView) itemView.findViewById(R.id.jenis_pesanan);
                tv_kota = (TextView) itemView.findViewById(R.id.kota);
                tv_status = (TextView) itemView.findViewById(R.id.list_status);
                tv_tanggal = (TextView) itemView.findViewById(R.id.tgl);


            }
        }
    }

