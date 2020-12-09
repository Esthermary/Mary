package com.example.esther;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Internalstorage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internalstorage);
    }


    //JAVA PART IN ANDROID
    public void saveimage(View view){
        saveReceivedImage("image");
    }
    private void saveReceivedImage(String imageName){
        try {
//            Bitmap bitmap = BitmapFactory.decodeByteArray(imageByteArray, 0, numberOfBytes);
            Drawable drawable= ContextCompat.getDrawable(Internalstorage.this,R.drawable.ic_launcher_background);
            Bitmap bitmap=Bitmap.createBitmap(drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);

            File path = new File(Internalstorage.this.getFilesDir(), "AndroidProject" + File.separator + "Images");
            if(!path.exists()){
                path.mkdirs();
            }
            File outFile = new File(path, imageName + ".jpeg");
            FileOutputStream outputStream = new FileOutputStream(outFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.close();
            Toast.makeText(this, "Image saved on your internal storage", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            Log.e("msg", "Saving received message failed with", e);
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void creatBitMap() {

        File Med = new File(Environment.getExternalStorageDirectory(), "myDirName");
        if (!Med.exists()) {
            if (Med.mkdir()) {
                Toast.makeText(this, "Directory Created", Toast.LENGTH_SHORT).show();
            } else {
                Log.d("App", "Err");
            }
        }


    }





        }

