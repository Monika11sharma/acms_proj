package com.app.monika.acms_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button STTBtn, TSSBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        STTBtn = (Button) findViewById(R.id.STT);
        TSSBtn = (Button) findViewById(R.id.TTS);
    }

    public void startTTS(View view){
        Intent intent = new Intent(this, TTSActivity.class);
        startActivity(intent);
    }

    public void startSTT(View view){
        Intent intent = new Intent(this, STTActivity.class);
        startActivity(intent);
    }
}
