package com.example.admin.college20;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import static android.app.Activity.RESULT_OK;

public class Moi_Frag extends Fragment {
    ImageView imageView;
    FloatingActionButton floatingActionButton;
    private static final int GALLERY_INTENT = 1;
    private Uri imageUri = null;
    TextView name1, email1;

    private String uid;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.activity_moi__frag, container, false);

        imageView = (ImageView) mView.findViewById(R.id.profile_image);
        floatingActionButton = (FloatingActionButton) mView.findViewById(R.id.floatingActionButton);
        name1 = (TextView) mView.findViewById(R.id.moi_name);
        email1 = (TextView) mView.findViewById(R.id.moi_email);

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            //Go to login
        } else {
            uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference().child("Users").child(uid);

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    String req_name = user.getName();
                    String req_email = user.getEmail();
                    String req_imageUrl = user.getImageUrl();

                    name1.setText(req_name);
                    email1.setText(req_email);
                    Picasso.with(getContext()).load(req_imageUrl).into(imageView);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, GALLERY_INTENT);
            }
        });
        return mView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }

    }
}
