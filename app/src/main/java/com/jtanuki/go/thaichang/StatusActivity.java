package com.jtanuki.go.thaichang;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StatusActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button mUpdateProfileBtn;
    private TextInputLayout mStatus;
    private TextInputLayout mLocation;
    private TextInputLayout mAge;
    private TextInputLayout mPhone;
    private TextInputLayout mInterests;
    private String mGender;
    private Button mMale, mFemale;
    private ProgressDialog mProgress;


    //Firebase

    private DatabaseReference mStatusDatabase;
    private FirebaseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        String status_value = getIntent().getStringExtra("status_value");
        String location_value = getIntent().getStringExtra("location_value");
        String age_value = getIntent().getStringExtra("age_value");
        String gender_value = getIntent().getStringExtra("gender_value");;
        String phone_value = getIntent().getStringExtra("phone_value");
        String interests_value = getIntent().getStringExtra("interests_value");






        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        String currentUid = mCurrentUser.getUid();

        mProgress = new ProgressDialog(this);

        mStatusDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUid);

        mToolbar = (Toolbar) findViewById(R.id.statusAppBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Account Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mStatus = (TextInputLayout) findViewById(R.id.status_input);
        mUpdateProfileBtn = (Button) findViewById(R.id.update_profile_btn);
        mLocation = (TextInputLayout) findViewById(R.id.locationInput);
        mAge = (TextInputLayout) findViewById(R.id.ageInput);
        mMale = (Button) findViewById(R.id.MALE);
        mFemale = (Button) findViewById(R.id.FEMALE);
        mPhone = (TextInputLayout) findViewById(R.id.PhoneInput);
        mInterests = (TextInputLayout) findViewById(R.id.InterestsInput);

        mStatus.getEditText().setText(status_value);
        mLocation.getEditText().setText(location_value);
        mAge.getEditText().setText(age_value);
        mGender = gender_value;
        mPhone.getEditText().setText(phone_value);
        mInterests.getEditText().setText(interests_value);


//        mAge.getEditText().setText(age_value);
//        mPhone.getEditText().setText(phone_value);
//        mInterests.getEditText().setText(interests_value);



        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 mGender = "Male";

            }
        });

        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 mGender = "Female";
            }
        });

        mUpdateProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mProgress = new ProgressDialog(StatusActivity.this);
                mProgress.setTitle("Updating Profile");
                mProgress.setMessage("Please wait while we update your profile.");
                mProgress.show();

                String status = mStatus.getEditText().getText().toString();
                String location = mLocation.getEditText().getText().toString();
                String age = mAge.getEditText().getText().toString();
                String phone = mPhone.getEditText().getText().toString();
                String interests = mInterests.getEditText().getText().toString();
                String gender = mGender.toString();

                mStatusDatabase.child("status").setValue(status).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){

                            mProgress.dismiss();

                        } else {

                            mProgress.hide();
                            Toast.makeText(getApplicationContext(), "There was an error in updating your profile.", Toast.LENGTH_LONG).show();
                        }

                    }
                });

                mStatusDatabase.child("location").setValue(location).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){

                            mProgress.dismiss();

                        } else {

                            mProgress.hide();
                            Toast.makeText(getApplicationContext(), "There was an error in updating your profile.", Toast.LENGTH_LONG).show();
                        }

                    }
                });

                mStatusDatabase.child("age").setValue(age).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){

                            mProgress.dismiss();

                        } else {

                            mProgress.hide();
                            Toast.makeText(getApplicationContext(), "There was an error in updating your profile.", Toast.LENGTH_LONG).show();
                        }

                    }
                });

                mStatusDatabase.child("gender").setValue(gender).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){

                            mProgress.dismiss();

                        } else {

                            mProgress.hide();
                            Toast.makeText(getApplicationContext(), "There was an error in updating your profile.", Toast.LENGTH_LONG).show();
                        }

                    }
                });

                mStatusDatabase.child("phone").setValue(phone).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){

                            mProgress.dismiss();

                        } else {

                            mProgress.hide();
                            Toast.makeText(getApplicationContext(), "There was an error in updating your profile.", Toast.LENGTH_LONG).show();
                        }

                    }
                });

                mStatusDatabase.child("interests").setValue(interests).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){

                            mProgress.dismiss();

                        } else {

                            mProgress.hide();
                            Toast.makeText(getApplicationContext(), "There was an error in updating your profile.", Toast.LENGTH_LONG).show();
                        }

                    }
                });


            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){

            Intent settingsIntent = new Intent(StatusActivity.this, SettingsActivity.class);
            settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
