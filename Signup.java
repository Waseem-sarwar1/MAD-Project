package com.vishwajeeth.medicinetime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Signup extends AppCompatActivity {

    EditText full_name, username, email, password, cnfrm_pass;
    Button signup_btn;
    TextView loginNavBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        full_name = findViewById(R.id.full_name);
        username = findViewById(R.id.username);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        cnfrm_pass = findViewById(R.id.signup_confirm_password);
        signup_btn = findViewById(R.id.signUp_btn);
        loginNavBtn = findViewById(R.id.login_screen_btn);


        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullname, uname, em, pass;
                fullname = String.valueOf(full_name.getText());
                uname = String.valueOf(username.getText());
                em = String.valueOf(email.getText());
                pass = String.valueOf(password.getText());

                if(!fullname.equals("") && !uname.equals("") && !em.equals("") && !pass.equals("")) {

                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "full_name";
                            field[1] = "username";
                            field[2] = "email";
                            field[3] = "password";
                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = "full_name";
                            data[1] = "username";
                            data[2] = "email";
                            data[3] = "password";
                            PutData putData = new PutData("http://192.168.1.11/Registration/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Sign Up Success")){
                                        Intent intent = new Intent(getApplicationContext(), MedicineApp.class);
                                        startActivity(intent);
                                        finish();

                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                                    }

                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
                Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
                 
            }
        });

    }
}