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
     @POST("login_coba.php")
     Call<Mlogin> loginResponse (
             @Field("username") String username,
             @Field("password") String password
     );

     @FormUrlEncoded
     @POST("register_coba.php")
     Call<ResponseRegister> RegisterResponse (
             @Field("username") String username,
             @Field("name") String name,
             @Field("password") String password
     );

     @GET("read_data.php")
     Call<ResponseData> Read_data(
               @Query("id_pesan") String id_pesan,
               @Query("nama_pemesan") String nama_pemesan,
               @Query("alamat_pemesan") String alamat_pemesan,
               @Query("kota_administrasi") String kota_administrasi,
               @Query("status_pesanan") String status_pesanan,
               @Query("tanggal_pesanan") String tanggal_pesanan,
               @Query("jenis_pesanan") String jenis_pesanan
     );
     @FormUrlEncoded
     @POST("add_pesanan.php")
      Call<ResponseData> Insert_data(
             @Field("nama_pemesan") String nama_pemesan,
             @Field("alamat_pemesan") String alamat_pemesan,
             @Field("kota_administrasi") String kota_administrasi,
             @Field("status_pesanan") String status_pesanan,
             @Field("tanggal_pesanan") String tanggal_pesanan,
             @Field("jenis_pesanan") String jenis_pesanan
     );

}



