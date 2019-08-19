package com.example.registerapp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

public class GalleryFragment extends Fragment {
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;

    private static final int pic_id = 123;
Button btn1,btn2;
    ImageView click_image_id;
    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);

        btn1=(Button)view.findViewById(R.id.capture);
        btn2=(Button)view.findViewById(R.id.select);
    click_image_id=(ImageView) view.findViewById(R.id.click_image);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, pic_id);


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);

            }
        });

        return  view;
    }

    public void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == pic_id) {
            Bitmap photo = (Bitmap) data.getExtras()
                    .get("data");

            click_image_id.setImageBitmap(photo);
        }
        try {
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getActivity().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();

                click_image_id.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
            } else {

                Toast.makeText(getContext(), "You haven't picked Image", Toast.LENGTH_LONG).show();


            }
        } catch (Exception e) {

            Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_LONG).show();

        }

    }


}


