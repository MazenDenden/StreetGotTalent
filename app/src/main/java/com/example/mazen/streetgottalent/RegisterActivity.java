package com.example.mazen.streetgottalent;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {

    EditText nameInput, passInput, rePassInput, mailInput;
    Button registerBtn;

    private static final String REGISTER_URL = "http://172.16.65.238/streetgottalent/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameInput = (EditText) findViewById(R.id.nameInput);
        passInput = (EditText) findViewById(R.id.passInput);
        rePassInput = (EditText) findViewById(R.id.rePassInput);
        mailInput = (EditText) findViewById(R.id.mailInput);
        registerBtn = (Button) findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim().toLowerCase();
                String pass = passInput.getText().toString().trim().toLowerCase();
                String repass = rePassInput.getText().toString().trim().toLowerCase();
                String mail = mailInput.getText().toString().trim().toLowerCase();
                if(pass.equals(repass)){
                    registerUser(name,mail,pass);
                }else{
                    Toast.makeText(RegisterActivity.this, "password not equal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void registerUser(String name,String email,String pass){
        String urlSuffix = "?name=" +name+ "&email=" +email+ "&password=" +pass;
        class RegisterUser extends AsyncTask<String,Void,String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(), "Internet Not working", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferReader = null;
                try{
                    URL url = new URL(REGISTER_URL + s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result = bufferReader.readLine();
                    return result;
                }catch(Exception e){
                    return null;
                }
            }
        }
        RegisterUser ru = new RegisterUser();
        ru.execute(urlSuffix);
    }
}
