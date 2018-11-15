package com.example.happyparakeet.piglatintranslator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class InputToTranslate extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_to_translate);
    }
    /** Called when the user taps the Send button */
    public void submit(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TranslatedScreen.class);
        EditText editText = (EditText) findViewById(R.id.input_text);
        String message = editText.getText().toString();
        intent.putExtra("translated", translateSentence(message));
        intent.putExtra("input", message);
        startActivity(intent);
    }

    public String translateSentence(String input) {
        String[] split_message =  input.split(" ");
        String[] translatedWords = new String[split_message.length];
        for (int i = 0; i<split_message.length; i++) {
            translatedWords[i] = translateWord(split_message[i]);
        }
        return String.join(" ", translatedWords);
    }
    public String translateWord(String word) {
        char punctuation = ' ';
        if (".!?,;:".indexOf(word.charAt(word.length() - 1)) > -1) {
            punctuation = word.charAt(word.length() - 1);
            word = word.substring(0, word.length() -1);
        }
        if ("aeiou".indexOf(word.charAt(0)) < 0) {
            word = word.substring(1, word.length()) + word.charAt(0);
        }
        String output = word + "ay";
        if (punctuation != ' ') {
            output = output + punctuation;
        }
        return output;
    }
}
