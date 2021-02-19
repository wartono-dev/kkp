package com.wartono.my.API;

import com.wartono.my.Model.Data.ResponseData;
import com.wartono.my.Model.Login.Mlogin;
import com.wartono.my.Model.Register.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {


     @FormUrlEncoded
     @POST("login.php")
     Call<Mlogin> loginResponse(
             @Field("username") String username,
             @Field("password") String password
     );

     @FormUrlEncoded
     @POST("register.php")
     Call<ResponseRegister> RegisterResponse(
             @Field("username") String username,
             @Field("nomer_kontak") String nomer_kontak,
             @Field("password") String password
     );

     @FormUrlEncoded
     @POST("add_pesanan.php")
     Call<ResponseData> Insert_data(
             @Field("nama_pemesan") String nama_pemesan,
             @Field("alamat_pemesan") String alamat_pemesan,
             @Field("nomer_kontak_pemesan") String nomer_kontak_pemesan,
             @Field("kota_administrasi") String kota_administrasi,
             @Field("status_pesanan") String status_pesanan,
             @Field("tanggal_pesanan") String tanggal_pesanan,
             @Field("jenis_pesanan") String jenis_pesanan
     );

     @FormUrlEncoded
     @POST("uodate_data.php")
     Call<ResponseData> EditData(
             @Field("id_pesan") String vid,
             @Field("status_pesanan") String status
     );

     @FormUrlEncoded
     @POST("detil_data_admin.php")
     Call<ResponseData> updateData(
             @Field("id_pesan") String id_pesan,
             @Field("status_pesanan") String status_pesanan,
             @Field("nama_teknisi") String nama_teknisi,
             @Field("nomer_kontak") String nomer_kontak
     );

     @FormUrlEncoded
     @POST("delete.php")
     Call<ResponseData> hapusData(
             @Field("id_pesan") String id_pesan
     );

     @FormUrlEncoded
     @POST("detail_data_admin.php")
     Call<ResponseData> updateAdmin(
             @Field("id_pesan") String id_pesan,
             @Field("status_pesanan") String status_pesanan,
             @Field("nama_taknisi") String nama_teknisi,
             @Field("nomer_kontak") String nomer_kontak);

     @GET("read_data.php")
     Call<ResponseData> Read_data(
             @Query("id_pesan") String id_pesan,
             @Query("nama_pemesan") String nama_pemesan,
             @Query("alamat_pemesan") String alamat_pemesan,
             @Query("nomer_kontak_pemesan") String nomer_kontak_pemesan,
             @Query("kota_administrasi") String kota_administrasi,
             @Query("status_pesanan") String status_pesanan,
             @Query("nama_teknisi") String nama_teknisi,
             @Query("nomer_kontak") String nomer_kontak
     );

}