package com.wartono.my;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wartono.my.API.APIClient;
import com.wartono.my.API.APIInterface;
import com.wartono.my.Activity.MainActivity;
import com.wartono.my.Activity.MainAdmin;
import com.wartono.my.Model.Login.LoginData;
import com.wartono.my.Model.Login.Mlogin;


public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    String username, password;
    TextView tvRegister;
    APIInterface apiInterface;
    ProgressDialog progressDialog;
    SessionManager sessionManager;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Logging in ...");
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin   = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                progressDialog.show();
                Login (username,password);
            }
        });

        tvRegister = findViewById(R.id.tvCreateAccount);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent (LoginActivity.this,RegisterActivity.class);
                startActivity(Intent);
            }
        });
    }

    private void Login(String username, String password) {
        if (username.trim().length() > 0 && password.trim().length() > 0) {
            apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<Mlogin> loginCall = apiInterface.loginResponse(username, password);
            loginCall.enqueue(new Callback<Mlogin>() {
                @Override
                public void onResponse(Call<Mlogin> call, Response<Mlogin> response) {
                    if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                        boolean status = response.body().isStatus();
                        String pesan = response.body().getMessage();
                        Log.d("SERVER_KODE ::",String.valueOf(status));
                        Log.d("SERVER_BERHASIL :",pesan);
                        sessionManager = new SessionManager(LoginActivity.this);
                        LoginData loginData = response.body().getLoginData();
                        sessionManager.createLoginSession(loginData);
                        progressDialog.dismiss();
                        if (sessionManager.isLoggedIn() && !sessionManager.getUsername().equals("wawa")) {
                            progressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
                            finish();
                        } else {
                            progressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(), MainAdmin.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
                            finish();
                        }

                    } else {
                        Log.d("SERVER_GAGAL ::",response.body().getMessage());
                        progressDialog.dismiss();
                        alert.showAlertDialog(LoginActivity.this, "Login Gagal", response.body().getMessage(), false);
                    }
                }

                @Override
                public void onFailure(Call<Mlogin> call, Throwable t) {
                    Log.d("SERVER_FATAL :",t.getMessage());
                    progressDialog.dismiss();
                    alert.showAlertDialog(LoginActivity.this, "Login Gagal..", t.getMessage(), false);
                }
            });

        } else {
            progressDialog.dismiss();
            alert.showAlertDialog(LoginActivity.this, "Login gagal..", "Data Login tidak boleh kosong!", false);
        }
    }
}