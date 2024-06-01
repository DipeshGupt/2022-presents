package com.example.savelife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity1 extends AppCompatActivity {

    private EditText textemail,textpassword;
    private ProgressBar progressbar;
    private FirebaseAuth authProfile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        getSupportActionBar().setTitle("Login");

        textemail = findViewById(R.id.email);
        textpassword = findViewById(R.id.password);
        progressbar = findViewById(R.id.progress);
        authProfile = FirebaseAuth.getInstance();

        //login user
        Button login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = textemail.getText().toString();
                String passwordtext = textpassword.getText().toString();0

                if (TextUtils.isEmpty(emailtext)){
                    Toast.makeText(MainActivity1.this, "please enter your email", Toast.LENGTH_SHORT).show();
                    textemail.setError("email is required");
                    textemail.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailtext).matches()) {
                    Toast.makeText(MainActivity1.this, "please re-enter your email", Toast.LENGTH_SHORT).show();
                    textemail.setError("valid email is required");
                    textemail.requestFocus();

                } else if (TextUtils.isEmpty(passwordtext)) {
                    Toast.makeText(MainActivity1.this, "please enter your password", Toast.LENGTH_SHORT).show();
                    textpassword.setError("password is required");
                    textpassword.requestFocus();
                }else {
                    progressbar.setVisibility(View.VISIBLE);
                    loginUser(emailtext,passwordtext);
                }
            }
        });


        //set the title
//        getSupportActionBar().setTitle("Save Life");

        /*//open login activity
        Button loginbutton = findViewById(R.id.login_button);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity1.this,HomeActivity.class);
                startActivity(intent);
            }
        });*/


        //open register button
        TextView registeraccount = findViewById(R.id.register);
        registeraccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this,CreateActivity.class);
                startActivity(intent);
            }
        });



    }


    private void loginUser(String textemail, String textpassword){
        authProfile.signInWithEmailAndPassword(textemail,textpassword).addOnCompleteListener(MainActivity1.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity1.this, "your are logged in now", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity1.this,HomeActivity.class));
                }else {
                    Toast.makeText(MainActivity1.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
                progressbar.setVisibility(View.GONE);
            }
        });
    }

}