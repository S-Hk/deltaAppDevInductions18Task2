package com.deltaappdev.inductions18.fifafixturesmanager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    Button buttonAdd, buttonCancel;
    EditText editTextTN1, editTextTN2;
    EditText editTextVenue, editTextDate, editTextTime;
    ImageView imageViewT1, imageViewT2;

    private static final int MY_CAMERA_PERMISSION_CODE = 100;
   // private static final int CAMERA_REQUEST = 1888;

    //private static final int REQUEST_CAPTURE=0;

   // private static final int PICK_IMAGE = 100;


    boolean iconSetTeamA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
/**/
        initialise();


        imageViewT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iconSetTeamA=true;
                popupMenuIcon();
            }
        });

        imageViewT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iconSetTeamA=false;
                popupMenuIcon();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAddFixture();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeFixture();
            }
        });
  /**/
    }

    public void initialise() {

        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonCancel=(Button)findViewById(R.id.buttonCancel);

        editTextTN1 = (EditText)findViewById(R.id.editTextTN1);
        editTextTN2 = (EditText)findViewById(R.id.editTextTN2);

        editTextVenue = (EditText)findViewById(R.id.editTextVenue);
        editTextDate = (EditText)findViewById(R.id.editTextDate);
        editTextTime = (EditText)findViewById(R.id.editTextTime);

        imageViewT1 = (ImageView)findViewById(R.id.imageViewT1);
        imageViewT2 = (ImageView)findViewById(R.id.imageViewT2);

    }

    public void cancelAddFixture() {

        Intent intentA = new Intent(this, MainActivity.class);
        startActivity(intentA);
        finish();
    }

    public void popupMenuIcon() {
        final PopupMenu popupMenu;

        if (iconSetTeamA) {
             popupMenu= new PopupMenu(AddActivity.this, imageViewT1);
        } else {
             popupMenu= new PopupMenu(AddActivity.this, imageViewT2);
        }

        popupMenu.getMenuInflater().inflate(R.menu.set_icon_menu, popupMenu.getMenu());


        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(AddActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                int selectedItemID = item.getItemId();

                switch (selectedItemID) {
                    case R.id.optionCamera:
                        captureCamImage();
                        Toast.makeText(AddActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.optionGallery:
                        captureGalleryImage();
                        break;

                }
                return true;
                //return false;
            }


        });





        popupMenu.show();
    }

    /*
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int selectedItemID = item.getItemId();

        switch (selectedItemID) {
            case R.id.optionCamera:
                captureCamImage();
                Toast.makeText(AddActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.optionGallery:
                captureGalaryImage();
                break;

        }
        return super.onContextItemSelected(item);
    }
    */


    public void captureCamImage() {

        // startCamCapture();

        if (Build.VERSION.SDK_INT >= 23) {

            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera permission requesting...", Toast.LENGTH_LONG).show();
                requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                startCamCapture();
            } else {
                startCamCapture();
            }

        } else {
            startCamCapture();
        }

    }

    public void startCamCapture() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        //startActivityForResult(cameraIntent, CAMERA_REQUEST);
        startActivityForResult(cameraIntent, 0);


        /*
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //startActivityForResult(intent, 0);
        startActivityForResult(intent, REQUEST_CAPTURE);
        */
    }


    public void captureGalleryImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        //startActivityForResult(intent, PICK_IMAGE);
        startActivityForResult(intent, 1);
    }




/*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "Camera permission granted", Toast.LENGTH_LONG).show();

                //startCamCapture();

            } else {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_LONG).show();

                /*
                if (Build.VERSION.SDK_INT >= 23) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                }
                startCamCapture();
                */
/*
            }

        }
    }
*/

/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");

        if (iconSetTeamA) {
            imageViewT1.setImageBitmap(bitmap);
        } else {
            imageViewT2.setImageBitmap(bitmap);
        }

    }
*/
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        Toast.makeText(this, "ACTIVITY RESULT", Toast.LENGTH_LONG).show();
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    if (iconSetTeamA) {
                        imageViewT1.setImageURI(selectedImage);
                    } else {
                        imageViewT2.setImageURI(selectedImage);
                    }
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    if (iconSetTeamA) {
                        imageViewT1.setImageURI(selectedImage);
                    } else {
                        imageViewT2.setImageURI(selectedImage);
                    }
                }
                break;
        }
    }

    public void storeFixture(){


    }



}
