package com.app.monika.acms_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class TTSActivity extends AppCompatActivity {

    TextToSpeech tts;
    EditText enteredText;
    Button convertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);
        enteredText = (EditText) findViewById(R.id.entered_text);
        convertBtn = (Button) findViewById(R.id.convert);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.UK);
                }
            }
        });
    }

    public void convertToSpeech(View view){
        String toSpeech = enteredText.getText().toString();
        tts.speak(toSpeech, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onPause(){
        if(tts!=null){
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }
}
