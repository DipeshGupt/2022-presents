package com.example.savelife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class HomeActivity extends AppCompatActivity {

    TextView donors, acceptors;
    MaterialButton donor_buttons, acceptor_buttons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        donors = findViewById(R.id.donor);
        acceptors = findViewById(R.id.acceptor);
        donor_buttons = findViewById(R.id.donor_button);
        acceptor_buttons = findViewById(R.id.acceptor_button);



         //open login activity
        MaterialButton donor_buttons = findViewById(R.id.donor_button);
        donor_buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this,DonorActivity.class);
                startActivity(intent);
            }
        });



        //open login activity
        MaterialButton acceptor_buttons = findViewById(R.id.acceptor_button);
        acceptor_buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this,Acceptor_Activity.class);
                startActivity(intent);
            }
        });


    }
}