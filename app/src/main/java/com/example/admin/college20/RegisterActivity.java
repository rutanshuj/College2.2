package com.example.admin.college20;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity {
    private EditText mNameField;
    private EditText mEmailField;
    private EditText mPasswordField;
    private Button mRegisterButton, lookBetterBttn;
    private ProgressDialog mProgress;
    private FirebaseAuth mAuth;
    private static final int GALLERY_INTENT = 1;
    private CircleImageView circleImageView;

    private DatabaseReference mDatabase;
    Uri imageUri;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mNameField = (EditText) findViewById(R.id.nameEdit);
        mEmailField = (EditText) findViewById(R.id.emailEdit);
        mPasswordField = (EditText) findViewById(R.id.passwordEdit);
        mRegisterButton = (Button) findViewById(R.id.button);
        lookBetterBttn = (Button) findViewById(R.id.lookBetterBttn);
        circleImageView = (CircleImageView) findViewById(R.id.register_image);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

       mAuth = FirebaseAuth.getInstance();

      mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegister();
            }
        });
    }

    private void startRegister()     {
        String email = mEmailField.getText().toString().trim();
        String password = mPasswordField.getText().toString().trim();

        mProgress = new ProgressDialog(this);
        if(!TextUtils.isEmpty(mNameField.getText().toString().trim()) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) ){

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull final Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        mProgress.setMessage("Signing Up..");
                        mProgress.show();
                        String user_id = mAuth.getCurrentUser().getUid();

                        DatabaseReference current_user_db =  mDatabase.child(user_id);
                        current_user_db.child("name").setValue(mNameField.getText().toString());
                        current_user_db.child("image").setValue("default");
                        mProgress.dismiss();

                        Intent i = new Intent(RegisterActivity.this, MainPage1.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(RegisterActivity.this,"Try Again", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
