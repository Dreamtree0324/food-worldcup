package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = new Intent(this.getIntent());

        String winfood = intent.getStringExtra("winner");
        int winimg = intent.getIntExtra("food", 0);

        TextView textView = findViewById(R.id.winfood);
        textView.setText(winfood);
        ImageView imageView = findViewById(R.id.foodimg);
        imageView.setImageResource(winimg);
    }
}
