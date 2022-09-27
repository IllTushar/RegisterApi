package com.example.registrationrestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registrationrestapi.Api.ApiServices;
import com.example.registrationrestapi.Api.RetrofiClient;
import com.example.registrationrestapi.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
EditText email,password;
Button register;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    processData(email.getText().toString(),password.getText().toString());

                }
                catch (Exception e){
                    Log.d("##Error",e.getMessage());
                }
            }
        });
    }

    private void processData(String Email, String Password)
    {
        ApiServices api = RetrofiClient.getRetrofit().create(ApiServices.class);
        Call<ResponseModel>call = api.getData(Email,Password);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful())
                {
                    Log.d("##Check1",response.body().getId());
                    Log.d("##Check",response.body().getToken());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}