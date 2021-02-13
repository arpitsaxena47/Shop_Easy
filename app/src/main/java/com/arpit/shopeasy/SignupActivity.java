package com.arpit.shopeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtEmailSignUp;
    EditText edtUsernameSignUp;
    EditText edtPassword;
    EditText edtPhoneNum;
    Button btnSignUpSignUp;
    Button btnSignUpLogin;
    ProgressBar progressBarSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnSignUpLogin = findViewById(R.id.btnSignupLogin);
        btnSignUpLogin.setOnClickListener(this);
        btnSignUpSignUp = findViewById(R.id.btnSignUpSignup);
        btnSignUpSignUp.setOnClickListener(this);

        edtEmailSignUp = findViewById(R.id.edtEmailSignup);
        edtPhoneNum = findViewById(R.id.edtPhoneNum);
        edtPassword = findViewById(R.id.edtPasswordSignup);
        edtUsernameSignUp = findViewById(R.id.edtUsernameSignUp);
        progressBarSignUp = findViewById(R.id.progressBarSignUp);
    }


    public void createUser() {
        final ParseUser appuser  = new ParseUser();
        ParseObject user = new ParseObject("User");
        appuser.setEmail(edtEmailSignUp.getText().toString());
        user.put("PhoneNum",edtPhoneNum.getText().toString());
        appuser.setUsername(edtUsernameSignUp.getText().toString());
        appuser.setPassword(edtPassword.getText().toString());

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        progressBarSignUp.setVisibility(View.VISIBLE);

        if(edtUsernameSignUp.getText().toString().equals("") || edtEmailSignUp.getText().toString().equals("")
                || edtPassword.getText().toString().equals(""))
        {
            FancyToast.makeText(SignupActivity.this,"Email, Username and Password are required",FancyToast.INFO
                    ,FancyToast.LENGTH_SHORT,true).show();

            progressBarSignUp.setVisibility(View.GONE);
        }
        else {
            if (edtPhoneNum.getText().toString().length() == 10) {
                appuser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            FancyToast.makeText(SignupActivity.this, "email and password set successfully", FancyToast.SUCCESS,
                                    FancyToast.LENGTH_SHORT, true).show();
                            Intent signupIntent = new Intent(SignupActivity.this, MainActivity.class);
                            startActivity(signupIntent);


                        } else {
                            ParseUser.logOut();
                            FancyToast.makeText(SignupActivity.this, "Error occurred" + e.getMessage(), FancyToast.ERROR,
                                    FancyToast.LENGTH_SHORT, true).show();

                        }

                    }

                });
            }
            else{
                FancyToast.makeText(SignupActivity.this, "Please Enter correct Phone Number!!" , FancyToast.ERROR,
                        FancyToast.LENGTH_SHORT, true).show();
            }
        }
            progressDialog.dismiss();
            progressBarSignUp.setVisibility(View.GONE);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSignUpSignup:
                if(edtEmailSignUp.getText().toString().equals("") || edtPassword.getText().toString().equals("")
                        || edtUsernameSignUp.getText().toString().equals("")){
                    FancyToast.makeText(this,"Fields are required" , Toast.LENGTH_SHORT,FancyToast.ERROR,true).show();
                }
                else {
                    createUser();

                }
                break;

            case R.id.btnSignupLogin:
                Intent loginIntent = new Intent(SignupActivity.this , LoginActivity.class);
                startActivity(loginIntent);
                finish();
                break;

        }
    }
}