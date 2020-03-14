package com.example.projectx.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectx.R;


public class regscreen extends AppCompatActivity {
    private EditText name,mail,password;
    private Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regscreen);

        name=(EditText)findViewById(R.id.name);

        mail=(EditText)findViewById(R.id.emailreg);

        password=(EditText)findViewById(R.id.pass);
        reg=(Button)findViewById(R.id.button);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enter_name=name.getText().toString();
                if (enter_name.length() == 0)
                {
                    name.setError("Enter Name");
                }
                String enter_mail=mail.getText().toString();
                if (enter_mail.length() == 0)
                {
                    mail.setError("Enter Email");
                }
                String enter_password=password.getText().toString();
                if (enter_password.length() == 0)
                {
                    password.setError("Enter Password");
                }
                else{
                    android.content.Intent homeIntent = new Intent(regscreen.this, HomePageActivity.class);
                    startActivity(homeIntent);
                    finish();
                    Toast.makeText(regscreen.this, "REGISTERED", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
