package com.example.happyparakeet.piglatintranslator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TranslatedScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translated_screen);
        String translatedmessage = getIntent().getStringExtra("translated");
        String input = getIntent().getStringExtra("input");
        TextView output_look_code = (TextView) findViewById(R.id.output_look);
        output_look_code.setText(translatedmessage);
        TextView input_text = (TextView) findViewById(R.id.input_text);
        input_text.setText(input);
    }
}
