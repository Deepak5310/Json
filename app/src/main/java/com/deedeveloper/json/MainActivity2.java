package com.deedeveloper.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        textView.setText(getIntent().getStringExtra("Name"));
        imageView.setImageResource(getIntent().getIntExtra("Image",0));
    }
}