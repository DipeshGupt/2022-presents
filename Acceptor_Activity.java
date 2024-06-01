package com.example.savelife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Acceptor_Activity extends AppCompatActivity {

    private TextView textname, textname1,textname2,textname3,textname4;
    //private EditText texteditname, texteditname1, texteditname2, texteditname3, texteditname4;
    //private Button submit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceptor);



        EditText editname = findViewById(R.id.editname);
        EditText editname1 = findViewById(R.id.editname1);
        EditText editname2 = findViewById(R.id.editname2);
        EditText editname3 = findViewById(R.id.editname3);
        EditText editname4 = findViewById(R.id.editname4);




        Button submit1 = findViewById(R.id.submit);
        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //obtain the entered data
                String texteditname1 = editname.getText().toString();
                String texteditname2 = editname1.getText().toString();
                String texteditname3 = editname2.getText().toString();
                String texteditname4 = editname3.getText().toString();
                String texteditname5 = editname4.getText().toString();

                if (TextUtils.isEmpty(texteditname1)){
                    Toast.makeText(Acceptor_Activity.this,"please enter your name",Toast.LENGTH_LONG).show();
                    editname.setError("name is required");
                    editname.requestFocus();
                } else if (TextUtils.isEmpty(texteditname2)) {
                    Toast.makeText(Acceptor_Activity.this,"please enter your gender",Toast.LENGTH_LONG).show();
                    editname1.setError("gender is required");
                    editname1.requestFocus();

                } else if (TextUtils.isEmpty(texteditname3)) {
                    Toast.makeText(Acceptor_Activity.this,"please enter your email",Toast.LENGTH_LONG).show();
                    editname2.setError("Email is required");
                    editname2.requestFocus();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(texteditname3).matches()) {
                    Toast.makeText(Acceptor_Activity.this,"please re-enter your email",Toast.LENGTH_LONG).show();
                    editname2.setError("Valid Email is required");
                    editname2.requestFocus();
                } else if (TextUtils.isEmpty(texteditname4)) {
                    Toast.makeText(Acceptor_Activity.this,"please enter your blood type",Toast.LENGTH_LONG).show();
                    editname3.setError("Date of birth is required");
                    editname3.requestFocus();

                } else if (TextUtils.isEmpty(texteditname5)) {
                    Toast.makeText(Acceptor_Activity.this,"please enter your address",Toast.LENGTH_LONG).show();
                    editname4.setError("password is required");
                    editname4.requestFocus();

                } else {
                    //progressbar.setVisibility(View.VISIBLE);
                    Toast.makeText(Acceptor_Activity.this,"Your response is recorded",Toast.LENGTH_LONG).show();

                }

            }
        });




    }



}