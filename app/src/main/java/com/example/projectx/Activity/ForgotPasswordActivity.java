package com.example.projectx.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectx.R;

public class ForgotPasswordActivity extends AppCompatActivity {
     EditText pass,confpass;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        pass=(EditText)findViewById(R.id.forpas);
        confpass=(EditText)findViewById(R.id.confpas);
        submit=(Button)findViewById(R.id.fbutton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String forpass = pass.getText().toString();
                if (forpass.length() == 0) {
                    pass.setError("Enter Password");
                }
                String confpas = confpass.getText().toString();
                if (confpas.length() == 0) {
                    confpass.setError("Re-enter Password");
                }
                else {
                       Intent homeIntent = new Intent(ForgotPasswordActivity.this, loginscreen.class);
                        startActivity(homeIntent);
                        finish();
                    }
            }
        });

    }
}
