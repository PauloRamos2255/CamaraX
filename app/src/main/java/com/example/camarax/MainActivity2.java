package com.example.camarax;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_IMAGE_BITMAP = "extra_image_bitmap";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Obtener el Bitmap de los extras del Intent
        if (getIntent().hasExtra(EXTRA_IMAGE_BITMAP)) {
            Bitmap bitmap = getIntent().getParcelableExtra(EXTRA_IMAGE_BITMAP);

            // Hacer algo con el Bitmap, como mostrarlo en un ImageView
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmap);
        }
    }
}