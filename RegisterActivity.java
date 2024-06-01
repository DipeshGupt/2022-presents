package com.example.savelife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {


    private EditText user_nameEditText, emailEditText, datesEditText, passwordEditText, confirmEditText;
    private Button registerbutton;
    private TextView login;
    private ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Register");

        Toast.makeText(RegisterActivity.this, "you can register", Toast.LENGTH_LONG).show();


        user_nameEditText = findViewById(R.id.user_name);
        emailEditText = findViewById(R.id.email);
        datesEditText = findViewById(R.id.dates);
        passwordEditText = findViewById(R.id.password);
        confirmEditText = findViewById(R.id.confirm);
        registerbutton = findViewById(R.id.register);
        progressbar = findViewById(R.id.progress);
        login = findViewById(R.id.log);



        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //obtain the entered data
                String textusername = user_nameEditText.getText().toString();
                String textemail = emailEditText.getText().toString();
                String textdates = datesEditText.getText().toString();
                String pass = passwordEditText.getText().toString();
                String copass = confirmEditText.getText().toString();

                if (TextUtils.isEmpty(textusername)){
                    Toast.makeText(RegisterActivity.this,"please enter your username",Toast.LENGTH_LONG).show();
                    user_nameEditText.setError("user name is required");
                    user_nameEditText.requestFocus();
                } else if (TextUtils.isEmpty(textemail)) {
                    Toast.makeText(RegisterActivity.this,"please enter your email",Toast.LENGTH_LONG).show();
                    emailEditText.setError("Email is required");
                    emailEditText.requestFocus();

                } else if (!Patterns.EMAIL_ADDRESS.matcher(textemail).matches()) {
                    Toast.makeText(RegisterActivity.this,"please re-enter your email",Toast.LENGTH_LONG).show();
                    emailEditText.setError("Valid Email is required");
                    emailEditText.requestFocus();
                } else if (TextUtils.isEmpty(textdates)) {
                    Toast.makeText(RegisterActivity.this,"please enter your date of birth",Toast.LENGTH_LONG).show();
                    datesEditText.setError("Date of birth is required");
                    datesEditText.requestFocus();

                } else if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(RegisterActivity.this,"please enter your password",Toast.LENGTH_LONG).show();
                    passwordEditText.setError("password is required");
                    passwordEditText.requestFocus();

                } else if (pass.length() < 6) {
                    Toast.makeText(RegisterActivity.this,"password should be grater than6 digits",Toast.LENGTH_LONG).show();
                    passwordEditText.setError("password is weak");
                    passwordEditText.requestFocus();

                } else if (TextUtils.isEmpty(copass)) {
                    Toast.makeText(RegisterActivity.this,"please confirm your password",Toast.LENGTH_LONG).show();
                    confirmEditText.setError("password confirmation is required");
                    confirmEditText.requestFocus();

                } else if (!pass.equals(copass)) {
                    Toast.makeText(RegisterActivity.this,"please type same password",Toast.LENGTH_LONG).show();
                    confirmEditText.setError("password confirmation is required");
                    confirmEditText.requestFocus();

                    //clear the entered passwords
                    passwordEditText.clearComposingText();
                    confirmEditText.clearComposingText();

                }else {
                    progressbar.setVisibility(View.VISIBLE);
                    registeruser(textusername,textemail,textdates,pass,copass);


                }

            }
        });


    }

    //register user using the credentials
    private void registeruser(String textusername, String textemail, String textdates, String pass, String copass) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(textemail,pass).addOnCompleteListener(RegisterActivity.this,
                new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"user registered successfully",Toast.LENGTH_LONG).show();
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    //send verification email
                    firebaseUser.sendEmailVerification();

                    /*
                    //open user profile after successful
                    Intent intent = new Intent(RegisterActivity.this,UserProfileActivity.class);
                    // to  prevent user from returning bck to register activity on pressing back button after registration
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();    //to close register activity
                    */
                }
            }
        });

    }
}