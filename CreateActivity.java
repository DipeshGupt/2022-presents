package com.example.savelife;

        import androidx.annotation.NonNull;
        import androidx.annotation.RequiresPermission;
        import androidx.appcompat.app.AppCompatActivity;

        import android.app.DatePickerDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.util.Log;
        import android.util.Patterns;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.Firebase;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
        import com.google.firebase.auth.FirebaseAuthUserCollisionException;
        import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

        import java.util.Calendar;
        import java.util.regex.Pattern;

public class CreateActivity extends AppCompatActivity {


    private EditText user_nameEditText, emailEditText, datesEditText, passwordEditText, confirmEditText;
    private Button registerbutton;
    private TextView login;
    private ProgressBar progressbar;
    private static final String TAG="CreateActivity";

    private DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

//        getSupportActionBar().setTitle("Register");

        //open register button
        TextView have = findViewById(R.id.log);
        have.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateActivity.this,MainActivity1.class);
                startActivity(intent);
            }
        });



        Toast.makeText(CreateActivity.this, "you can register", Toast.LENGTH_LONG).show();


        user_nameEditText = findViewById(R.id.user_name);
        emailEditText = findViewById(R.id.email);
        datesEditText = findViewById(R.id.dates);
        passwordEditText = findViewById(R.id.password);
        confirmEditText = findViewById(R.id.confirm);
        registerbutton = findViewById(R.id.register);
        progressbar = findViewById(R.id.progress);
        login = findViewById(R.id.log);


        datesEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(CreateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        datesEditText.setText(dayOfMonth + "/" + (month + 1) + "/" +  year);
                    }
                },year,month,day);
                picker.show();
            }
        });


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
                    Toast.makeText(CreateActivity.this,"please enter your username",Toast.LENGTH_LONG).show();
                    user_nameEditText.setError("user name is required");
                    user_nameEditText.requestFocus();
                } else if (TextUtils.isEmpty(textemail)) {
                    Toast.makeText(CreateActivity.this,"please enter your email",Toast.LENGTH_LONG).show();
                    emailEditText.setError("Email is required");
                    emailEditText.requestFocus();

                } else if (!Patterns.EMAIL_ADDRESS.matcher(textemail).matches()) {
                    Toast.makeText(CreateActivity.this,"please re-enter your email",Toast.LENGTH_LONG).show();
                    emailEditText.setError("Valid Email is required");
                    emailEditText.requestFocus();
                } else if (TextUtils.isEmpty(textdates)) {
                    Toast.makeText(CreateActivity.this,"please enter your date of birth",Toast.LENGTH_LONG).show();
                    datesEditText.setError("Date of birth is required");
                    datesEditText.requestFocus();

                } else if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(CreateActivity.this,"please enter your password",Toast.LENGTH_LONG).show();
                    passwordEditText.setError("password is required");
                    passwordEditText.requestFocus();

                } else if (pass.length() < 6) {
                    Toast.makeText(CreateActivity.this,"password should be grater than6 digits",Toast.LENGTH_LONG).show();
                    passwordEditText.setError("password is weak");
                    passwordEditText.requestFocus();

                } else if (TextUtils.isEmpty(copass)) {
                    Toast.makeText(CreateActivity.this,"please confirm your password",Toast.LENGTH_LONG).show();
                    confirmEditText.setError("password confirmation is required");
                    confirmEditText.requestFocus();

                } else if (!pass.equals(copass)) {
                    Toast.makeText(CreateActivity.this,"please type same password",Toast.LENGTH_LONG).show();
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
        //create user profile
        auth.createUserWithEmailAndPassword(textemail,pass).addOnCompleteListener(CreateActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            FirebaseUser firebaseUser = auth.getCurrentUser();

                            //enter user data into firebase database
                            ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(textusername,textemail,textdates,pass,copass);

                            //extracting user references from database
                            DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Registered user");

                            referenceProfile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()){


                                        //send verification email
                                        firebaseUser.sendEmailVerification();

                                        Toast.makeText(CreateActivity.this,"user registered successfully. please verify your email",Toast.LENGTH_LONG).show();


                                        /*                //open user profile after successful
                                        Intent intent = new Intent(CreateActivity.this,UserProfileActivity.class);
                                                // to  prevent user from returning bck to register activity on pressing back button after registration
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();    //to close register activity  */



                                    }else {
                                        Toast.makeText(CreateActivity.this,"user registered failed. please try again",Toast.LENGTH_LONG).show();

                                    }
                                    //hide progress bar
                                    progressbar.setVisibility(View.GONE);

                                }
                            });



                        } else {
                              try {
                                  throw task.getException();
                              }catch(FirebaseAuthWeakPasswordException e){
                                  passwordEditText.setError("your password is weak");
                                  passwordEditText.requestFocus();
                              }catch (FirebaseAuthInvalidCredentialsException e){
                                  emailEditText.setError("your email is already in used");
                              }catch (FirebaseAuthUserCollisionException e){
                                  user_nameEditText.setError("user ia already registered");
                              }catch (Exception e){
                                  Log.e(TAG,e.getMessage());
                                  Toast.makeText(CreateActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();

                              }
                            progressbar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}