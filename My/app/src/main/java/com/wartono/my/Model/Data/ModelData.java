package com.wartono.my.Model.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelData implements Parcelable
{

    @SerializedName("id_pesan")
    @Expose
    private String idPesan;
    @SerializedName("nama_pemesan")
    @Expose
    private String namaPemesan;
    @SerializedName("alamat_pemesan")
    @Expose
    private String alamatPemesan;
    @SerializedName("kota_administrasi")
    @Expose
    private String kotaAdministrasi;
    @SerializedName("status_pesanan")
    @Expose
    private String statusPesanan;
    @SerializedName("tanggal_pesanan")
    @Expose
    private String tanggalPesanan;
    @SerializedName("jenis_pesanan")
    @Expose
    private String jenisPesanan;
    public final static Parcelable.Creator<ModelData> CREATOR = new Creator<ModelData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ModelData createFromParcel(Parcel in) {
            return new ModelData(in);
        }

        public ModelData[] newArray(int size) {
            return (new ModelData[size]);
        }

    }
            ;

    protected ModelData(Parcel in) {
        this.idPesan = ((String) in.readValue((String.class.getClassLoader())));
        this.namaPemesan = ((String) in.readValue((String.class.getClassLoader())));
        this.alamatPemesan = ((String) in.readValue((String.class.getClassLoader())));
        this.kotaAdministrasi = ((String) in.readValue((String.class.getClassLoader())));
        this.statusPesanan = ((String) in.readValue((String.class.getClassLoader())));
        this.tanggalPesanan = ((String) in.readValue((String.class.getClassLoader())));
        this.jenisPesanan = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ModelData() {
    }

    public String getIdPesan() {
        return idPesan;
    }

    public void setIdPesan(String idPesan) {
        this.idPesan = idPesan;
    }

    public String getNamaPemesan() {
        return namaPemesan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public String getAlamatPemesan() {
        return alamatPemesan;
    }

    public void setAlamatPemesan(String alamatPemesan) {
        this.alamatPemesan = alamatPemesan;
    }

    public String getKotaAdministrasi() {
        return kotaAdministrasi;
    }

    public void setKotaAdministrasi(String kotaAdministrasi) {
        this.kotaAdministrasi = kotaAdministrasi;
    }

    public String getStatusPesanan() {
        return statusPesanan;
    }

    public void setStatusPesanan(String statusPesanan) {
        this.statusPesanan = statusPesanan;
    }

    public String getTanggalPesanan() {
        return tanggalPesanan;
    }

    public void setTanggalPesanan(String tanggalPesanan) {
        this.tanggalPesanan = tanggalPesanan;
    }

    public String getJenisPesanan() {
        return jenisPesanan;
    }

    public void setJenisPesanan(String jenisPesanan) {
        this.jenisPesanan = jenisPesanan;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idPesan);
        dest.writeValue(namaPemesan);
        dest.writeValue(alamatPemesan);
        dest.writeValue(kotaAdministrasi);
        dest.writeValue(statusPesanan);
        dest.writeValue(tanggalPesanan);
        dest.writeValue(jenisPesanan);
    }

    public int describeContents() {
        return 0;
    }

}