package com.example.projectx.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectx.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class loginscreen extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private EditText usern, password;
    Button login;
    SignInButton signInButton;
    private GoogleApiClient googleApiClient;
    private static final int RC_SIGNI_IN=1;

    private TextView createacc, forgot;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);


        GoogleSignInOptions gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();
        signInButton=(SignInButton)findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                    startActivityForResult(intent,RC_SIGNI_IN);
            }
        });

        usern = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        createacc = (TextView) findViewById(R.id.create);
        login = (Button) findViewById(R.id.one);
        forgot = (TextView) findViewById(R.id.fpss);


        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.content.Intent homeIntent = new Intent(loginscreen.this, regscreen.class);
                startActivity(homeIntent);


            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forIntent = new Intent(loginscreen.this, ForgotPasswordActivity.class);
                startActivity(forIntent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String enter_email = usern.getText().toString();
                if (enter_email.length() == 0) {
                    usern.setError("Enter Username");
                }
                String enter_password = password.getText().toString();
                if (enter_password.length() == 0) {
                    password.setError("Enter Password");
                } else {
                    android.content.Intent homeIntent = new Intent(loginscreen.this, HomePageActivity.class);
                    startActivity(homeIntent);
                    Toast.makeText(loginscreen.this, "LOGIN", Toast.LENGTH_LONG).show();

                }

            }

        });


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==RC_SIGNI_IN){
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInresult(result);
        }
    }

    private void handleSignInresult(GoogleSignInResult result) {
        if(result.isSuccess()){
            gotoProfile();
        }else{
            Toast.makeText(getApplicationContext(),"Sign incomplete",Toast.LENGTH_SHORT).show();
        }
    }

    private void gotoProfile() {
        Intent intent=new Intent(loginscreen.this,HomePageActivity.class);
        startActivity(intent);
    }
}