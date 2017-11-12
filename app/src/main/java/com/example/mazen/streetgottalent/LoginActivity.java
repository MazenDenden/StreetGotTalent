package com.example.mazen.streetgottalent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    EditText mailInput, passInput;
    Button loginBtn, gmailBtn;
    TextView textView, textView3, textView4;
    ImageView imageView6, userImage, lockImage, imageView7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mailInput = (EditText) findViewById(R.id.mailInput);
        passInput = (EditText) findViewById(R.id.passInput);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        gmailBtn = (Button) findViewById(R.id.gmailBtn);
        textView = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        userImage = (ImageView) findViewById(R.id.userImage);
        lockImage = (ImageView) findViewById(R.id.lockImage);

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivity(intent);
            }
        });
    }
}
