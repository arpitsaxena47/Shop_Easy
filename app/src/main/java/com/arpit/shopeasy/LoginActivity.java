package com.arpit.shopeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;
import com.parse.ParseException;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtUsernameLogin;
    EditText edtPasswordLogin;
    ProgressBar progressBarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btnLoginLogin).setOnClickListener(this);
        findViewById(R.id.btnLoginSignup).setOnClickListener(this);

        edtUsernameLogin = findViewById(R.id.edtUsername);
        edtPasswordLogin = findViewById(R.id.edtPassword);
        progressBarLogin = findViewById(R.id.progressBarLogin);
    }

    public void loginUser() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        progressBarLogin.setVisibility(View.VISIBLE);

                        ParseUser.logInInBackground(edtUsernameLogin.getText().toString(), edtPasswordLogin.getText().toString(), new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {

                                if (user != null && e == null) {
                                    FancyToast.makeText(LoginActivity.this, "Login Successful", FancyToast.SUCCESS,
                                            FancyToast.LENGTH_SHORT, true).show();
                                    Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(loginIntent);


                                } else {
                                    FancyToast.makeText(LoginActivity.this, "Login Failed" + e.getMessage(), FancyToast.ERROR
                                            , FancyToast.LENGTH_SHORT, true).show();
                                }
                            }

                        });


        progressDialog.dismiss();
        progressBarLogin.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnLoginLogin:
                if(edtUsernameLogin.getText().toString().equals("") || edtPasswordLogin.getText().toString().equals("")){
                    FancyToast.makeText(this,"Fields are required" , Toast.LENGTH_SHORT,FancyToast.ERROR , true).show();
                }
                else {
                    loginUser();
                }
                break;

            case R.id.btnLoginSignup:
                Intent signupIntent = new Intent(LoginActivity.this , SignupActivity.class);
                startActivity(signupIntent);
                finish();
                break;

        }
    }
}