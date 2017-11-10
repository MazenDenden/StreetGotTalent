package com.example.mazen.streetgottalent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText loginInput, passInput, rePassInput, mailInput;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginInput = (EditText) findViewById(R.id.loginInput);
        passInput = (EditText) findViewById(R.id.passInput);
        rePassInput = (EditText) findViewById(R.id.rePassInput);
        mailInput = (EditText) findViewById(R.id.mailInput);
        registerBtn = (Button) findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
